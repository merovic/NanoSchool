package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.Photos2Adapter;
import com.amirahmed.nanoschool.Models.PhotosItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private List<PhotosItem> photosItems;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    Photos2Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

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

            mToolbar.setTitle("اسم الألبوم");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("اسم الألبوم");

            getActionBarTextView().setText("اسم الألبوم");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImagesActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Album Name");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Album Name");

            getActionBarTextView().setText("Album Name");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImagesActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        mRecyclerView = findViewById(R.id.rv2e);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);

        initializeData();
        initializeAdapter();
    }


    private void initializeData() {

        photosItems = new ArrayList<>();

        photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
        photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
        photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
        photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
        photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
        photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));


    }

    private void initializeAdapter() {

        adapter = new Photos2Adapter(photosItems);
        mRecyclerView.setAdapter(adapter);
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
