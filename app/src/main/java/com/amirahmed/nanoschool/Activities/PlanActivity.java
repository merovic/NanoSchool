package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.PlanAdapter;
import com.amirahmed.nanoschool.Models.PlanItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PlanActivity extends AppCompatActivity {

    private RecyclerView rv2;

    List<PlanItem> planItemList;

    PlanAdapter adapter;

    LinearLayout days;

    Button b1,b2,b3,b4,b5;

    private Toolbar mToolbar,mToolbar2;

    public TinyDB tinydb;

    public int language;

    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        tinydb = new TinyDB(getApplicationContext());

        language = tinydb.getInt("language");

        title = findViewById(R.id.title);

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        days = findViewById(R.id.days2);

        b1 = findViewById(R.id.sun2);
        b2 = findViewById(R.id.mon2);
        b3 = findViewById(R.id.tus2);
        b4 = findViewById(R.id.wed2);
        b5 = findViewById(R.id.thur2);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("الخطة الاسبوعية");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الخطة الاسبوعية");

            getActionBarTextView().setText("الخطة الاسبوعية");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PlanActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

            days.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            b1.setText("الاحد");
            b2.setText("الاثنين");
            b3.setText("الثلاثاء");
            b4.setText("الاربعاء");
            b5.setText("الخميس");

            title.setText("خطة الأسبوع الحادى عشر");

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Plan");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Plan");

            getActionBarTextView().setText("Plan");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PlanActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            days.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            b1.setText("Sun");
            b2.setText("Mon");
            b3.setText("Tue");
            b4.setText("Wed");
            b5.setText("Thu");

            title.setText("Plan for week twelve");

        }

        rv2 = findViewById(R.id.rv2);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();


    }


    private void initializeData() {
        planItemList = new ArrayList<>();

        if(language==1)
        {
            planItemList.add(new PlanItem("لغة عربية","معلم/محمد احمد","الدرس المستفادة من الحل","العنوان الاول","الحفاظ على البيئة","تسبرنتسلايرنتلاسي"));
            planItemList.add(new PlanItem("لغة عربية","معلم/محمد احمد","الدرس المستفادة من الحل","العنوان الاول","الحفاظ على البيئة","تسبرنتسلايرنتلاسي"));
            planItemList.add(new PlanItem("لغة عربية","معلم/محمد احمد","الدرس المستفادة من الحل","العنوان الاول","الحفاظ على البيئة","تسبرنتسلايرنتلاسي"));
            planItemList.add(new PlanItem("لغة عربية","معلم/محمد احمد","الدرس المستفادة من الحل","العنوان الاول","الحفاظ على البيئة","تسبرنتسلايرنتلاسي"));
            planItemList.add(new PlanItem("لغة عربية","معلم/محمد احمد","الدرس المستفادة من الحل","العنوان الاول","الحفاظ على البيئة","تسبرنتسلايرنتلاسي"));
            planItemList.add(new PlanItem("لغة عربية","معلم/محمد احمد","الدرس المستفادة من الحل","العنوان الاول","الحفاظ على البيئة","تسبرنتسلايرنتلاسي"));

        }else
        {
            planItemList.add(new PlanItem("Arabic","Mr/Mohamed Ahmed","Lessons taught from the answers","First Title","Keep the Environment","rasteslav"));
            planItemList.add(new PlanItem("Arabic","Mr/Mohamed Ahmed","Lessons taught from the answers","First Title","Keep the Environment","rasteslav"));
            planItemList.add(new PlanItem("Arabic","Mr/Mohamed Ahmed","Lessons taught from the answers","First Title","Keep the Environment","rasteslav"));
            planItemList.add(new PlanItem("Arabic","Mr/Mohamed Ahmed","Lessons taught from the answers","First Title","Keep the Environment","rasteslav"));
            planItemList.add(new PlanItem("Arabic","Mr/Mohamed Ahmed","Lessons taught from the answers","First Title","Keep the Environment","rasteslav"));
            planItemList.add(new PlanItem("Arabic","Mr/Mohamed Ahmed","Lessons taught from the answers","First Title","Keep the Environment","rasteslav"));
        }


    }

    private void initializeAdapter() {
        adapter = new PlanAdapter(planItemList);
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
