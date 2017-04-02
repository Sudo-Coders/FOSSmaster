package com.hackathon.sudocoders.fossmaster.Model;

import android.util.StringBuilderPrinter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arpit on 2/4/17.
 */

public class ReadmeModel {

    @SerializedName("readme")
    private String readme;

    @SerializedName("msg")
    private String msg;

    @SerializedName("success")
    private boolean success;

    @SerializedName("full_name")
    private String full_name;

    @SerializedName("desc")
    private String desc;

    @SerializedName("language")
    private String language;

    @SerializedName("stars")
    private String stars;

    @SerializedName("forks")
    private String forks;

    @SerializedName("repo_url")
    private String repo_url;

    public ReadmeModel(String readme, String msg, boolean success, String full_name, String desc, String language, String stars, String forks, String repo_url) {
        this.readme = readme;
        this.msg = msg;
        this.success = success;
        this.full_name = full_name;
        this.desc = desc;
        this.language = language;
        this.stars = stars;
        this.forks = forks;
        this.repo_url = repo_url;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getRepo_url() {
        return repo_url;
    }

    public void setRepo_url(String repo_url) {
        this.repo_url = repo_url;
    }
}
