package com.androidizate.clase8;

import android.util.Log;

import com.androidizate.clase8.dao.Photo;
import com.androidizate.clase8.dao.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainPresenter {

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
            loadUsers();
            loadPhotos();
        } else {
            view.createAlert(view.getNoConnectionErrorString());
        }
    }

    private void loadPhotos() {
        model.downloadPhotos(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (view != null && response.isSuccessful() && response.body() != null) {
                    for (Photo photo : response.body()) {
                        Log.d("PHOTO: ", photo.getTitle());
                    }
                    view.createAlert("Trajo");
                } else {
                    view.createAlert("NO trajo");
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                if (view != null) {
                    view.createAlert(t.getMessage());
                }
            }
        });
    }

    private void loadUsers() {
        model.downloadUsers(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (view != null && response.isSuccessful()) {
                    view.loadData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>>  call, Throwable t) {
                if (view != null) {
                    view.createAlert(t.getMessage());
                }
            }
        });
    }

    public void setView(MainView view) {
        this.view = view;
    }
}
