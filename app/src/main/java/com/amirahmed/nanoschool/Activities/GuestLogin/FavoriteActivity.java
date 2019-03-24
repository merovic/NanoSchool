package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.GuestLogin.FavoriteAdapter;
import com.amirahmed.nanoschool.Models.SchoolsListItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    private List<SchoolsListItem> schoolsListItems;
    private RecyclerView rv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);



        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("المفضلة");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("المفضلة");

            getActionBarTextView().setText("المفضلة");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoriteActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Favorite");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Favorite");

            getActionBarTextView().setText("Favorite");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoriteActivity.super.onBackPressed();
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

    }

    private void initializeData() {
        schoolsListItems = new ArrayList<>();

        if(language==1)
        {
            schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","دولية | جميع المراحل"));
            schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","دولية | جميع المراحل"));
        }else
        {
            schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
            schoolsListItems.add(new SchoolsListItem("El Amal Modern School","Open from 7pm - 3am","15 KM","International | All Levels"));
        }


    }

    private void initializeAdapter() {

        FavoriteAdapter adapter = new FavoriteAdapter(schoolsListItems);
        rv2.setAdapter(adapter);

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
