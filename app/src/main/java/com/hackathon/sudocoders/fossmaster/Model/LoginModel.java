package com.hackathon.sudocoders.fossmaster.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jatin on 2/4/17.
 */

public class LoginModel {

    @SerializedName("success")
    private boolean success;

    @SerializedName("msg")
    private String msg;

    @SerializedName("username")
    private String username;


    public LoginModel(boolean success, String msg, String username) {
        this.success = success;
        this.msg = msg;
        this.username = username;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
