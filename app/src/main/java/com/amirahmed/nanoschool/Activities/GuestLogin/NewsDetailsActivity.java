package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;

public class NewsDetailsActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    TextView title,date,details;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        tinyDB = new TinyDB(getApplicationContext());

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        details = findViewById(R.id.details);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("تفاصيل الخبر");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("تفاصيل الخبر");

            getActionBarTextView().setText("تفاصيل الخبر");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewsDetailsActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("News Details");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("News Details");

            getActionBarTextView().setText("News Details");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewsDetailsActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            title.setText("The origins of the practice of punishment towards the son");
            date.setText("October 2014");
            details.setText("The origins of the practice of punishment towards the son");
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
