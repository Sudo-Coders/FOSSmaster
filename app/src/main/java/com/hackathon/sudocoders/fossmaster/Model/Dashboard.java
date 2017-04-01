package com.hackathon.sudocoders.fossmaster.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 1/4/17.
 */

public class Dashboard {

    @SerializedName("success")
    private boolean success;

    @SerializedName("msg")
    private boolean msg;

    @SerializedName("dashboard")
    private ArrayList<Dashboard> feed;

    public Dashboard(boolean success, boolean msg, ArrayList<Dashboard> feed) {
        this.success = success;
        this.msg = msg;
        this.feed = feed;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isMsg() {
        return msg;
    }

    public ArrayList<Dashboard> getFeed() {
        return feed;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(boolean msg) {
        this.msg = msg;
    }

    public void setFeed(ArrayList<Dashboard> feed) {
        this.feed = feed;
    }
}
