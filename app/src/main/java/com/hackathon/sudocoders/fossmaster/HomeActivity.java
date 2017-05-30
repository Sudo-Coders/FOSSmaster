package com.hackathon.sudocoders.fossmaster;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.hackathon.sudocoders.fossmaster.Model.StarredRepos;
import com.hackathon.sudocoders.fossmaster.Utils.SharedPref;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imageUser;
    private TextView textUser;
    private SharedPref sharedPref;
    private static final String BASE_URL = "https://github.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FOSSmaster");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        imageUser = (ImageView) hView.findViewById(R.id.imageUser);
        textUser = (TextView) hView.findViewById(R.id.textUser);
        sharedPref = new SharedPref(getApplicationContext());

        String IMG_URL = BASE_URL + sharedPref.getUserName() + ".png";
        Log.d(IMG_URL, " hi");

        textUser.setText(sharedPref.getUserName());

        if (IMG_URL != null) {
            Glide.with(this).load(IMG_URL).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.github).error(R.drawable.github).into(new ImageViewTarget<Bitmap>(imageUser) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                    drawable.setCircular(true);
                    imageUser.setImageDrawable(drawable);
                }
            });

        }

    }


    public void getFeed(View v) {

        startActivity(new Intent(HomeActivity.this, DashBoardActivity.class));
    }

    public void getMyrepo(View v) {

        startActivity(new Intent(HomeActivity.this, MyRepositories.class));
    }

    public void getMypr(View v) {

        startActivity(new Intent(HomeActivity.this, PullRequestsActivity.class));
    }

    public void getStars(View v) {

        startActivity(new Intent(HomeActivity.this, StarredReposActivity.class));
    }

    public void startOS(View v) {
        SharedPref sharedPref = new SharedPref(getApplicationContext());
        if (!sharedPref.getopensourceStatus()) {
            startActivity(new Intent(HomeActivity.this, StartOpenSource.class));
        } else {
            startActivity(new Intent(HomeActivity.this, OpenSourceActivity.class));
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            finish();
            return true;
        } else if (id == R.id.action_logout) {
            SharedPref sharedPref = new SharedPref(getApplicationContext());

            sharedPref.clearPrefOnLogout(getApplicationContext());
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_feed) {
            startActivity(new Intent(HomeActivity.this, DashBoardActivity.class));
        } else if (id == R.id.nav_repo) {
            startActivity(new Intent(HomeActivity.this, MyRepositories.class));
        } else if (id == R.id.nav_pr) {
            startActivity(new Intent(HomeActivity.this, PullRequestsActivity.class));
        } else if (id == R.id.nav_star) {
            startActivity(new Intent(HomeActivity.this, StarredReposActivity.class));
        } else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);

            String uriText = "mailto:" + Uri.encode("sudo-coders@gmail.com") + "?subject=" + Uri.encode("Reporting A Bug/Feedback") + "&body=" + Uri.encode("Hello, \nI want to report a bug/give feedback for FOSSmaster app.\n.....\n\n-Your name");
            Uri uri = Uri.parse(uriText);
            intent.setData(uri);
            startActivity(Intent.createChooser(intent, "Send Email"));

        } else if (id == R.id.nav_contact) {

            AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(HomeActivity.this);
            alertDialog2.setTitle("Contact Us");
            alertDialog2.setMessage("\nPhone No. : +919882926225\n\nEmail : sudo-coders@gmail.com");
            alertDialog2.setIcon(R.drawable.github);
            alertDialog2.show();

        } else if (id == R.id.nav_about) {
            startActivity(new Intent(HomeActivity.this, AboutUSActivity.class));
        } else if (id == R.id.nav_logout) {
            SharedPref sharedPref = new SharedPref(getApplicationContext());

            sharedPref.clearPrefOnLogout(getApplicationContext());
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
