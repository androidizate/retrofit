package com.androidizate.clase8.domain.usecases

import android.util.Log
import com.androidizate.clase8.data.repository.user.UserLocalRepository
import com.androidizate.clase8.data.repository.user.UserRemoteRepository
import com.androidizate.clase8.domain.AppResult
import com.androidizate.clase8.domain.entities.User
import com.androidizate.clase8.utils.NetworkUtils

class GetAllUsers(
    private val remote: UserRemoteRepository,
    private val local: UserLocalRepository,
    private val networkUtils: NetworkUtils
) {

    suspend operator fun invoke(): AppResult<List<User>> {
        if (networkUtils.isNetworkConnected()) {
            try {
                val users = remote.getAllUsers()
                users.forEach { user ->
                    local.createUser(user)
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
