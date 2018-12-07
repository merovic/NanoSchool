package com.amirahmed.nanoschool;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Activities.AboutApplicationActivity;
import com.amirahmed.nanoschool.Activities.AboutSchoolActivity;
import com.amirahmed.nanoschool.Activities.AttendanceActivity;
import com.amirahmed.nanoschool.Activities.CallingActivity;
import com.amirahmed.nanoschool.Activities.ExamsActivity;
import com.amirahmed.nanoschool.Activities.GalleryActivity;
import com.amirahmed.nanoschool.Activities.HelpActivity;
import com.amirahmed.nanoschool.Activities.InboxActivity;
import com.amirahmed.nanoschool.Activities.LoginActivity;
import com.amirahmed.nanoschool.Activities.MapsActivity;
import com.amirahmed.nanoschool.Activities.MessagesActivity;
import com.amirahmed.nanoschool.Activities.MyProfileActivity;
import com.amirahmed.nanoschool.Activities.NotificationsActivity;
import com.amirahmed.nanoschool.Activities.PlanActivity;
import com.amirahmed.nanoschool.Activities.RequestsActivity;
import com.amirahmed.nanoschool.Activities.ScheduleActivity;
import com.amirahmed.nanoschool.Activities.SchoolCalenderActivity;
import com.amirahmed.nanoschool.Activities.ScoresSelectActivity;
import com.amirahmed.nanoschool.Activities.SettingActivity;
import com.amirahmed.nanoschool.Activities.WatchSyncActivity;
import com.amirahmed.nanoschool.Fragments.NavigationDrawerFragment;
import com.amirahmed.nanoschool.Utils.NavigationDrawerCallbacks;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;


public class MainActivity extends Activity implements NavigationDrawerCallbacks,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    DrawerLayout drawerLayout;

    LinearLayout container;

    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;

    LinearLayout planlayout,attendlayout,examslayout,evaluationlayout,schedulelayout,messageslayout,requestslayout,callinglayout,locationlayout;

    ImageView messages,notifications,about;

    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);

        //RTL==>EN  LTR==>AR
        container = findViewById(R.id.containerlayout);

        planlayout = findViewById(R.id.planlayout);
        attendlayout = findViewById(R.id.attendlayout);
        examslayout = findViewById(R.id.examslayout);
        evaluationlayout = findViewById(R.id.evaluationlayout);
        schedulelayout = findViewById(R.id.schedulelayout);
        messageslayout = findViewById(R.id.messageslayout);
        requestslayout = findViewById(R.id.requestslayout);
        callinglayout = findViewById(R.id.callinglayout);
        locationlayout = findViewById(R.id.locationlayout);

        messages = findViewById(R.id.messages);
        notifications = findViewById(R.id.notifications);
        about = findViewById(R.id.about);

        textView1 = findViewById(R.id.sqeduletext);
        textView2 = findViewById(R.id.plantext);
        textView3 = findViewById(R.id.attendancetext);
        textView4 = findViewById(R.id.examstext);
        textView5 = findViewById(R.id.feedbacktext);
        textView6 = findViewById(R.id.callingtext);
        textView7 = findViewById(R.id.locationtext);
        textView8 = findViewById(R.id.messagetext);
        textView9 = findViewById(R.id.requeststext);

        tinyDB = new TinyDB(getApplicationContext());

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            drawerLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            textView1.setText("الجدول");
            textView2.setText("الخطة");
            textView3.setText("الغياب");
            textView4.setText("الاختبارات");
            textView5.setText("التقييم");
            textView6.setText("النداء");
            textView7.setText("الموقع");
            textView8.setText("الرسائل");
            textView9.setText("طلبات ولى الامر");



        }else
        {
            mToolbar.setVisibility(View.GONE);
            mToolbar2.setVisibility(View.VISIBLE);

            drawerLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            container.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            textView1.setText("Schedule");
            textView2.setText("Plan");
            textView3.setText("Attendance");
            textView4.setText("Exams");
            textView5.setText("Evaluation");
            textView6.setText("Calling");
            textView7.setText("Location");
            textView8.setText("Messages");
            textView9.setText("Requests");



        }

        planlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, PlanActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        attendlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, AttendanceActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        examslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ExamsActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        evaluationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoresSelectActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        schedulelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScheduleActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        messageslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MessagesActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        requestslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, RequestsActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        callinglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, CallingActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        locationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, InboxActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, NotificationsActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, AboutSchoolActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });



        mDemoSlider = findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("Banner 1", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523623875/WhatsApp_Image_2018-04-13_at_10.13.26_AM.jpg");
        url_maps.put("Banner 2", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624016/WhatsApp_Image_2018-04-13_at_10.13.26_AM-2.jpg");
        url_maps.put("Banner 3", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624029/WhatsApp_Image_2018-04-13_at_10.13.26_AM-3.jpg");
        url_maps.put("Banner 4", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624041/WhatsApp_Image_2018-04-13_at_10.13.27_AM.jpg");
        url_maps.put("Banner 5", "http://res.cloudinary.com/dtec9smtu/image/upload/v1523624058/WhatsApp_Image_2018-04-13_at_10.13.27_AM-2.jpg");


        HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("School-1",R.drawable.school);
        file_maps.put("School-2",R.drawable.school2);
        file_maps.put("School-3",R.drawable.school3);
        file_maps.put("School-4",R.drawable.school4);
        file_maps.put("School-5",R.drawable.school5);

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);



        // Set up the drawer.
        if(language==1)
        {
            mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        }else
            {
                mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar2);
            }

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        if(position==0)
        {
            Intent intent = new Intent(MainActivity.this , MyProfileActivity.class);
            startActivity(intent);
        }else if (position==1)
        {
            Intent intent = new Intent(MainActivity.this , SchoolCalenderActivity.class);
            startActivity(intent);
        }else if (position==2)
        {
            Intent intent = new Intent(MainActivity.this , WatchSyncActivity.class);
            startActivity(intent);
        }else if (position==3)
        {
            Intent intent = new Intent(MainActivity.this , GalleryActivity.class);
            startActivity(intent);
        }else if (position==4)
        {
            Intent intent = new Intent(MainActivity.this , HelpActivity.class);
            startActivity(intent);
        }else if (position==5)
        {
            Intent intent = new Intent(MainActivity.this , AboutApplicationActivity.class);
            startActivity(intent);
        }else if (position==6)
        {
            Intent intent = new Intent(MainActivity.this , SettingActivity.class);
            startActivity(intent);
        }else if(position==7)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if(language==1)
            {
                builder.setMessage("هل حقا تريد تسجيل الخروج ؟");
            }else
            {
                builder.setMessage("Are You Sure You Want to Logout ?");
            }

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity.this , LoginActivity.class );
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("No",null);
            builder.show();
        }
    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
