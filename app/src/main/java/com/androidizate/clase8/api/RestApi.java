package com.androidizate.clase8.api;

import com.androidizate.clase8.dao.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andres.oller on 23/08/17.
 */
public interface RestApi {

    @GET("users")
    Call<List<User>> getAllUsers();
}
