package com.androidizate.clase8.api

import com.androidizate.clase8.dtos.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by andres.oller on 23/08/17.
 */
interface RestApi {
    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("posts")
    fun getAllPosts(): Call<List<Post>>

    @GET("comments")
    fun getAllComments(
        @QueryMap queryMap: HashMap<Any, Any>? = null
    ): Call<List<Comment>>

    @GET("albums")
    fun getAllAlbums(): Call<List<Album>>

    @GET("photos")
    fun getAllPhotos(): Call<List<Photo>>

    @GET("todos")
    fun getAllTodos(): Call<List<Todo>>

    @GET("posts/{uuid}")
    fun getPost(@Path(value = "uuid") uuid: Int): Call<Post>

    @GET("posts/{uuid}/comments")
    fun getCommentsForPost(@Path(value = "uuid") uuid: Int): Call<List<Comment>>

    @POST("users")
    fun createUser(@Body user: User): Call<User>

    @PUT("users/{uuid}")
    fun updateUser(
        @Path(value = "uuid") uuid: Int,
        @Body user: User
    ): Call<User>

    @PATCH("users/{uuid}")
    fun patchUser(
        @Path(value = "uuid") uuid: Int,
        @Body user: User
    ): Call<User>

    @DELETE("users/{uuid}")
    fun deleteUser(
        @Path(value = "uuid") uuid: Int,
        @Body user: User
    ): Call<Unit>
}
