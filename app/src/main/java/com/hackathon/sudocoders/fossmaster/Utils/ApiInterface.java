package com.hackathon.sudocoders.fossmaster.Utils;

import com.hackathon.sudocoders.fossmaster.Model.Dashboard;
import com.hackathon.sudocoders.fossmaster.Model.LoginModel;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo2;
import com.hackathon.sudocoders.fossmaster.Model.StarredRepos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by jatin on 31/3/17.
 */

public interface ApiInterface {
    @GET("myrepo")
     Call<MyRepo2> getMyRepo();

    @GET("myrepo/{jatin0312}")
    Call<StarredRepos> getStarredRepos();

    @GET("dashboard")
    Call<Dashboard> getDashboard();

    @FormUrlEncoded
    @POST("login/auth")
    Call<LoginModel> getLoginModel(@Field("username") String username, @Field("pswd") String pswd);

}
