package com.androidizate.clase8;

import com.androidizate.clase8.dao.User;

import java.util.List;

interface MainView {

    boolean isNetworkConnected();

    String getNoConnectionErrorString();

    void createAlert(String message);

    void loadData(List<User> users);

    void clearData();
}
