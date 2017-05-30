package com.hackathon.sudocoders.fossmaster.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 1/4/17.
 */

public class PullRequest {

    @SerializedName("user_name")
    private String user_name;

    @SerializedName("repo_name")
    private String repo_name;

    @SerializedName("event_time")
    private String event_time;

    @SerializedName("user_img_url")
    private String user_img_url;


}
