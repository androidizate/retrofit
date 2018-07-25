package com.androidizate.clase8;

import com.androidizate.clase8.api.RestApiClient;
import com.androidizate.clase8.dao.User;

import java.util.List;

import retrofit2.Callback;

class MainModel {

    RestApiClient restApiClient;

    public MainModel() {
        restApiClient = new RestApiClient();
    }

    public void downloadInfo(Callback<List<User>> callback) {
        restApiClient.getAllUsers().enqueue(callback);
    }
}
