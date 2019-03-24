package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;

public class NotificationsSettingActivity extends AppCompatActivity {

    LinearLayout layout1,layout2;
    TextView text1,text2;

    TinyDB tinyDB;

    int language;

    private Toolbar mToolbar,mToolbar2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_notificationssetting);


        tinyDB = new TinyDB(getApplicationContext());

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("الاعدادات");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الاعدادات");

            getActionBarTextView().setText("الاعدادات");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    NotificationsSettingActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Setting");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Setting");

            getActionBarTextView().setText("Setting");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NotificationsSettingActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            layout1.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            layout2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            text1.setText("Weather Notifications");
            text2.setText("General Notifications");

        }
    }

    private TextView getActionBarTextView() {
        TextView titleTextView = null;

        try {
            if(language==1)
            {
                Field f = mToolbar.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar);
            }else
            {
                Field f = mToolbar2.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar2);
            }

        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return titleTextView;
    }
}
