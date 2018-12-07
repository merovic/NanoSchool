package com.amirahmed.nanoschool.Activities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.ScoresSelectAdapter;
import com.amirahmed.nanoschool.Models.ScoresSelectItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.CircleDisplay;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ScoresSelectActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ScoresSelectItem> scoresSelectItems;

    private Toolbar mToolbar,mToolbar2;

    RadioButton rad1,rad2;

    TinyDB tinydb;

    int language;

    CircleDisplay cd;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_select);

        tinydb = new TinyDB(getApplicationContext());

        language = tinydb.getInt("language");

        cd = findViewById(R.id.circleDisplay);
        total = findViewById(R.id.total);

        cd.showValue(Float.parseFloat("70"), 100f, true);
        cd.setAnimDuration(3000);
        cd.setValueWidthPercent(30f);
        cd.setTextSize(10f);
        cd.setColor(Color.parseColor("#5FB336"));
        cd.setDrawText(true);
        cd.setDrawInnerCircle(true);
        cd.setFormatDigits(0);
        cd.setTouchEnabled(false);
        cd.setUnit("%");
        cd.setStepSize(0.5f);

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

            mToolbar.setTitle("التقييم");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("التقييم");

            getActionBarTextView().setText("التقييم");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ScoresSelectActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

            total.setText("التقييم الكلى");
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Evaluation");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Evaluation");

            getActionBarTextView().setText("Evaluation");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ScoresSelectActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            total.setText("Total Score");
        }

        rad1 = findViewById(R.id.button21);
        rad2 = findViewById(R.id.button22);

        if(language==1)
        {
            rad1.setText("الشهر السابق");
            rad2.setText("الشهر الحالى");
        }else
            {
                rad1.setText("Previous Month");
                rad2.setText("Current Month");
            }

        mRecyclerView = findViewById(R.id.scoresseclect_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        initializeData();
        initializeAdapter();

    }


    private void initializeData() {

        scoresSelectItems = new ArrayList<>();

        if(language==1)
        {
            scoresSelectItems.add(new ScoresSelectItem("المعلم/احمد ابراهيم","لغة عربية","15"));
            scoresSelectItems.add(new ScoresSelectItem("المعلم/سعيد عماد","علوم","8"));
            scoresSelectItems.add(new ScoresSelectItem("المعلم/ابراهيم حسن","تربية دينية","10"));
            scoresSelectItems.add(new ScoresSelectItem("المعلم/حسن فوزى","تاريخ","12"));
            scoresSelectItems.add(new ScoresSelectItem("المعلم/سامى صابر","رياضيات","20"));
            scoresSelectItems.add(new ScoresSelectItem("المعلم/وائل رامى","جغرافيا","8"));
        }else
        {
            scoresSelectItems.add(new ScoresSelectItem("Ahmed Ibrahim","Science","15"));
            scoresSelectItems.add(new ScoresSelectItem("Said Emad","Science","8"));
            scoresSelectItems.add(new ScoresSelectItem("Ibrahim Hassan","Science","10"));
            scoresSelectItems.add(new ScoresSelectItem("Hassan Fawzy","Science","12"));
            scoresSelectItems.add(new ScoresSelectItem("Samy Saber","Science","20"));
            scoresSelectItems.add(new ScoresSelectItem("Wael Ramy","Science","8"));
        }

    }

    private void initializeAdapter() {

        ScoresSelectAdapter adapter = new ScoresSelectAdapter(scoresSelectItems);
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

