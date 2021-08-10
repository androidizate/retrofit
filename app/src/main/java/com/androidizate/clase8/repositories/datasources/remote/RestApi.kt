package com.androidizate.clase8.repositories.datasources.remote

import com.androidizate.clase8.repositories.datasources.remote.dtos.*
import retrofit2.http.*

/**
 * Created by andres.oller on 23/08/17.
 */
interface RestApi {
    @GET("users")
    suspend fun getAllUsers(): List<User>

    @GET("posts")
    suspend fun getAllPosts(): List<Post>

    @GET("comments")
    suspend fun getAllComments(
        @QueryMap queryMap: HashMap<Any, Any>? = null
    ): List<Comment>

    @GET("albums")
    suspend fun getAllAlbums(): List<Album>

    @GET("photos")
    suspend fun getAllPhotos(): List<Photo>

    @GET("todos")
    suspend fun getAllTodos(): List<Todo>

    @GET("posts/{uuid}")
    suspend fun getPost(@Path(value = "uuid") uuid: Int): Post

    @GET("posts/{uuid}/comments")
    suspend fun getCommentsForPost(@Path(value = "uuid") uuid: Int): List<Comment>

    @POST("users")
    suspend fun createUser(@Body user: User): User

    @PUT("users/{uuid}")
    suspend fun updateUser(
        @Path(value = "uuid") uuid: Int,
        @Body user: User
    ): User

    @PATCH("users/{uuid}")
    suspend fun patchUser(
        @Path(value = "uuid") uuid: Int,
        @Body user: User
    ): User

    @DELETE("users/{uuid}")
    suspend fun deleteUser(
        @Path(value = "uuid") uuid: Int,
        @Body user: User
    )
}
