package com.androidizate.clase8

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidizate.clase8.adapters.PhotosAdapter
import com.androidizate.clase8.adapters.PostAdapter
import com.androidizate.clase8.adapters.UserAdapter
import com.androidizate.clase8.api.RestApiClient
import com.androidizate.clase8.dtos.Photo
import com.androidizate.clase8.dtos.Post
import com.androidizate.clase8.dtos.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    private fun downloadInfo() {
/*
restApiClient.getAllUsers().enqueue(object : Callback<List<User>> {
    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
        if (response.isSuccessful) {
            recycler.adapter = UserAdapter(response.body()!!)
        }
    } })


 */


        restApiClient.getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    recycler.adapter = PostAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                createAlert(t.message)
            }
        })


/*
restApiClient.getAllPhotos().enqueue(object : Callback<List<Photo>> {
   override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
       if (response.isSuccessful) {
           response.body()?.let {
               recycler.adapter = PhotosAdapter(it)
           } ?: createAlert("Error loading info")
           /* Same as above with let
           if (response.body() != null) {
               recycler.adapter = PhotosAdapter(it)
           } else {
               createAlert("Error loading info")
           }
           */
       }
   }

   override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
       createAlert(t.message)
   }


})
*/

    }
}
