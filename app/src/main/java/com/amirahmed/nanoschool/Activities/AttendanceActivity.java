package com.amirahmed.nanoschool.Activities;


import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.CircleDisplay;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import net.danlew.android.joda.JodaTimeAndroid;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class AttendanceActivity extends AppCompatActivity {

    List<Event> events,eventsMonth,eventscurrent;
    String month,year;

    private Toolbar mToolbar,mToolbar2;

    Calendar cal;

    String [] colomndays;

    TinyDB tinydb;

    int x,y;
    int language;

    CircleDisplay cd,cd2,cd3;

    SimpleDateFormat month_date;

    LinearLayout tab1layout,tab2layout,layout1,layout2,layout11,layout12;

    TextView tab1text,tab2text,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;

    View tab1view,tab2view;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        JodaTimeAndroid.init(this);

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

            mToolbar.setTitle("الغياب");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الغياب");

            getActionBarTextView().setText("الغياب");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AttendanceActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Attendance");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Attendance");

            getActionBarTextView().setText("Attendance");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AttendanceActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }



        final CompactCalendarView compactCalendarView = findViewById(R.id.compactcalendar_view);

        cal=Calendar.getInstance();
        if(language==1)
        {
            month_date = new SimpleDateFormat("MMMM",new Locale("ar"));



        }else
        {
            month_date = new SimpleDateFormat("MMMM",new Locale("en"));


        }

        month = month_date.format(cal.getTime());
        year = Integer.toString(cal.get(Calendar.YEAR));

        // JSON Return must be ( 1- Date of absence 2- Type of absence with excuse or without ) the date will be converted to epoch and the type of absence will be give a color red in case of without and yellow in case of with)

        // String DateFromJson = "2014/10/29
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd")
        // Date date = sdf.parse(DateFromJson)
        // long epoch = date.getTime();

        //int red = Color.RED;
        //int yellow = Color.YELLOW;

        List<String> classes = new ArrayList<>();
        classes.add("324");
        classes.add("112");
        classes.add("150");

        events = new ArrayList<>();
        events.add(new Event(Color.RED,1497441600000L,"fuck1"));
        events.add(new Event(Color.YELLOW,1497441600000L,"fuck2"));
        events.add(new Event(Color.RED,1497441600000L));
        events.add(new Event(Color.YELLOW,1497441600000L));


        eventscurrent = compactCalendarView.getEventsForMonth(cal.getTime().getMonth());

        for(int i = 0; i <eventscurrent.size();i++)
        {
            if(eventscurrent.get(i).getColor()==Color.RED)
            {
                x = x + 1;

            }else
            {
                y = y + 1;
            }
        }


        cd = findViewById(R.id.circleDisplay);

        cd.setAnimDuration(3000);
        cd.setValueWidthPercent(15f);
        cd.setTextSize(13f);
        cd.setColor(Color.parseColor("#69B746"));
        cd.setDrawText(true);
        cd.setDrawInnerCircle(true);
        cd.setFormatDigits(0);
        cd.setTouchEnabled(false);
        cd.setUnit("%");
        cd.setStepSize(0.5f);


        cd2 = findViewById(R.id.circleDisplay2);

        cd2.setAnimDuration(3000);
        cd2.setValueWidthPercent(15f);
        cd2.setTextSize(13f);
        cd2.setColor(Color.parseColor("#FBA403"));
        cd2.setDrawText(true);
        cd2.setDrawInnerCircle(true);
        cd2.setFormatDigits(0);
        cd2.setTouchEnabled(false);
        cd2.setUnit("%");
        cd2.setStepSize(0.5f);


        cd3 = findViewById(R.id.circleDisplay3);

        cd3.setAnimDuration(3000);
        cd3.setValueWidthPercent(15f);
        cd3.setTextSize(13f);
        cd3.setColor(Color.parseColor("#0AACD9"));
        cd3.setDrawText(true);
        cd3.setDrawInnerCircle(true);
        cd3.setFormatDigits(0);
        cd3.setTouchEnabled(false);
        cd3.setUnit("%");
        cd3.setStepSize(0.5f);

        cd.showValue((float) (((10-(x + y))*100))/10, 100f, true);
        cd2.showValue((float) x, 10f, true);
        cd3.showValue((float) y, 10f, true);




        compactCalendarView.setFirstDayOfWeek(Calendar.SATURDAY);


        if(language==1)
        {
            colomndays = new String[]{"السبت", "الاحد", "الاثنين", "الثلاثاء", "الاربعاء", "الخميس", "الجمعة"};
        }else
        {
            colomndays = new String[]{"Sat","Sun","Mon","Tues","Wed","Thu","fri"};
        }


        compactCalendarView.setDayColumnNames(colomndays);

        compactCalendarView.setIsRtl(true);
        compactCalendarView.setClickable(false);

        compactCalendarView.addEvents(events);





        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                events = compactCalendarView.getEvents(dateClicked);
                Log.d(TAG, "Day was clicked: " + dateClicked + " with events " + events);

