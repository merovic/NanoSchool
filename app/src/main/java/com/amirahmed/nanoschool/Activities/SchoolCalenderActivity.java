package com.amirahmed.nanoschool.Activities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Adapters.SchoolCalAdapter;
import com.amirahmed.nanoschool.Models.SchoolEvent;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class SchoolCalenderActivity extends AppCompatActivity {

    List<Event> events,eventsMonth,eventscurrent;
    //TextView date;
    String month,year;

    private Toolbar mToolbar,mToolbar2;

    LinearLayout umblayout;

    TextView umbtext;

    private RecyclerView mRecyclerView;
    private List<SchoolEvent> eventsItems = new ArrayList<>();

    Calendar cal;

    TextView eventname,dayname,datenormal,datehijry,textnull;

    String [] colomndays;

    TinyDB tinydb;

    int x,y;
    int language;

    SimpleDateFormat month_date;

    DateFormat fullDate = new SimpleDateFormat("MMMM");
    DateFormat fullDatear = new SimpleDateFormat("MMMM",new Locale("ar"));
    DateFormat yearOnly = new SimpleDateFormat("yyyy");
    DateFormat monthOnly = new SimpleDateFormat("MM");
    DateFormat dayOnly = new SimpleDateFormat("dd");
    DateFormat dayName = new SimpleDateFormat("EEEE",new Locale("ar"));

    SchoolCalAdapter adapter;

    int position = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolcalender);

        tinydb = new TinyDB(getApplicationContext());

        language = tinydb.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        umblayout = findViewById(R.id.umblayout);
        umbtext = findViewById(R.id.umbtext);

        if(language==1)
        {
            umblayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            umbtext.setText("العطلات الرسمية");

        }else
            {
                umblayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                umbtext.setText("Official Vacation");
            }

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("التقويم الدراسى");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("التقويم الدراسى");

            getActionBarTextView().setText("التقويم الدراسى");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolCalenderActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Calendar");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Calendar");

            getActionBarTextView().setText("Calendar");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolCalenderActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }


        mRecyclerView = findViewById(R.id.schoolcal_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new SchoolCalAdapter(eventsItems);
        mRecyclerView.setAdapter(adapter);


        eventname = findViewById(R.id.eventname);
        dayname = findViewById(R.id.dayname);
        datenormal = findViewById(R.id.date1);
        datehijry = findViewById(R.id.date2);
        textnull = findViewById(R.id.textnull);

        if(language==1)
        {
            textnull.setText("لا يوجد عطلات رسمية هذا الشهر");
        }else
            {
                textnull.setText("No Official Vacations this Month");
            }

        JodaTimeAndroid.init(this);


        if(adapter.getItemCount()==0)
        {
            mRecyclerView.setVisibility(View.GONE);
            textnull.setVisibility(View.VISIBLE);
        }else
        {
            mRecyclerView.setVisibility(View.VISIBLE);
            textnull.setVisibility(View.GONE);
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

        String[] names = {"name1","name2","name3"};

        events = new ArrayList<>();

        if(language==1)
        {
            events.add(new Event(Color.RED,1497441600000L,"عيد الاضحى"));
            events.add(new Event(Color.RED,1497441600000L,"عيد الام"));
            events.add(new Event(Color.RED,1507233696000L,"عيد العمال"));
        }else
            {
                events.add(new Event(Color.RED,1497441600000L,"Adhaa Eid"));
                events.add(new Event(Color.RED,1497441600000L,"Mothers Day"));
                events.add(new Event(Color.RED,1507233696000L,"Workers Day"));
            }




        eventscurrent = compactCalendarView.getEventsForMonth(cal.getTime().getMonth());
        Calendar calendar = Calendar.getInstance();

        int dayhiii = Integer.valueOf(dayOnly.format(calendar.getTime()));
        int monthhiii = Integer.valueOf(monthOnly.format(calendar.getTime()));
        int yearhiii = Integer.valueOf(yearOnly.format(calendar.getTime()));


        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();

        LocalDate todayIso = new LocalDate(yearhiii, monthhiii, dayhiii, iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);

        for(int i=0;i<eventscurrent.size();i++)
        {
            long mili = eventscurrent.get(i).getTimeInMillis();
            calendar.setTimeInMillis(mili);
            if(language==1)
            {
                eventsItems.add(new SchoolEvent(String.valueOf(eventsMonth.get(i).getData())
                        ,String.valueOf(dayOnly.format(calendar.getTime()))
                        ,String.valueOf(fullDatear.format(calendar.getTime()))
                        ,String.valueOf(todayHijri)));
            }else
                {
                    eventsItems.add(new SchoolEvent(String.valueOf(eventsMonth.get(i).getData())
                            ,String.valueOf(dayOnly.format(calendar.getTime()))
                            ,String.valueOf(fullDate.format(calendar.getTime()))
                            ,String.valueOf(todayHijri)));
                }

        }

        //date = findViewById(R.id.date);
        //date2 = (TextView) findViewById(R.id.year);

        //date.setText(month);
        //date2.setText(year);

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

                if(events.isEmpty())
                {
                    if(language==1)
                    {
                        showMessage("لا يوجد اى احداث فى هذا اليوم");
                    }else
                        {
                            showMessage("No Events in that Day");
                        }

                } else
                {
                    String eventnamee = String.valueOf(events.get(0).getData());
                    long mili = events.get(0).getTimeInMillis();

                    fullDate = new SimpleDateFormat("dd/MM/yyyy");
                    yearOnly = new SimpleDateFormat("yyyy");
                    monthOnly = new SimpleDateFormat("MM");
                    dayOnly = new SimpleDateFormat("dd");
                    dayName = new SimpleDateFormat("EEEE");

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(mili);

                    int day = Integer.valueOf(dayOnly.format(calendar.getTime()));
                    int month = Integer.valueOf(monthOnly.format(calendar.getTime()));
                    int year = Integer.valueOf(yearOnly.format(calendar.getTime()));


                    Chronology iso = ISOChronology.getInstanceUTC();
                    Chronology hijri = IslamicChronology.getInstanceUTC();

                    LocalDate todayIso = new LocalDate(year, month, day, iso);
                    LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);

                    String hijrydate = String.valueOf(todayHijri);

                    String normaldatee = fullDate.format(calendar.getTime());

                    String daynamee = dayName.format(calendar.getTime());

                    eventname.setText(eventnamee);
                    datehijry.setText(hijrydate);
                    datenormal.setText(normaldatee);
                    dayname.setText(daynamee);
                }


            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {


                position = 0;

                eventsMonth = new ArrayList<>();


                eventsMonth.clear();
                eventscurrent.clear();

                eventsItems.clear();

                x=0;
                y=0;

                eventsMonth = compactCalendarView.getEventsForMonth(firstDayOfNewMonth);


                Calendar calendar = Calendar.getInstance();
                int dayhi = Integer.valueOf(dayOnly.format(calendar.getTime()));
                int monthhi = Integer.valueOf(monthOnly.format(calendar.getTime()));
                int yearhi = Integer.valueOf(yearOnly.format(calendar.getTime()));

                Chronology iso = ISOChronology.getInstanceUTC();
                Chronology hijri = IslamicChronology.getInstanceUTC();

                LocalDate todayIso = new LocalDate(yearhi, monthhi, dayhi, iso);
                LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);

                for(int i=0;i<eventsMonth.size();i++)
                {

                    Object o = eventsMonth.get(i).getData();

                    assert o != null;
                    if(o.getClass().isArray() ) {
                        for(int j = 0; j< Array.getLength(o); j++){
                            showMessage((String) Array.get(o, j));
                        }
                    }

                    long mili = eventsMonth.get(i).getTimeInMillis();
                    calendar.setTimeInMillis(mili);
                    if(language==1)
                    {
                        eventsItems.add(new SchoolEvent(String.valueOf(eventsMonth.get(i).getData())
                                ,String.valueOf(dayOnly.format(calendar.getTime()))
                                ,String.valueOf(fullDatear.format(calendar.getTime().getMonth()))
                                //new SimpleDateFormat("MMM").format(cal.getTime())
                                ,String.valueOf(todayHijri)));

                    }else
                        {
                            eventsItems.add(new SchoolEvent(String.valueOf(eventsMonth.get(i).getData())
                                    ,String.valueOf(dayOnly.format(calendar.getTime()))
                                    ,String.valueOf(fullDate.format(calendar.getTime().getMonth()))
                                    //new SimpleDateFormat("MMM").format(cal.getTime())
                                    ,String.valueOf(todayHijri)));
                        }

                }

                adapter.notifyDataSetChanged();


                if(adapter.getItemCount()==0)
                {
                    mRecyclerView.setVisibility(View.GONE);
                    textnull.setVisibility(View.VISIBLE);
                }else
                {
                    mRecyclerView.setVisibility(View.VISIBLE);
                    textnull.setVisibility(View.GONE);
                }




                /*year = Integer.toString(firstDayOfNewMonth.getYear());
                String damnn =  year.substring(year.length() - 1);
                char c = year.charAt(1);



                if(Character.toString(c).equals("2"))
                {
                    damn2 = ("202" + damnn);

                } else
                {
                    damn2 = ("201" + damnn);
                }

                date2.setText(damn2);*/



                /*switch (firstDayOfNewMonth.getMonth() + 1)
                {
                    case 1:
                        if(language==1)
                        {
                            month = "يناير";
                        }else
                        {
                            month = "January";
                        }

                        date.setText(month);
                        break;
                    case 2:
                        if(language==1)
                        {
                            month = "فبراير";
                        }else
                        {
                            month = "February";
                        }

                        date.setText(month);
                        break;
                    case 3:
                        if(language==1)
                        {
                            month = "مارس";
                        }else
                        {
                            month = "March";
                        }

                        date.setText(month);
                        break;
                    case 4:
                        if(language==1)
                        {
                            month = "ابريل";
                        }else
                        {
                            month = "April";
                        }

                        date.setText(month);
                        break;
                    case 5:
                        if(language==1)
                        {
                            month = "مايو";
                        }else
                        {
                            month = "May";
                        }

                        date.setText(month);
                        break;
                    case 6:
                        if(language==1)
                        {
                            month = "يونيو";
                        }else
                        {
                            month = "June";
                        }

                        date.setText(month);
                        break;
                    case 7:
                        if(language==1)
                        {
                            month = "يوليو";
                        }else
                        {
                            month = "July";
                        }

                        date.setText(month);
                        break;
                    case 8:
                        if(language==1)
                        {
                            month = "اغسطس";
                        }else
                        {
                            month = "August";
                        }

                        date.setText(month);
                        break;
                    case 9:
                        if(language==1)
                        {
                            month = "سبتمبر";
                        }else
                        {
                            month = "September";

                        }

                        date.setText(month);
                        break;
                    case 10:
                        if(language==1)
                        {
                            month = "اكتوبر";
                        }else
                        {
                            month = "October";
                        }

                        date.setText(month);
                        break;
                    case 11:
                        if(language==1)
                        {
                            month = "نوفمبر";
                        }else
                        {
                            month = "November";
                        }

                        date.setText(month);
                        break;
                    case 12:
                        if(language==1)
                        {
                            month = "ديسمبر";
                        }else
                        {
                            month = "December";
                        }

                        date.setText(month);
                        break;*/
               // }

                x = 0;
                y = 0;
            }
        });


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


    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

}
