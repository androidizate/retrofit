package com.androidizate.clase8.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtils(
    private val context: Context
) {

    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
