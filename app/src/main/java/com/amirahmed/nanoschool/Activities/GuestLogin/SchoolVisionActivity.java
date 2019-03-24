package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.GuestLogin.FeesTabsAdapter;
import com.amirahmed.nanoschool.Adapters.GuestLogin.FragmentAdapterDemo;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.athbk.ultimatetablayout.OnClickTabListener;
import com.athbk.ultimatetablayout.UltimateTabLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SchoolVisionActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout container;

    TextView schoolname,schoollevels;

    CardView maincard;

    TextView visiontext,goalstext,messagetext,mangertext,maintext;

    View visionview,goalsview,messageview,mangerview;


    UltimateTabLayout tabLayout;
    ViewPager viewPager;

    FragmentAdapterDemo adapter;

    List<String> titles = new ArrayList<>();

    List<String> names = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);

        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        container = findViewById(R.id.containerlayout);

        schoolname = findViewById(R.id.schoolname);

        schoollevels = findViewById(R.id.schoollevels);

        maincard = findViewById(R.id.maincard);

        visiontext = findViewById(R.id.visiontext);
        goalstext = findViewById(R.id.goalstext);
        messagetext = findViewById(R.id.messagetext);
        mangertext = findViewById(R.id.mangertext);
        maintext = findViewById(R.id.maintext);

        visionview = findViewById(R.id.visionline);
        goalsview = findViewById(R.id.goalsline);
        messageview = findViewById(R.id.messageline);
        mangerview = findViewById(R.id.mangerline);


        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("الرؤية");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الرؤية");

            getActionBarTextView().setText("الرؤية");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolVisionActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);


            titles.add("كلمة المدير");
            titles.add("الرسالة");
            titles.add("الأهداف");
            titles.add("الرؤية");

            names.add("الرؤية");
            names.add("الأهداف");
            names.add("الرسالة");
            names.add("كلمة المدير");

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Vision");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Vision");

            getActionBarTextView().setText("Vision");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolVisionActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            schoolname.setText("EL-Eleem Educational School");

            schoollevels.setText("International | All Levels");

            maincard.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            visiontext.setText("Vision");
            goalstext.setText("Goals");
            messagetext.setText("Message");
            mangertext.setText("Manger");
            maintext.setText("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\n" +
                    "\n" +
                    "Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.");


            titles.add("Vision");
            titles.add("Goals");
            titles.add("Message");
            titles.add("Manger");

            names.add("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\n" +
                    "\n" +
                    "Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.");
            names.add("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\\n\" +\n" +
                    "                    \"\\n\" +\n" +
                    "                    \"Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.\"");
            names.add("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\\n\" +\n" +
                    "                    \"\\n\" +\n" +
                    "                    \"Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.\"");
            names.add("Vision statements outline a school’s objectives, and mission statements indicate how the school aims to achieve that vision. Schools might have one or both.\\n\" +\n" +
                    "                    \"\\n\" +\n" +
                    "                    \"Vision and mission statements in schools make a public declaration of the values of the school. But are such statements useful, or just nice to look at but of little substance? They can be useful – but it depends on what they include and how they’re used.\"");

        }

        visiontext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visionview.setVisibility(View.VISIBLE);
                goalsview.setVisibility(View.INVISIBLE);
                messageview.setVisibility(View.INVISIBLE);
                mangerview.setVisibility(View.INVISIBLE);
            }
        });

        goalstext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visionview.setVisibility(View.INVISIBLE);
                goalsview.setVisibility(View.VISIBLE);
                messageview.setVisibility(View.INVISIBLE);
                mangerview.setVisibility(View.INVISIBLE);
            }
        });

        messagetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visionview.setVisibility(View.INVISIBLE);
                goalsview.setVisibility(View.INVISIBLE);
                messageview.setVisibility(View.VISIBLE);
                mangerview.setVisibility(View.INVISIBLE);
            }
        });

        mangertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visionview.setVisibility(View.INVISIBLE);
                goalsview.setVisibility(View.INVISIBLE);
                messageview.setVisibility(View.INVISIBLE);
                mangerview.setVisibility(View.VISIBLE);
            }
        });

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);



//        options. if you override onClickTabListener.
        tabLayout.setOnClickTabListener(new OnClickTabListener() {
            @Override
            public void onClickTab(int currentPos) {
                Log.e("LOG", "OnClickTab " + currentPos);
                viewPager.setCurrentItem(currentPos);
                if (currentPos == 1){
                    tabLayout.setNumberBadge(currentPos, 0);
                }
                else {
                    tabLayout.setNumberBadge(currentPos, 1);
                }
            }
        });

        adapter = new FragmentAdapterDemo(getSupportFragmentManager(),4);
        viewPager.setAdapter(adapter);

        if(language==1)
        {
            viewPager.setCurrentItem(3);
        }else
        {
            viewPager.setCurrentItem(0);
        }

        adapter.setTITLES(titles);
        adapter.setNAMES(names);



        tabLayout.setViewPager(viewPager, adapter);
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
