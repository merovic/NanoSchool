package com.amirahmed.nanoschool.Activities;


import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutApplicationActivity extends Activity {

    TinyDB tinyDB;
    int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_aboutapplication);

        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        simulateDayNight(/* DAY */ 0);
        Element adsElement = new Element();
        //adsElement.setTitle("Advertise with us");

        if(language==1)
        {
            View aboutPage = new AboutPage(this)
                    .isRTL(true)
                    .setImage(R.drawable.eschoola)
                    .addItem(new Element().setTitle("Version 1.0"))
                    .setDescription("سكولا ")
                    .addGroup("تواصل معنا")
                    .addItem(Email())
                    .addItem(Website())
                    .addItem(Facebook())
                    .addItem(Twitter())
                    .addItem(Youtube())
                    .addItem(Playstore())
                    .addItem(Instagram())
                    .addItem(Github())
                    .addItem(getCopyRightsElement())
                    .create();

            setContentView(aboutPage);

        }else
            {
                View aboutPage = new AboutPage(this)
                        .isRTL(false)
                        .setImage(R.drawable.logotrans2)
                        .addItem(new Element().setTitle("Version 1.0"))
                        //.addItem(adsElement)
                        .setDescription("Schoola")
                        .addGroup("Connect with us")
                        .addEmail("nanoschool01@gmail.com")
                        .addWebsite("http://www.Schoola.com")
                        .addFacebook("the.medy")
                        .addTwitter("medyo80")
                        .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                        .addPlayStore("com.ideashower.readitlater.pro")
                        .addInstagram("medyo80")
                        .addGitHub("hbkbkhbkhbk")
                        .addItem(getCopyRightsElement())
                        .create();

                setContentView(aboutPage);
            }




    }

    Element Facebook() {
        Element Facebook = new Element();
        Facebook.setTitle("تابعنا على فيس بوك");
        Facebook.setIconDrawable(R.drawable.about_icon_facebook);
        Facebook.setIconTint(R.color.about_facebook_color);
        Facebook.setIconNightTint(android.R.color.white);
        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return Facebook;
    }

    Element Twitter() {
        Element twitter = new Element();
        twitter.setTitle("تابعنا على تويتر");
        twitter.setIconDrawable(R.drawable.about_icon_twitter);
        twitter.setIconTint(R.color.about_twitter_color);
        twitter.setIconNightTint(android.R.color.white);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return twitter;
    }

    Element Youtube() {
        Element youtube = new Element();
        youtube.setTitle("شاهدنا على يوتيوب");
        youtube.setIconDrawable(R.drawable.about_icon_youtube);
        youtube.setIconTint(R.color.about_youtube_color);
        youtube.setIconNightTint(android.R.color.white);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return youtube;
    }

    Element Playstore() {
        Element playstore = new Element();
        playstore.setTitle("قييم التطبيق");
        playstore.setIconDrawable(R.drawable.about_icon_google_play);
        playstore.setIconTint(R.color.about_play_store_color);
        playstore.setIconNightTint(android.R.color.white);
        playstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return playstore;
    }


    Element Instagram() {
        Element instagram = new Element();
        instagram.setTitle("تابعنا على انستاجرام");
        instagram.setIconDrawable(R.drawable.about_icon_instagram);
        instagram.setIconTint(R.color.about_instagram_color);
        instagram.setIconNightTint(android.R.color.white);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return instagram;
    }

    Element Github() {
        Element github = new Element();
        github.setTitle("تابع مطور التطبيق");
        github.setIconDrawable(R.drawable.about_icon_github);
        github.setIconTint(R.color.about_github_color);
        github.setIconNightTint(android.R.color.white);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return github;
    }


    Element Email() {
        Element email = new Element();
        email.setTitle("تواصل معنا");
        email.setIconDrawable(R.drawable.about_icon_email);
        email.setIconTint(R.color.about_item_icon_color);
        email.setIconNightTint(android.R.color.white);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return email;
    }

    Element Website() {
        Element website = new Element();
        website.setTitle("ذور موقعنا");
        website.setIconDrawable(R.drawable.about_icon_link);
        website.setIconTint(R.color.about_item_icon_color);
        website.setIconNightTint(android.R.color.white);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, "فيس", Toast.LENGTH_SHORT).show();
            }
        });
        return website;
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutApplicationActivity.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }

}
