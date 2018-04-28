package com.amirahmed.nanoschool.Activities;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Fragments.MonthFragment;
import com.amirahmed.nanoschool.Fragments.TermFragment;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExamsActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;
    private TabLayout tabLayout;

    TinyDB tinyDB;

    int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        tinyDB = new TinyDB(getApplicationContext());
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

            mToolbar.setTitle("الاختبارات");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الاختبارات");

            getActionBarTextView().setText("الاختبارات");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ExamsActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Exams");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Exams");

            getActionBarTextView().setText("Exams");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ExamsActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        if(language==1)
        {
            viewPager.setCurrentItem(1);
        }else
        {
            viewPager.setCurrentItem(0);
        }



        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#2482DA"));
        //setupTabIcons();


    }

    private void setupTabIcons() {

        Typeface type = Typeface.createFromAsset(this.getAssets(),"fonts/lmaar.ttf");

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        if(language==1)
        {
            tabOne.setText("الاختبار الشهرى");
        }else
        {
            tabOne.setText("Monthly Exam");
        }

        if(language==1)
        {
            tabLayout.getTabAt(1).setCustomView(tabOne);

        }else
        {
            tabLayout.getTabAt(0).setCustomView(tabOne);

        }


        tabOne.setTypeface(type);

        TextView  tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        if(language==1)
        {
            tabTwo.setText("اختبارات التيرم");
        }else
        {
            tabTwo.setText("Term Exam");
        }

        if(language==1)
        {
            tabLayout.getTabAt(0).setCustomView(tabTwo);
        }else
        {
            tabLayout.getTabAt(1).setCustomView(tabTwo);
        }

        tabLayout.setAnimation(new AlphaAnimation(Animation.ABSOLUTE, Animation.RELATIVE_TO_PARENT));

        tabTwo.setTypeface(type);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        if(language==1)
        {
            adapter.addFragment(new TermFragment(), "اختبارات التيرم");
            adapter.addFragment(new MonthFragment(), "الاختبار الشهرى");

        }else
        {
            adapter.addFragment(new MonthFragment(), "Monthly Exam");
            adapter.addFragment(new TermFragment(), "Term Exam");
        }


        //adapter.notifyDataSetChanged();

        viewPager.setAdapter(adapter);
        //viewPager.setOffscreenPageLimit(5);

    }


    private class ViewPagerAdapter extends FragmentStatePagerAdapter

    {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

    void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
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
