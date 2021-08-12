package com.androidizate.clase8.data.datasources.remote

import com.androidizate.clase8.data.datasources.remote.dtos.UserResponse
import retrofit2.http.*

/**
 * Created by andres.oller on 23/08/17.
 */
interface RestApi {
    @GET("users")
    suspend fun getAllUsers(): List<UserResponse>

    /*@GET("posts")
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
    suspend fun getCommentsForPost(@Path(value = "uuid") uuid: Int): List<Comment>*/

    @GET("users/{id}")
    suspend fun getUser(@Path(value = "id") id: Long): UserResponse

    @POST("users")
    suspend fun createUser(@Body userResponse: UserResponse): UserResponse

    @PUT("users/{id}")
    suspend fun updateUser(
        @Path(value = "id") id: Long,
        @Body userResponse: UserResponse
    ): UserResponse

    @DELETE("users/{id}")
    suspend fun deleteUser(
        @Path(value = "id") id: Long
    )
}
