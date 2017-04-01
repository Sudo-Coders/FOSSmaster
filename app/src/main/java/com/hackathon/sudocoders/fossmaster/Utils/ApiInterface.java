package com.hackathon.sudocoders.fossmaster.Utils;

import com.hackathon.sudocoders.fossmaster.Model.Dashboard;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo2;
import com.hackathon.sudocoders.fossmaster.Model.StarredRepos;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jatin on 31/3/17.
 */

public interface ApiInterface {
    @GET("myrepo")
     Call<MyRepo2> getMyRepo();

    @GET("myrepo")
    Call<StarredRepos> getStarredRepos();

    @GET("dashboard")
    Call<Dashboard> getDashboard();

}
