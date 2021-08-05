package com.androidizate.clase8

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidizate.clase8.adapters.UserAdapter
import com.androidizate.clase8.api.RestApiClient
import com.androidizate.clase8.dtos.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.lang.String.*

class MainActivity : AppCompatActivity() {
    private val restApiClient = RestApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = linearLayoutManager
        if (!isNetworkConnected()) {
            createAlert(getString(R.string.not_connected_error))
        } else {
            downloadInfo()
        }
    }

    private fun createAlert(stringResource: String?) {
        AlertDialog.Builder(this)
            .setMessage(format(getString(R.string.error), stringResource))
            .setTitle(getString(R.string.error))
            .setPositiveButton(R.string.ok) { _, i -> this@MainActivity.finish() }
            .show()
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun downloadInfo() = lifecycleScope.launch(Dispatchers.Main) {
        progressBar.isVisible = true
        var users = emptyList<User>()
        try {
            users = withContext(Dispatchers.IO) {
                restApiClient.getAllUsers()
            }
        } catch (exception: Exception) {
            Log.e("MainActivity", exception.message.toString())
        }
        recycler.adapter = UserAdapter(users)
        progressBar.isVisible = false
    }
}
