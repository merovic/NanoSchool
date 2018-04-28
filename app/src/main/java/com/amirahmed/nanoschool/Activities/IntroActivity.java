package com.amirahmed.nanoschool.Activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.amirahmed.nanoschool.Fragments.SampleSlide;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.github.paolorotolo.appintro.AppIntro;

public class IntroActivity extends AppIntro{

    TinyDB tinyDB;

    int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        tinyDB = new TinyDB(getApplicationContext());

        language = tinyDB.getInt("language");

        if(language==1)
        {
            // Add your slide fragments here.
            // AppIntro will automatically generate the dots indicator and buttons.
            addSlide(SampleSlide.newInstance(R.layout.fragment_slide1));
            addSlide(SampleSlide.newInstance(R.layout.fragment_slide2));
            addSlide(SampleSlide.newInstance(R.layout.fragment_slide3));
            addSlide(SampleSlide.newInstance(R.layout.fragment_slide4));

            setSkipText("تخطى");
            setSkipTextTypeface("fonts/lmaar.ttf");

            setDoneText("تم");
            setDoneTextTypeface("fonts/lmaar.ttf");

        }else
            {
                // Add your slide fragments here.
                // AppIntro will automatically generate the dots indicator and buttons.
                addSlide(SampleSlide.newInstance(R.layout.fragment_slide1_en));
                addSlide(SampleSlide.newInstance(R.layout.fragment_slide2_en));
                addSlide(SampleSlide.newInstance(R.layout.fragment_slide3_en));
                addSlide(SampleSlide.newInstance(R.layout.fragment_slide4_en));

                setSkipText("Skip");
                setSkipTextTypeface("fonts/lmaar.ttf");

                setDoneText("Done");
                setDoneTextTypeface("fonts/lmaar.ttf");
            }





        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#967097"));
        setSeparatorColor(Color.WHITE);

        setFadeAnimation();
        //setZoomAnimation();
        //setFlowAnimation();
        //setSlideOverAnimation();
        //setDepthAnimation();




        // Hide Skip/Done button.
        showSkipButton(true);
        //setProgressButtonEnabled(false);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        //setVibrate(true);
        //setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent i = new Intent(IntroActivity.this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent i = new Intent(IntroActivity.this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void onSlideChanged(Fragment oldFragment,Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);

        try {
            if(newFragment.getTag().contains(":0"))
            {
                setBarColor(Color.parseColor("#967097"));
            }else if(newFragment.getTag().contains(":1"))
            {
                setBarColor(Color.parseColor("#CDB553"));
            }else if(newFragment.getTag().contains(":2"))
            {
                setBarColor(Color.parseColor("#419EDF"));
            }

            if(newFragment.getTag().contains(":3"))
            {
                setBarColor(Color.parseColor("#54C6C6"));
            }
        }catch (Exception e)
        {
            //showMessage("Null");
        }

    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }
}
