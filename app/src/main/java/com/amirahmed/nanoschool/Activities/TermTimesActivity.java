package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.TermTimesAdapter;
import com.amirahmed.nanoschool.Models.TermTimesItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TermTimesActivity extends AppCompatActivity{

    private RecyclerView rv2;

    List<TermTimesItem> termTimesItemList;

    TermTimesAdapter adapter;

    LinearLayout arabic,english;

    private Toolbar mToolbar,mToolbar2;

    public TinyDB tinydb;

    public int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termtimes);

        tinydb = new TinyDB(getApplicationContext());

        language = tinydb.getInt("language");

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

            mToolbar.setTitle("توقيت الاختبارات");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("توقيت الاختبارات");

            getActionBarTextView().setText("توقيت الاختبارات");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TermTimesActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Exams Times");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Exams Times");

            getActionBarTextView().setText("Exams Times");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TermTimesActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        rv2 = findViewById(R.id.rv2);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        arabic = findViewById(R.id.arabic);
        english = findViewById(R.id.english);

        if(language==1)
        {
            arabic.setVisibility(View.VISIBLE);
            english.setVisibility(View.GONE);
        }else
        {
            english.setVisibility(View.VISIBLE);
            arabic.setVisibility(View.GONE);
        }


    }


    private void initializeData() {
        termTimesItemList = new ArrayList<>();

        if(language==1)
        {
            termTimesItemList.add(new TermTimesItem("لغة عربية","٢٤ مارس ٢٠١٨","٨ص:١٩ص"));
            termTimesItemList.add(new TermTimesItem("لغة عربية","٢٤ مارس ٢٠١٨","٨ص:١٩ص"));
            termTimesItemList.add(new TermTimesItem("لغة عربية","٢٤ مارس ٢٠١٨","٨ص:١٩ص"));
            termTimesItemList.add(new TermTimesItem("لغة عربية","٢٤ مارس ٢٠١٨","٨ص:١٩ص"));
            termTimesItemList.add(new TermTimesItem("لغة عربية","٢٤ مارس ٢٠١٨","٨ص:١٩ص"));
            termTimesItemList.add(new TermTimesItem("لغة عربية","٢٤ مارس ٢٠١٨","٨ص:١٩ص"));
            termTimesItemList.add(new TermTimesItem("لغة عربية","٢٤ مارس ٢٠١٨","٨ص:١٩ص"));

        }else
        {
            termTimesItemList.add(new TermTimesItem("Arabic Language","24 March 2018","8pm:19pm"));
            termTimesItemList.add(new TermTimesItem("Arabic Language","24 March 2018","8pm:19pm"));
            termTimesItemList.add(new TermTimesItem("Arabic Language","24 March 2018","8pm:19pm"));
            termTimesItemList.add(new TermTimesItem("Arabic Language","24 March 2018","8pm:19pm"));
            termTimesItemList.add(new TermTimesItem("Arabic Language","24 March 2018","8pm:19pm"));
            termTimesItemList.add(new TermTimesItem("Arabic Language","24 March 2018","8pm:19pm"));
        }


    }

    private void initializeAdapter() {
        adapter = new TermTimesAdapter(termTimesItemList);
        rv2.setAdapter(adapter);
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