/*
                    if(events.isEmpty())
                    {
                        showMessage("No Events in that Day");
                    } else
                        {
                            String text = String.valueOf(events.get(0).getData());
                            long mili = events.get(0).getTimeInMillis();

                            DateFormat fullDate = new SimpleDateFormat("dd/MM/yyyy");
                            DateFormat yearOnly = new SimpleDateFormat("yyyy");
                            DateFormat monthOnly = new SimpleDateFormat("MM");
                            DateFormat dayOnly = new SimpleDateFormat("dd");
                            DateFormat dayName = new SimpleDateFormat("EEEE");

                            Calendar calendar = Calendar.getInstance();
                            calendar.setTimeInMillis(mili);

                            int day = Integer.valueOf(dayOnly.format(calendar.getTime()));
                            int month = Integer.valueOf(monthOnly.format(calendar.getTime()));
                            int year = Integer.valueOf(yearOnly.format(calendar.getTime()));


                            Chronology iso = ISOChronology.getInstanceUTC();
                            Chronology hijri = IslamicChronology.getInstanceUTC();

                            LocalDate todayIso = new LocalDate(year, month, day, iso);
                            LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);

                            String hijry = String.valueOf(todayHijri);

                            String text2 = fullDate.format(calendar.getTime());


                            showMessage(hijry);
                        }*/


            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

                eventsMonth = new ArrayList<>();


                eventsMonth.clear();

                x = 0;
                y = 0;

                eventsMonth = compactCalendarView.getEventsForMonth(firstDayOfNewMonth);


                for(int i = 0; i <eventsMonth.size();i++)
                {
                    if(eventsMonth.get(i).getColor()==Color.RED)
                    {
                        x = x + 1;

                    }else
                    {
                        y = y + 1;
                    }
                }

                cd.showValue((float) (((10-(x + y))*100))/10, 100f, true);
                cd2.showValue((float) x, 10f, true);
                cd3.showValue((float) y, 10f, true);



                x = 0;
                y = 0;
            }
        });

        tab1layout = findViewById(R.id.tab1layout);
        tab2layout = findViewById(R.id.tab2layout);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout11 = findViewById(R.id.layout11);
        layout12 = findViewById(R.id.layout12);

        tab1text = findViewById(R.id.tab1text);
        tab2text = findViewById(R.id.tab2text);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);
        textView5 = findViewById(R.id.text5);
        textView6 = findViewById(R.id.text6);
        textView7 = findViewById(R.id.text7);
        textView8 = findViewById(R.id.text8);
        textView9 = findViewById(R.id.text9);

        tab1view = findViewById(R.id.tab1view);
        tab2view = findViewById(R.id.tab2view);

        if(language==1)
        {
            tab1text.setText("نسبة الحضور و الغياب");
            tab2text.setText("عدد الايام و الحصص");

            layout11.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            layout12.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            textView1.setText("نسبة الحضور و الغياب بعزر او بدون");
            textView2.setText("الحضور");
            textView3.setText("غياب بعزر");
            textView4.setText("غياب بدون عزر");
            textView5.setText("حضور");
            textView6.setText("غياب بعزر");
            textView7.setText("غياب بدون عزر");
            textView8.setText("الايام");
            textView9.setText("الحصص");

            layout2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            textView5.setTextSize(18);
            textView6.setTextSize(18);
            textView7.setTextSize(18);
            textView8.setTextSize(18);
            textView9.setTextSize(18);

        }else
            {
                tab1text.setText("Attendance Rate");
                tab2text.setText("Days and Classes");

                layout11.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                layout12.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                textView1.setText("Attendance Rate with or without excuse");
                textView2.setText("Attendance");
                textView3.setText("Absence with Excuse");
                textView4.setText("Absence without Excuse");
                textView5.setText("Attend");
                textView6.setText("Absence with excuse");
                textView7.setText("Absence without excuse");
                textView8.setText("Days");
                textView9.setText("Lessons");

                layout2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                textView5.setTextSize(12);
                textView6.setTextSize(12);
                textView7.setTextSize(12);
                textView8.setTextSize(12);
                textView9.setTextSize(12);
            }


        tab1layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tab1text.setTextColor(Color.parseColor("#4690D9"));
                tab1view.setVisibility(View.VISIBLE);

                tab2text.setTextColor(Color.BLACK);
                tab2view.setVisibility(View.INVISIBLE);

                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);

            }
        });

        tab2layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tab1text.setTextColor(Color.BLACK);
                tab1view.setVisibility(View.INVISIBLE);

                tab2text.setTextColor(Color.parseColor("#4690D9"));
                tab2view.setVisibility(View.VISIBLE);

                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);

            }
        });


    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
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

    private long datetoepochConverter(String date) throws ParseException {

        return new SimpleDateFormat("MM/dd/yyyy").parse(date).getTime() / 1000;
    }

}
