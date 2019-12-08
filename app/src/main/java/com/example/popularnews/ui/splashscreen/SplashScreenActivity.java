package com.example.popularnews.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.popularnews.App;
import com.example.popularnews.ui.main.MainActivity;
import com.example.popularnews.R;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        timerForSplashActivity();

    }

    private void timerForSplashActivity() {
        int delayMillis = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                selectMethod();
            }
        }, delayMillis);
    }

    private void selectMethod() {
        if (App.getPreferences().getFirstLaunch()) {
            App.getPreferences().setFirstLaunch();
        } else {
            MainActivity.start(this);
        }
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        finish();
    }
}