package com.androidizate.clase8.api

import com.androidizate.clase8.dtos.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by andres.oller on 23/08/17.
 */
interface RestApi {
    @GET("users")
    fun getAllUsers(): Call<List<User>>
}