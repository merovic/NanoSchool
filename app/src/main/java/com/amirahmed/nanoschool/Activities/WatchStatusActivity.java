package com.amirahmed.nanoschool.Activities;


import android.os.BatteryManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;

public class WatchStatusActivity extends AppCompatActivity{

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    TextView percentage,text0,text1,text2,text3;

    Button cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchstatus);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("الساعة الزكية");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الساعة الزكية");

            getActionBarTextView().setText("الساعة الزكية");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WatchStatusActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Smart Watch");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Smart Watch");

            getActionBarTextView().setText("Smart Watch");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WatchStatusActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        percentage = findViewById(R.id.percentage);
        text0 = findViewById(R.id.text);
        text1 = findViewById(R.id.numbertext);
        text2 = findViewById(R.id.nametext);
        text3 = findViewById(R.id.number);

        cancel = findViewById(R.id.cancelbutton);

        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        percentage.setText("%"+batLevel);

        if(language==1)
        {
            text0.setText("١٠ ايام فى وضع الاستعداد");
            text1.setText("رقم الساعة");
            text2.setText("اسم الساعة");
            text3.setText("الساعة رقم ١");

            cancel.setText("الغاء مزامنة");
        }else
            {
                text0.setText("10 Days in Standby Mode");
                text1.setText("Watch Number");
                text2.setText("Watch Name");
                text3.setText("Watch Number 1");

                cancel.setText("Cancel Sync");
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
