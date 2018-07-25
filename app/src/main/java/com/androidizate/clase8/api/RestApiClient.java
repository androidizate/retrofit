package com.androidizate.clase8.api;

import com.androidizate.clase8.dao.Photo;
import com.androidizate.clase8.dao.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andres.oller on 23/08/17.
 */

public class RestApiClient implements RestApi {

    Retrofit retrofit;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public RestApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public Call<List<User>> getAllUsers() {
        return retrofit.create(RestApi.class).getAllUsers();
    }

    @Override
    public Call<List<Photo>> getAllPhotos() {
        return retrofit.create(RestApi.class).getAllPhotos();
    }
}
