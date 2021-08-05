package com.androidizate.clase8.api

import com.androidizate.clase8.dtos.*
import retrofit2.Call
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
        private const val BASE_URL = "http://jsonplaceholder.typicode.com/"
    }


    override fun getAllUsers(): Call<List<User>> {
        return service.getAllUsers()
    }

    override fun getAllPosts(): Call<List<Post>> {
        return service.getAllPosts()
    }

    override fun getAllComments(queryMap: HashMap<Any, Any>?): Call<List<Comment>> {
        return service.getAllComments()
    }

    override fun getAllAlbums(): Call<List<Album>> {
       return service.getAllAlbums()
    }

    override fun getAllPhotos(): Call<List<Photo>> {
        return service.getAllPhotos()
    }

    override fun getAllTodos(): Call<List<Todo>> {
        return service.getAllTodos()
    }

    override fun getPost(uuid: Int): Call<Post> {
        TODO("Not yet implemented")
    }

    override fun getCommentsForPost(): Call<List<Comment>> {
        return service.getCommentsForPost()
    }

    override fun createUser(user: User): Call<User> {
        TODO("Not yet implemented")
    }

    override fun updateUser(uuid: Int, user: User): Call<User> {
        TODO("Not yet implemented")
    }

    override fun patchUser(uuid: Int, user: User): Call<User> {
        TODO("Not yet implemented")
    }

    override fun deleteUser(uuid: Int, user: User): Call<Unit> {
        TODO("Not yet implemented")
    }
}
