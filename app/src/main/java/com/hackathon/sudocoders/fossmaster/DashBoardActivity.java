package com.hackathon.sudocoders.fossmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hackathon.sudocoders.fossmaster.Adapter.DashboardAdapter;
import com.hackathon.sudocoders.fossmaster.Adapter.MyreposAdapter;
import com.hackathon.sudocoders.fossmaster.Model.DashboardUserDetail;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo;
import com.hackathon.sudocoders.fossmaster.Model.Dashboard;
import com.hackathon.sudocoders.fossmaster.Utils.ApiInterface;
import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;
import com.hackathon.sudocoders.fossmaster.Utils.Util;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;
    private Toolbar toolbar;
    ProgressBar progressBar;
    private ArrayList<DashboardUserDetail> users;

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
        getSupportActionBar().setTitle("Dashboard");

        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        recyclerView.setLayoutManager(layoutManager);
        progressBar.setVisibility(View.VISIBLE);
        getDashboard(sharedPref.getUserName());


    }


    public void getDashboard(String username) {
        ApiInterface mApi = Util.getRetrofitService();
        Call<Dashboard> mservice = mApi.getDashboard(username);
        mservice.enqueue(new Callback<Dashboard>() {

            @Override
            public void onResponse(Call<Dashboard> call, Response<Dashboard> response) {
                if (response != null && response.isSuccess()) {
                    users = response.body().getFeed();

                    progressBar.setVisibility(View.GONE);
                    adapter = new DashboardAdapter(users, getApplicationContext());

                    recyclerView.setAdapter(adapter);

                } else {
                    Toast.makeText(DashBoardActivity.this, "Some Problem is there", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<Dashboard> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });

    }


}
