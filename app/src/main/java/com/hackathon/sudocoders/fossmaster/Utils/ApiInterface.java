package com.hackathon.sudocoders.fossmaster.Utils;

import com.hackathon.sudocoders.fossmaster.Model.MyRepo2;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jatin on 31/3/17.
 */

public interface ApiInterface {
    @GET("myrepo")
     Call<MyRepo2> getMyRepo();

    @GET("mystars")
    Call<MyRepo2> getStarredRepos();

}
