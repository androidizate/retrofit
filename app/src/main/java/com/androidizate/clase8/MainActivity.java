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

import com.androidizate.clase8.adapters.UserAdapter;
import com.androidizate.clase8.api.RestApiClient;
import com.androidizate.clase8.dao.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<User>> {

    RecyclerView recyclerView;
    RestApiClient restApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        restApiClient = new RestApiClient();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        if (!isNetworkConnected()) {
            createAlert(getString(R.string.not_connected_error));
        } else {
            downloadInfo();
        }
    }

    private void createAlert(String stringResource) {
        new AlertDialog.Builder(this)
                .setMessage(String.format(getString(R.string.error), stringResource))
                .setTitle(getString(R.string.error))
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                }).show();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private void downloadInfo() {
        restApiClient.getAllUsers().enqueue(this);
    }

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        if (response.isSuccessful()) {
            recyclerView.setAdapter(new UserAdapter(response.body()));
        }
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        createAlert(t.getMessage());
    }
}
