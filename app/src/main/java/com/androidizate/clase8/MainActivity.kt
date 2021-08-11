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
import com.androidizate.clase8.adapters.PostAdapter
import com.androidizate.clase8.adapters.UserAdapter
import com.androidizate.clase8.repositories.datasources.local.AppDatabase
import com.androidizate.clase8.repositories.datasources.remote.RestApiClient
import com.androidizate.clase8.repositories.datasources.remote.dtos.User
import com.androidizate.clase8.repositories.datasources.remote.dtos.toDbEntity
import com.androidizate.clase8.repositories.datasources.remote.dtos.toUser
import com.androidizate.clase8.repositories.datasources.remote.dtos.toPost
import com.androidizate.clase8.repositories.datasources.remote.dtos.Post
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
            getLocalData()
        } else {
            downloadInfo()
        }
    }

    private fun getLocalData() = lifecycleScope.launch {
        val posts =
            AppDatabase.getInstance(applicationContext).postDao().getAll().map { postEntity ->
                postEntity.toPost()
            }
        recycler.adapter = PostAdapter(posts)
        progressBar.isVisible = false
    }

    private fun createAlert(stringResource: String?) {
        AlertDialog.Builder(this)
            .setMessage(format(getString(R.string.error), stringResource))
            .setTitle(getString(R.string.error))
            .setPositiveButton(R.string.ok) { dialog, i -> dialog.dismiss() }
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
        var posts = emptyList<Post>()
        try {
            posts = withContext(Dispatchers.IO) {
                restApiClient.getAllPosts()
            }
            posts.forEach {
                AppDatabase.getInstance(applicationContext).postDao().insertAll(it.toDbEntity())
            }
        } catch (exception: Exception) {
            Log.e("MainActivity", exception.message.toString())
        }
        recycler.adapter = PostAdapter(posts)
        progressBar.isVisible = false
    }
}
