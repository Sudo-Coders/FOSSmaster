package com.hackathon.sudocoders.fossmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.hackathon.sudocoders.fossmaster.Model.LoginModel;
import com.hackathon.sudocoders.fossmaster.Utils.ApiInterface;
import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;
import com.hackathon.sudocoders.fossmaster.Utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPass;
    private Button loginBtn;
    private ProgressBar progressBar;
    String uname = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editPass = (EditText) findViewById(R.id.editPass);
        editUsername = (EditText) findViewById(R.id.editUsername);
        progressBar = (ProgressBar) findViewById(R.id.progress);


        loginBtn = (Button) findViewById(R.id.loginBtn);

    }

    public void loginGithub(View v) {

        editUsername.setVisibility(View.GONE);
        editPass.setVisibility(View.GONE);
        loginBtn.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        uname = editUsername.toString();
        System.out.println("hello wor " + uname + "hell");
        getLoginModel(editUsername.getText().toString(), editPass.getText().toString());


    }

    public void getLoginModel(String username, String pswd) {
        System.out.println("hello world");
        ApiInterface mApi = Util.getRetrofitService();
        Call<LoginModel> mservice = mApi.getLoginModel(username, pswd);

        mservice.enqueue(new Callback<LoginModel>() {

            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                if (response != null && response.isSuccess()) {

                    String username = response.body().getUsername();
                    SharedPref sp = new SharedPref(getApplicationContext());
                    sp.setLoginStatus(true);
                    sp.setUserName(username);
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                } else {
                    Toast.makeText(LoginActivity.this, "Some Problem is there", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    editUsername.setVisibility(View.GONE);
                    editPass.setVisibility(View.GONE);
                    loginBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                editUsername.setVisibility(View.GONE);
                editPass.setVisibility(View.GONE);
                loginBtn.setVisibility(View.GONE);
            }
        });

    }


}
