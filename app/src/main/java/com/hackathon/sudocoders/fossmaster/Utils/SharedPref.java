package com.hackathon.sudocoders.fossmaster.Utils;

/**
 * Created by yatendra.maurya on 4/1/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;


    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "UserInfo";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public SharedPref(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void clearPrefOnLogout(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.clear();
        editor.commit();

    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


    private static final String LOGIN_STATUS = "loginstatus";
    private static final String OPENSOURCE_STATUS = "opensourcestatus";

    private static final String IS_FIRST_TIME = "isfirstTime";
    private static final String REPONAME = "reponame";
    private static final String USER_NAME = "username";
    private static final String LANGUAGE = "language";
    private static final String LEVEL = "level";

    public void setUserName(String name) {
        editor.putString(USER_NAME, name);
        editor.commit();
    }

    public String getUserName() {
        return pref.getString(USER_NAME, "");
    }


    public String getLanguage() {
        return pref.getString(LANGUAGE, "");
    }

    public void setLanguage(String language) {
        editor.putString(LANGUAGE, language);
        editor.commit();
    }

    public void setRepoName(String name) {
        editor.putString(REPONAME, name);
        editor.commit();
    }

    public String getreponame() {
        return pref.getString(REPONAME, "");
    }

    public String getLevel() {
        return pref.getString(LANGUAGE, "");
    }

    public void setLevel(String level) {
        editor.putString(LEVEL, level);
        editor.commit();
    }

    public void setLoginStatus(boolean isLogIn) {
        editor.putBoolean(LOGIN_STATUS, isLogIn);
        editor.commit();
    }

    public void setOpensourceStatus(boolean isLogIn) {
        editor.putBoolean(OPENSOURCE_STATUS, isLogIn);
        editor.commit();
    }

    public boolean getopensourceStatus() {
        return pref.getBoolean(OPENSOURCE_STATUS, false);
    }

    public boolean getLoginStatus() {
        return pref.getBoolean(LOGIN_STATUS, false);
    }

    public void setIsFirstTime() {
        editor.putBoolean(IS_FIRST_TIME, true);
        editor.commit();
    }

    public boolean showIsFirstTime() {
        return pref.getBoolean(IS_FIRST_TIME, false);
    }


}
