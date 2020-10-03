package com.androidizate.clase8.api

import com.androidizate.clase8.dtos.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by andres.oller on 23/08/17.
 */
class RestApiClient : RestApi {
    override fun getAllUsers(): Call<List<User>> {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(RestApi::class.java).getAllUsers()
    }

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}