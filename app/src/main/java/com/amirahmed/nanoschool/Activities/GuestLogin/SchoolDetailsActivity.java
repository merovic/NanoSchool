package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Activities.LoginActivity;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Field;
import java.util.HashMap;

public class SchoolDetailsActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener,OnMapReadyCallback {

    private GoogleMap mMap;
    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    private SliderLayout mDemoSlider;

    LinearLayout vision,about,location,fees,req,bottommenu;

    TextView visiontext,abouttext,feestext,reqtext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);

        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        visiontext = findViewById(R.id.visiontext);
        abouttext = findViewById(R.id.abouttext);
        reqtext = findViewById(R.id.requesttext);
        feestext = findViewById(R.id.feestext);


        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("تفاصيل المدرسة");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("تفاصيل المدرسة");

            getActionBarTextView().setText("تفاصيل المدرسة");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolDetailsActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("School Details");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("School Details");

            getActionBarTextView().setText("School Details");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SchoolDetailsActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            visiontext.setText("Vision");
            abouttext.setText("About School");
            reqtext.setText("Registration");
            feestext.setText("Fees");
        }

        mDemoSlider = findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("Banner 1", "https://image.shutterstock.com/image-photo/teacher-asking-question-her-class-450w-309241172.jpg");
        url_maps.put("Banner 2", "https://image.shutterstock.com/image-photo/kids-raising-hands-teacher-elementary-450w-667966174.jpg");
        url_maps.put("Banner 3", "https://image.shutterstock.com/image-photo/kids-showing-hands-during-lesson-450w-667978948.jpg");
        url_maps.put("Banner 4", "https://image.shutterstock.com/image-photo/teacher-asking-question-her-class-450w-309241172.jpg");
        url_maps.put("Banner 5", "https://image.shutterstock.com/image-photo/kids-raising-hands-teacher-elementary-450w-667966174.jpg");


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

        vision = findViewById(R.id.visionlayout);
        about = findViewById(R.id.aboutlayout);
        location = findViewById(R.id.locationlayout);
        fees = findViewById(R.id.feeslayout);
        req = findViewById(R.id.reglayout);
        bottommenu = findViewById(R.id.bottommenu);

        if(language!=1)
        {
            bottommenu.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }

        vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , SchoolVisionActivity.class );
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , AboutSchoolActivity.class );
                startActivity(intent);
            }
        });


        fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , FeesActivity.class );
                startActivity(intent);
            }
        });

        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , DiscountRequestActivity.class );
                startActivity(intent);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

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
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(24.638007, 46.712315)).title("El-Eleem School");

        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(24.821367, 46.780950));

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.schoolguest));
        marker2.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationsocial));

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(24.638007, 46.712315);
        LatLng sydney2 = new LatLng(24.821367, 46.780950);

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.addMarker(marker2);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney2));

        mMap.animateCamera( CameraUpdateFactory.zoomTo( 10.0f ));
    }
}
