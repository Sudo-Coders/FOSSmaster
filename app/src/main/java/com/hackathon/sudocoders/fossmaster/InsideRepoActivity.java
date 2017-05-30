package com.hackathon.sudocoders.fossmaster;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.sudocoders.fossmaster.Model.MyRepo2;
import com.hackathon.sudocoders.fossmaster.Model.ReadmeModel;
import com.hackathon.sudocoders.fossmaster.Utils.ApiInterface;
import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;
import com.hackathon.sudocoders.fossmaster.Utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.net.Uri.parse;

public class InsideRepoActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private CardView cardInfo;
    private CardView cardReadme;

    private TextView readme;
    private TextView title;
    private TextView subtitle;
    private TextView url;
    private TextView language;
    private TextView stars_total;
    private TextView foks_total;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insiderepo);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        cardInfo = (CardView) findViewById(R.id.card_info);
        cardReadme = (CardView) findViewById(R.id.card_readme);

        readme = (TextView) findViewById(R.id.reporeadme);
        title = (TextView) findViewById(R.id.title);
        subtitle = (TextView) findViewById(R.id.subtitle);
        url = (TextView) findViewById(R.id.url);
        language = (TextView) findViewById(R.id.language);
        stars_total = (TextView) findViewById(R.id.stars_total);
        foks_total = (TextView) findViewById(R.id.forks_total);
        toolbar = (Toolbar) findViewById(R.id.readme_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Repo Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cardInfo.setVisibility(View.INVISIBLE);
        cardReadme.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        SharedPref sharedPref = new SharedPref(getApplicationContext());
        String uname = sharedPref.getUserName();
        String repname = sharedPref.getreponame();
        getReadme(sharedPref.getreponame(), sharedPref.getUserName());

    }


    public void getReadme(String reponame, String username) {

        ApiInterface mApi = Util.getRetrofitService();
        Call<ReadmeModel> mservice = mApi.getReadme(reponame, username);

        mservice.enqueue(new Callback<ReadmeModel>() {
            @Override
            public void onResponse(Call<ReadmeModel> call, Response<ReadmeModel> response) {
                if (response != null && response.isSuccess()) {
                    if (response.body().getReadme().equals("")) {
                        readme.setText("No readme for this repo");
                    } else {
                        readme.setText(response.body().getReadme());

                    }

                    title.setText(response.body().getFull_name());
                    subtitle.setText(response.body().getDesc());
                    url.setText(response.body().getRepo_url());
                    language.setText(response.body().getLanguage());
                    stars_total.setText(response.body().getStars());
                    foks_total.setText(response.body().getForks());

                    cardInfo.setVisibility(View.VISIBLE);
                    cardReadme.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                } else {
                    Toast.makeText(InsideRepoActivity.this, "Some Problem is there", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ReadmeModel> call, Throwable t) {
                Toast.makeText(InsideRepoActivity.this, "Some Problem is there", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    public void openLink(View v) {
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW);
        launchBrowser.setData(Uri.parse(url.getText().toString()));
        startActivity(launchBrowser);
    }

}
