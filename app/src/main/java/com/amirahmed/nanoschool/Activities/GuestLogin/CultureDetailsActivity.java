package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.GuestLogin.CultureDetailsAdapter;
import com.amirahmed.nanoschool.Models.GuestLogin.CultureItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CultureDetailsActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    TextView readmore,title,date,details;

    ImageView photo;

    private List<CultureItem> cultureItems;
    private RecyclerView rv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_details);

        tinyDB = new TinyDB(getApplicationContext());

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        readmore = findViewById(R.id.readmore);
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        details = findViewById(R.id.details);

        photo = findViewById(R.id.photo);

        Glide.with(getActionBarTextView()).load(R.drawable.school3).into(photo);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("التفاصيل");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("التفاصيل");

            getActionBarTextView().setText("التفاصيل");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CultureDetailsActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Details");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Details");

            getActionBarTextView().setText("Details");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CultureDetailsActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            readmore.setText("Read More...");
            title.setText("The origins of the practice of punishment towards the son");
            date.setText("October 2014");
            details.setText("The origins of the practice of punishment towards the son");

        }

        rv2 = findViewById(R.id.also_rv);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        cultureItems = new ArrayList<>();

        if (language == 1) {

            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));
            cultureItems.add(new CultureItem("اصول ممارسة اسلوب العقاب تجاه الأبن","سلسلة أمور ترباوية","اكتوبر ٢٠١٤","اصول ممارسة اسلوب العقاب تجاه الأبن"));

        } else {

            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
            cultureItems.add(new CultureItem("The origins of the practice of punishment towards the son","A series of turbulent things","October 2014","The origins of the practice of punishment towards the son"));
        }
    }

    private void initializeAdapter() {

        CultureDetailsAdapter adapter = new CultureDetailsAdapter(cultureItems);
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
