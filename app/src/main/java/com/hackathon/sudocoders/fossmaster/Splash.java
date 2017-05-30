package com.hackathon.sudocoders.fossmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;

public class Splash extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SharedPref sharedPref = new SharedPref(getApplicationContext());
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                if (!sharedPref.getLoginStatus()) {
                    Intent i = new Intent(Splash.this, LoginActivity.class);
                    startActivity(i);

                } else {
                    Intent i = new Intent(Splash.this, HomeActivity.class);
                    startActivity(i);
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}