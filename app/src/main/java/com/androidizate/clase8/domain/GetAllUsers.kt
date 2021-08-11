package com.androidizate.clase8.domain

import android.util.Log
import com.androidizate.clase8.repositories.datasources.local.AppDatabase
import com.androidizate.clase8.repositories.datasources.remote.RestApiClient
import com.androidizate.clase8.repositories.datasources.remote.dtos.User
import com.androidizate.clase8.repositories.datasources.remote.dtos.toDbEntity
import com.androidizate.clase8.utils.NetworkUtils

class GetAllUsers(
    private val remote: RestApiClient,
    private val local: AppDatabase,
    private val networkUtils: NetworkUtils
) {

    suspend operator fun invoke(): AppResult<List<User>> {
        if (networkUtils.isNetworkConnected()) {
            try {
                val users = remote.getAllUsers()
                users.forEach {
                    local.userDao().insertAll(it.toDbEntity())
                }
                return AppResult.Success(users)
            } catch (exception: Exception) {
                Log.e("MainActivity", exception.message.toString())
                return AppResult.Error(exception.message.toString())
            }
        } else {
            return AppResult.Error("No connection available")
        }
    }
}
