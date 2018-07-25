package com.androidizate.clase8;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TouchDelegate;

import com.androidizate.clase8.adapters.UserAdapter;
import com.androidizate.clase8.dao.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    RecyclerView recyclerView;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        presenter = new MainPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.setView(null);
    }

    @Override
    public void createAlert(String message) {
        new AlertDialog.Builder(this)
                .setMessage(String.format(getString(R.string.error), message))
                .setTitle(getString(R.string.error))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                }).show();
    }

    @Override
    public void loadData(List<User> users) {
        recyclerView.setAdapter(new UserAdapter(users));
    }

    @Override
    public void clearData() {
        // NO OP
    }

    @Override
    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    public String getNoConnectionErrorString() {
        return getString(R.string.not_connected_error);
    }
}
