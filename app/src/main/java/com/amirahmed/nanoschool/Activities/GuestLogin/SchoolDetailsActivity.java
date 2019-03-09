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

import java.lang.reflect.Field;
import java.util.HashMap;

public class SchoolDetailsActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    private SliderLayout mDemoSlider;

    LinearLayout vision,about,social,location,fees,req;

    TextView visiontext,abouttext,socialtext,locationtext,feestext,reqtext;

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
        socialtext = findViewById(R.id.socialtext);
        reqtext = findViewById(R.id.requesttext);
        feestext = findViewById(R.id.feestext);
        locationtext = findViewById(R.id.locationtext);


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
            socialtext.setText("Social Media");
            reqtext.setText("Registration");
            feestext.setText("Fees");
            locationtext.setText("Location");
        }

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

        vision = findViewById(R.id.visionlayout);
        about = findViewById(R.id.aboutlayout);
        social = findViewById(R.id.contactlayout);
        location = findViewById(R.id.locationlayout);
        fees = findViewById(R.id.feeslayout);
        req = findViewById(R.id.reglayout);

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

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , SocialMediaActivity.class );
                startActivity(intent);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolDetailsActivity.this , LocationActivity.class );
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
}
