package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.GuestLogin.SchoolFeathersAdapter;
import com.amirahmed.nanoschool.Models.GuestLogin.SchoolsFeathersItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AboutSchoolActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout header;

    TextView schoolname,statsticstext,schoolfeatchures,studentsno,studentsaverage,size,areaofschool;


    private RecyclerView mRecyclerView;
    private List<SchoolsFeathersItem> schoolsFeathersItems;

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
        statsticstext = findViewById(R.id.statsticstext);
        schoolfeatchures = findViewById(R.id.schoolfeatchures);
        studentsno = findViewById(R.id.studentsno);
        studentsaverage = findViewById(R.id.studentsaverage);
        size = findViewById(R.id.size);
        areaofschool = findViewById(R.id.areaofschool);

        mRecyclerView = findViewById(R.id.rv);

        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager mGridlayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(mGridlayoutManager);


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
            statsticstext.setText("Statistics about School");
            schoolfeatchures.setText("School Features");
            studentsno.setText("Students in Class");
            studentsaverage.setText("Average Number");
            size.setText("School Size");
            areaofschool.setText("2300 Meter");


        }

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {

        //The Backgrounds and logos will be provided later

        schoolsFeathersItems = new ArrayList<>();

        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));
        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));
        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));
        schoolsFeathersItems.add(new SchoolsFeathersItem("https://res.cloudinary.com/dtec9smtu/image/upload/v1553440360/bg1.png","https://res.cloudinary.com/dtec9smtu/image/upload/v1553440348/boygirlblue.png","Boys and Girls"));

    }

    private void initializeAdapter() {

        SchoolFeathersAdapter adapter = new SchoolFeathersAdapter(schoolsFeathersItems);
        mRecyclerView.setAdapter(adapter);
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
