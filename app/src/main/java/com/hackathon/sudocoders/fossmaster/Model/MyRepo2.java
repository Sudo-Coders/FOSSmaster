package com.hackathon.sudocoders.fossmaster.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 31/3/17.
 */

public class MyRepo2 {
    @SerializedName("success")
    private boolean success;
    @SerializedName("response")
    private ArrayList<MyRepo> users;

    public MyRepo2(ArrayList<MyRepo> users, boolean success) {
        this.users = users;
        this.success = success;
    }

    public ArrayList<MyRepo> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<MyRepo> users) {
        this.users = users;
    }

}
