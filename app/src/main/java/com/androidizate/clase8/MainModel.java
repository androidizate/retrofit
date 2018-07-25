package com.androidizate.clase8;

import com.androidizate.clase8.api.RestApiClient;
import com.androidizate.clase8.dao.Photo;
import com.androidizate.clase8.dao.User;

import java.util.List;

import retrofit2.Callback;

class MainModel {

    RestApiClient restApiClient;

    public MainModel() {
        restApiClient = new RestApiClient();
    }

    public void downloadUsers(Callback<List<User>> callback) {
        restApiClient.getAllUsers().enqueue(callback);
    }

    public void downloadPhotos(Callback<List<Photo>> callback) {
        restApiClient.getAllPhotos().enqueue(callback);
    }
}
