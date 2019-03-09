package com.amirahmed.nanoschool.Activities.GuestLogin;

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
import com.bumptech.glide.Glide;

import java.lang.reflect.Field;

public class AboutSchoolActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout header;

    TextView schoolname,schooltype,statsticstext,schoolfeatchures,studentsno,studentsaverage,size;

    ImageView pic1,pic2,pic3,pic4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutschool_guest);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        header = findViewById(R.id.headlayout);

        schoolname = findViewById(R.id.schoolname);
        schooltype = findViewById(R.id.schooltype);
        statsticstext = findViewById(R.id.statsticstext);
        schoolfeatchures = findViewById(R.id.schoolfeatchures);
        studentsno = findViewById(R.id.studentsno);
        studentsaverage = findViewById(R.id.studentsaverage);
        size = findViewById(R.id.size);

        pic1 = findViewById(R.id.pic1);
        pic2 = findViewById(R.id.pic2);
        pic3 = findViewById(R.id.pic3);
        pic4 = findViewById(R.id.pic4);

        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("عن المدرسة");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("عن المدرسة");

            getActionBarTextView().setText("عن المدرسة");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AboutSchoolActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("About School");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("About School");

            getActionBarTextView().setText("About School");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AboutSchoolActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            header.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            schoolname.setText("EL-Eleem Educational School");
            schooltype.setText("International | All Levels");
            statsticstext.setText("Statistics about School");
            schoolfeatchures.setText("School Features");
            studentsno.setText("Students in Class");
            studentsaverage.setText("Average Number");
            size.setText("School Size");

            Glide.with(getApplicationContext()).load(R.drawable.boysgirlsen).into(pic1);
            Glide.with(getApplicationContext()).load(R.drawable.levelsen).into(pic2);
            Glide.with(getApplicationContext()).load(R.drawable.labsen).into(pic3);
            Glide.with(getApplicationContext()).load(R.drawable.pitchesen).into(pic4);

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
