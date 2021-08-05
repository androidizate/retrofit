package com.androidizate.clase8

import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidizate.clase8.adapters.UserAdapter
import com.androidizate.clase8.api.RestApiClient
import com.androidizate.clase8.dtos.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<User>> {
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
            .setMessage(java.lang.String.format(getString(R.string.error), stringResource))
            .setTitle(getString(R.string.error))
            .setPositiveButton(
                R.string.ok,
                DialogInterface.OnClickListener { dialogInterface, i -> this@MainActivity.finish() }
            )
            .show()
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun downloadInfo() {
        restApiClient.getAllUsers().enqueue(this)
    }

    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
        if (response.isSuccessful) {
            recycler.adapter = UserAdapter(response.body()!!)
        }
    }

    override fun onFailure(call: Call<List<User>>, t: Throwable) {
        createAlert(t.message)
    }
}
