package com.hackathon.sudocoders.fossmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hackathon.sudocoders.fossmaster.Adapter.MyreposAdapter;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo2;
import com.hackathon.sudocoders.fossmaster.Utils.ApiInterface;
import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;
import com.hackathon.sudocoders.fossmaster.Utils.Util;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepositories extends AppCompatActivity {

    private ArrayList<MyRepo> users;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;
    private Toolbar toolbar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        progressBar = (ProgressBar) findViewById(R.id.leader_progress);
        SharedPref sharedPref = new SharedPref(getApplicationContext());


        recyclerView = (RecyclerView) findViewById(R.id.repo_recycler);
      /*  NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        toolbar = (Toolbar) findViewById(R.id.myrepo_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Repositories");

        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new MyreposAdapter(users, getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        progressBar.setVisibility(View.VISIBLE);
        getMyRepo(sharedPref.getUserName());


    }

    public void getMyRepo(String username) {

        ApiInterface mApi = Util.getRetrofitService();
        Call<MyRepo2> mservice = mApi.getMyRepo(username);
        System.out.println("help me");
        mservice.enqueue(new Callback<MyRepo2>() {

            @Override
            public void onResponse(Call<MyRepo2> call, Response<MyRepo2> response) {
                if (response != null && response.isSuccess()) {
                    users = response.body().getUsers();

                    progressBar.setVisibility(View.GONE);
                    adapter = new MyreposAdapter(users, getApplicationContext());

                    recyclerView.setAdapter(adapter);

                } else {
                    Toast.makeText(MyRepositories.this, "Some Problem is there", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<MyRepo2> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });

    }


}
