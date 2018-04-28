package com.amirahmed.nanoschool.Activities;


import android.graphics.Color;
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
import android.widget.Toast;

import com.amirahmed.nanoschool.Adapters.ScheduleAdapter;
import com.amirahmed.nanoschool.Models.ScheduleItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    private List<ScheduleItem> schedule;
    private RecyclerView rv2;

    private Toolbar mToolbar,mToolbar2;

    Button b1,b2,b3,b4,b5;

    ScheduleAdapter adapter;

    public TinyDB tinydb;

    public int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        LinearLayout days = findViewById(R.id.days2);

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

            mToolbar.setTitle("الجدول");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الجدول");

            getActionBarTextView().setText("الجدول");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ScheduleActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Schedule");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Schedule");

            getActionBarTextView().setText("Schedule");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ScheduleActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }




        Calendar cal =  Calendar.getInstance();
        Date date = cal.getTime();

        String currentday = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());

        b1 = findViewById(R.id.sun2);
        b2 = findViewById(R.id.mon2);
        b3 = findViewById(R.id.tus2);
        b4 = findViewById(R.id.wed2);
        b5 = findViewById(R.id.thur2);


        if(language==1)
        {

            days.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            b1.setText("الاحد");
            b2.setText("الاثنين");
            b3.setText("الثلاثاء");
            b4.setText("الاربعاء");
            b5.setText("الخميس");


            switch (currentday) {
                case "Sunday":
                    b1.setTextColor(Color.WHITE);
                    b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                    b1.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                    b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                    break;
                case "Monday":
                    b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b2.setTextColor(Color.WHITE);
                    b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                    b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b2.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                    b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                    break;
                case "Tuesday":
                    b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b3.setTextColor(Color.WHITE);
                    b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                    b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b3.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                    b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                    break;
                case "Wednesday":
                    b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b4.setTextColor(Color.WHITE);
                    b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                    b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b4.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                    b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));


                    break;
                case "Thursday":
                    b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b5.setTextColor(Color.WHITE);

                    b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b5.setBackground(getResources().getDrawable(R.drawable.roundedfill));


                    break;

                default:
                    b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                    b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                    b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                    b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));

                    break;
            }

        }else
            {

                days.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                b1.setText("Sun");
                b2.setText("Mon");
                b3.setText("Tue");
                b4.setText("Wed");
                b5.setText("Thu");

                switch (currentday) {
                    case "Sunday":
                        b1.setTextColor(Color.WHITE);
                        b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                        b1.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                        b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                        break;
                    case "Monday":
                        b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b2.setTextColor(Color.WHITE);
                        b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                        b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b2.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                        b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                        break;
                    case "Tuesday":
                        b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b3.setTextColor(Color.WHITE);
                        b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                        b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b3.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                        b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                        break;
                    case "Wednesday":
                        b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b4.setTextColor(Color.WHITE);
                        b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                        b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b4.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                        b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));


                        break;
                    case "Thursday":
                        b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b5.setTextColor(Color.WHITE);

                        b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b5.setBackground(getResources().getDrawable(R.drawable.roundedfill));


                        break;

                    default:
                        b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                        b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                        b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));

                        break;
                }

            }







        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);

        rv2 = findViewById(R.id.rv2);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

    private void initializeData() {
        schedule = new ArrayList<>();

        if(language==1)
        {
            schedule.add(new ScheduleItem("الحصة\n الاولى", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
            schedule.add(new ScheduleItem("الحصة\n الثانية", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
            schedule.add(new ScheduleItem("الحصة\n الثالثة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
            schedule.add(new ScheduleItem("الحصة\n الرابعة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
        }else
            {
                schedule.add(new ScheduleItem("1st\n Class", "Arabic","Class Banana","from: 08:00","To: 08:45"));
                schedule.add(new ScheduleItem("2nd\n Class", "Arabic","Class Banana","from: 08:00","To: 08:45"));
                schedule.add(new ScheduleItem("3rd\n Class", "Arabic","Class Banana","from: 08:00","To: 08:45"));
                schedule.add(new ScheduleItem("4th\n Class", "Arabic","Class Banana","from: 08:00","To: 08:45"));
            }


    }

    private void initializeAdapter() {
        adapter = new ScheduleAdapter(schedule);
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


    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.sun2:
                schedule.clear();
                schedule.add(new ScheduleItem("الحصة\n الاولى", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثانية", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثالثة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الرابعة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));


                b1.setTextColor(Color.WHITE);
                b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                b1.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));


                adapter.notifyDataSetChanged();
                break;
            case R.id.mon2:
                schedule.clear();
                schedule.add(new ScheduleItem("الحصة\n الاولى", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثانية", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثالثة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الرابعة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));


                b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                b2.setTextColor(Color.WHITE);
                b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b2.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                adapter.notifyDataSetChanged();
                break;
            case R.id.tus2:
                schedule.clear();
                schedule.add(new ScheduleItem("الحصة\n الاولى", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثانية", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثالثة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الرابعة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));


                b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                b3.setTextColor(Color.WHITE);
                b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b3.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                adapter.notifyDataSetChanged();
                break;
            case R.id.wed2:
                schedule.clear();
                schedule.add(new ScheduleItem("الحصة\n الاولى", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثانية", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثالثة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الرابعة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));


                b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                b4.setTextColor(Color.WHITE);
                b5.setTextColor(getResources().getColor(R.color.colorPrimary));

                b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b4.setBackground(getResources().getDrawable(R.drawable.roundedfill));
                b5.setBackground(getResources().getDrawable(R.drawable.roundedtext3));



                adapter.notifyDataSetChanged();
                break;
            case R.id.thur2:
                schedule.clear();
                schedule.add(new ScheduleItem("الحصة\n الاولى", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثانية", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الثالثة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));
                schedule.add(new ScheduleItem("الحصة\n الرابعة", "لغة عربية","فصل موز","من: ٠٨:٠٠","الى: ٠٨:٤٥"));


                b1.setTextColor(getResources().getColor(R.color.colorPrimary));
                b2.setTextColor(getResources().getColor(R.color.colorPrimary));
                b3.setTextColor(getResources().getColor(R.color.colorPrimary));
                b4.setTextColor(getResources().getColor(R.color.colorPrimary));
                b5.setTextColor(Color.WHITE);

                b1.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b2.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b3.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b4.setBackground(getResources().getDrawable(R.drawable.roundedtext3));
                b5.setBackground(getResources().getDrawable(R.drawable.roundedfill));

                adapter.notifyDataSetChanged();
                break;

                }


        }

}
