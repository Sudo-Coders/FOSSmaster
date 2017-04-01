package com.hackathon.sudocoders.fossmaster.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 1/4/17.
 */

public class DashboardUserDetail {

    @SerializedName("type")
    String type;

    @SerializedName("user_name")
    String user_name;

    @SerializedName("user_img_url")
    String user_image_url;

    @SerializedName("repo_name")
    String repo_name;

    @SerializedName("event_time")
    String time;

    public DashboardUserDetail(String type, String user_name, String user_image_url, String repo_name, String time) {
        this.type = type;
        this.user_name = user_name;
        this.user_image_url = user_image_url;
        this.repo_name = repo_name;
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public String getRepo_name() {
        return repo_name;
    }

    public String getTime() {
        return time;
    }
}
