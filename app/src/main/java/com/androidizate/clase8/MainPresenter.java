package com.androidizate.clase8;

import com.androidizate.clase8.dao.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainPresenter implements Callback<List<User>> {

    MainView view;
    MainModel model;

    public MainPresenter() {
        model = new MainModel();
    }

    public void onResume() {
        if (view == null) {
            return;
        }

        if (view.isNetworkConnected()) {
            model.downloadInfo(this);
        } else {
            view.createAlert(view.getNoConnectionErrorString());
        }
    }

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        if (view != null && response.isSuccessful()) {
            view.loadData(response.body());
        }
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        if (view != null) {
            view.createAlert(t.getMessage());
        }
    }

    public void setView(MainView view) {
        this.view = view;
    }
}
