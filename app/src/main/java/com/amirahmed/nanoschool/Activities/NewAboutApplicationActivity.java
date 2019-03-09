package com.amirahmed.nanoschool.Activities;

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


public class NewAboutApplicationActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout header;

    TextView abouttext,followtext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaboutapplication);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        header = findViewById(R.id.followlayout);
        abouttext = findViewById(R.id.abouttext);
        followtext = findViewById(R.id.followtext);

        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("عن التطبيق");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("عن التطبيق");

            getActionBarTextView().setText("عن التطبيق");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewAboutApplicationActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("About Application");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("About Application");

            getActionBarTextView().setText("About Application");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewAboutApplicationActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            header.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            abouttext.setText("Schoola is a New Educational Fondation for Smart Educational Services");
            followtext.setText("Follow us");
        }
    }

    private TextView getActionBarTextView() {
        TextView titleTextView = null;

        try {
            if (language == 1) {
                Field f = mToolbar.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar);
            } else {
                Field f = mToolbar2.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar2);
            }

        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return titleTextView;
    }

}
