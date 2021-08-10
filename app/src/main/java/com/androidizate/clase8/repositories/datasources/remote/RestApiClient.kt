package com.androidizate.clase8.repositories.datasources.remote

import com.androidizate.clase8.repositories.datasources.remote.dtos.*
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

    override suspend fun getAllUsers(): List<User> = service.getAllUsers()

    override suspend fun getAllPosts(): List<Post> = service.getAllPosts()

    override suspend fun getAllComments(queryMap: HashMap<Any, Any>?): List<Comment> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllAlbums(): List<Album> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllPhotos(): List<Photo> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTodos(): List<Todo> {
        TODO("Not yet implemented")
    }

    override suspend fun getPost(uuid: Int): Post {
        TODO("Not yet implemented")
    }

    override suspend fun getCommentsForPost(uuid: Int): List<Comment> {
        TODO("Not yet implemented")
    }

    override suspend fun createUser(user: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(uuid: Int, user: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun patchUser(uuid: Int, user: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(uuid: Int, user: User) {
        TODO("Not yet implemented")
    }


}
