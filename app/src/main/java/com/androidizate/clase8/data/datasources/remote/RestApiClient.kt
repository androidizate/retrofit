package com.androidizate.clase8.data.datasources.remote

import com.androidizate.clase8.data.datasources.remote.dtos.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by andres.oller on 23/08/17.
 */
class RestApiClient : RestApi {

    private val service: RestApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestApi::class.java)
    }

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    override suspend fun getAllUsers(): List<UserResponse> = service.getAllUsers()

    override suspend fun createUser(userResponse: UserResponse): UserResponse = service.createUser(userResponse)

    override suspend fun updateUser(id: Long, userResponse: UserResponse): UserResponse = service.updateUser(userResponse.id, userResponse)

    override suspend fun deleteUser(id: Long) = service.deleteUser(id)

    override suspend fun getUser(id: Long): UserResponse = service.getUser(id)
}
