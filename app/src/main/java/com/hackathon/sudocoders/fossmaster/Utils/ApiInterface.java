package com.hackathon.sudocoders.fossmaster.Utils;

import com.hackathon.sudocoders.fossmaster.Model.Dashboard;
import com.hackathon.sudocoders.fossmaster.Model.LoginModel;
import com.hackathon.sudocoders.fossmaster.Model.MyRepo2;
import com.hackathon.sudocoders.fossmaster.Model.OpenSourceModel;
import com.hackathon.sudocoders.fossmaster.Model.OpenSourceModel2;
import com.hackathon.sudocoders.fossmaster.Model.ReadmeModel;
import com.hackathon.sudocoders.fossmaster.Model.StarredRepos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jatin on 31/3/17.
 */

public interface ApiInterface {
    @GET("myrepo/{username}")
    Call<MyRepo2> getMyRepo(@Path("username") String username);

    @GET("starred/{username}")
    Call<StarredRepos> getStarredRepos(@Path("username") String username);

    @GET("dashboard/{username}")
    Call<Dashboard> getDashboard(@Path("username") String username);

    @FormUrlEncoded
    @POST("login/auth")
    Call<LoginModel> getLoginModel(@Field("username") String username, @Field("pswd") String pswd);

    @GET("myrepo/readme/{reponame}")
    Call<ReadmeModel> getReadme(@Path("reponame") String reponame, @Query("username") String username);

//    @GET("dashboard/repo/{reponame}")
    //  Call<>(@Query("username"))

//    @GET()

    @GET("suggested_repos/{language}")
    Call<OpenSourceModel2> getOpenSource(@Path("language") String language, @Query("level") int level);

}
