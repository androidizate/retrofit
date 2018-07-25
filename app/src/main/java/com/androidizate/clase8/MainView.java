package com.androidizate.clase8;

import com.androidizate.clase8.dao.Photo;
import com.androidizate.clase8.dao.User;

import java.util.List;

interface MainView {

    boolean isNetworkConnected();

    String getNoConnectionErrorString();

    void createAlert(String message);

    void loadData(List<User> users);

    void loadPhotos(List<Photo> body);
}
