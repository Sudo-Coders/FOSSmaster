package com.hackathon.sudocoders.fossmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hackathon.sudocoders.fossmaster.Model.MyRepo2;
import com.hackathon.sudocoders.fossmaster.Utils.ApiInterface;
import com.hackathon.sudocoders.fossmaster.Utils.Util;

import retrofit2.Call;

public class StarredRepos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starred_repos);




    }


    public void getStarredRepos(){
        ApiInterface mApi = Util.getRetrofitService();
        Call<MyRepo2> mservice = mApi.getStarredRepos();



    }
}
