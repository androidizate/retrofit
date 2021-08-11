package com.androidizate.clase8.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidizate.clase8.R
import com.androidizate.clase8.presentation.adapters.UserAdapter
import com.androidizate.clase8.databinding.ActivityMainBinding
import com.androidizate.clase8.domain.GetAllUsers
import com.androidizate.clase8.presentation.main.MainUIState.*
import com.androidizate.clase8.repositories.datasources.local.AppDatabase
import com.androidizate.clase8.repositories.datasources.remote.RestApiClient
import com.androidizate.clase8.repositories.datasources.remote.dtos.User
import com.androidizate.clase8.utils.NetworkUtils
import java.lang.String.format

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // We first create our view model
        viewModel = MainViewModel(
            GetAllUsers(
                RestApiClient(),
                AppDatabase.getInstance(applicationContext),
                NetworkUtils(applicationContext)
            )
        )

        // We instantiate a new binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the binding as the main activity layout
        setContentView(binding.root)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = linearLayoutManager

        viewModel.uiState.observe(this, ::render)

        viewModel.onCreate()
    }

    private fun render(state: MainUIState) {
        binding.progressBar.isVisible = state is LoadingState
        when (state) {
            is ErrorState -> renderErrorState(state.message)
            LoadingState -> renderLoadingState()
            is SuccessState -> renderSuccessState(state.users)
        }
    }

    private fun renderErrorState(message: String) {
        createAlert(message)
    }

    private fun renderLoadingState() {
        binding.recycler.isVisible = false
    }

    private fun renderSuccessState(users: List<User>) {
        if (users.isEmpty()) {
            createAlert("No results")
        } else {
            binding.recycler.isVisible = true
            binding.recycler.adapter = UserAdapter(users)
        }
    }

    private fun createAlert(stringResource: String?) {
        AlertDialog.Builder(this)
            .setMessage(format(getString(R.string.error), stringResource))
            .setTitle("Error")
            .setPositiveButton(R.string.ok) { dialog, i -> dialog.dismiss() }
            .show()
    }
}
