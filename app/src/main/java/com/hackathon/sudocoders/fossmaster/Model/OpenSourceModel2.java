package com.hackathon.sudocoders.fossmaster.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 2/4/17.
 */

public class OpenSourceModel2 {

    @SerializedName("success")
    private boolean success;
    @SerializedName("response")
    private ArrayList<OpenSourceModel> users;

    public OpenSourceModel2(boolean success, ArrayList<OpenSourceModel> users) {
        this.success = success;
        this.users = users;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<OpenSourceModel> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<OpenSourceModel> users) {
        this.users = users;
    }
}
