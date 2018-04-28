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

import com.amirahmed.nanoschool.Adapters.TermResultsAdapter;
import com.amirahmed.nanoschool.Models.TermResultsItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TermResultsActivity extends AppCompatActivity {

    private RecyclerView rv2;

    List<TermResultsItem> termResultsItemList;

    TermResultsAdapter adapter;

    LinearLayout arabic,english;

    private Toolbar mToolbar,mToolbar2;

    public TinyDB tinydb;

    public int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

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

            mToolbar.setTitle("نتائج الاختبارات");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("نتائج الاختبارات");

            getActionBarTextView().setText("نتائج الاختبارات");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TermResultsActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Exams Results");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Exams Results");

            getActionBarTextView().setText("Exams Results");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TermResultsActivity.super.onBackPressed();
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
        termResultsItemList = new ArrayList<>();

        if(language==1)
        {
            termResultsItemList.add(new TermResultsItem("28","لغة عربية"));
            termResultsItemList.add(new TermResultsItem("38","لغة انجليزية"));
            termResultsItemList.add(new TermResultsItem("15","رياضيات"));
            termResultsItemList.add(new TermResultsItem("40","لغة عربية"));
            termResultsItemList.add(new TermResultsItem("28","لغة عربية"));
            termResultsItemList.add(new TermResultsItem("38","لغة عربية"));

        }else
        {

            termResultsItemList.add(new TermResultsItem("28","Arabic Language"));
            termResultsItemList.add(new TermResultsItem("38","Arabic"));
            termResultsItemList.add(new TermResultsItem("15","Arabic"));
            termResultsItemList.add(new TermResultsItem("40","Arabic"));
            termResultsItemList.add(new TermResultsItem("50","Arabic"));
            termResultsItemList.add(new TermResultsItem("42","Arabic"));

        }


    }

    private void initializeAdapter() {
        adapter = new TermResultsAdapter(termResultsItemList);
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
