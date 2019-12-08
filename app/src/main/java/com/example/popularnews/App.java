package com.example.popularnews;

import android.app.Application;

import com.example.popularnews.utils.SharedPreferenceHelper;

public class App extends Application {

    private static SharedPreferenceHelper preferenceHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        preferenceHelper=new SharedPreferenceHelper(this);
    }
    public static SharedPreferenceHelper getPreferences(){
        return preferenceHelper;
    }
}