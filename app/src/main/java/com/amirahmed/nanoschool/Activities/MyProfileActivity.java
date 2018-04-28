package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;

import info.hoang8f.android.segmented.SegmentedGroup;

public class MyProfileActivity extends AppCompatActivity{

    SegmentedGroup tabsgroup;
    RadioButton student,parent;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout parentlayout,studentlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        if(language==1)
        {
            setContentView(R.layout.activity_myprofile);
        }else
            {
                setContentView(R.layout.activity_myprofile_en);
            }




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

            mToolbar.setTitle("حسابى");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("حسابى");

            getActionBarTextView().setText("حسابى");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyProfileActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("MyProfile");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("MyProfile");

            getActionBarTextView().setText("MyProfile");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyProfileActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        parentlayout = findViewById(R.id.parentlayout);
        studentlayout = findViewById(R.id.studentlayout);

        tabsgroup = findViewById(R.id.segmented2);

        parent = findViewById(R.id.button22);
        student = findViewById(R.id.button21);

        student.setChecked(false);
        parent.setChecked(true);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentlayout.setVisibility(View.VISIBLE);
                parentlayout.setVisibility(View.GONE);


            }
        });

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentlayout.setVisibility(View.VISIBLE);
                studentlayout.setVisibility(View.GONE);


            }
        });

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
