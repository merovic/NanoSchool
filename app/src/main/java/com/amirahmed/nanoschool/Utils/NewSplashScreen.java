package com.amirahmed.nanoschool.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.amirahmed.nanoschool.Activities.GuestLogin.VisitorActivity;
import com.amirahmed.nanoschool.R;

public class NewSplashScreen extends Activity {

    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_newsplash);

        tinyDB = new TinyDB(getApplicationContext());

        tinyDB.putInt("language",2);

        // Splash screen timer
        int SPLASH_TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(NewSplashScreen.this, VisitorActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
