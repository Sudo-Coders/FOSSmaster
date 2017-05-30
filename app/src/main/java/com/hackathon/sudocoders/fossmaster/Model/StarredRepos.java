package com.hackathon.sudocoders.fossmaster.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jatin on 1/4/17.
 */

public class StarredRepos {

    @SerializedName("success")
    private boolean success;
    @SerializedName("response")
    private ArrayList<StarredReposDetails> users;

    public StarredRepos(ArrayList<StarredReposDetails> users, boolean success) {
        this.users = users;
        this.success = success;
    }

    public ArrayList<StarredReposDetails> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<StarredReposDetails> users) {
        this.users = users;
    }

}
