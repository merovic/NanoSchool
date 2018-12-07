package com.amirahmed.nanoschool.Activities;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class AboutSchoolActivity extends Activity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    TinyDB tinyDB;
    int language;

    private SliderLayout mDemoSlider;

    TextView faceclick,twitterclick,snapclick;

    ImageView a,b,c,d,e,titlepic;
    TextView txt1,txt2,txt3,txt4,txt5,titletext;
    LinearLayout map,text,icons,social;
    RelativeLayout titlepicmain;

    private GoogleMap mMap;

    TimerTask hourTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutschool);

        mDemoSlider = findViewById(R.id.slider);


        HashMap<String,Integer> file_maps = new HashMap<>();
        file_maps.put("School-1",R.drawable.school);
        file_maps.put("School-2",R.drawable.school2);
        file_maps.put("School-3",R.drawable.school3);
        file_maps.put("School-4",R.drawable.school4);
        file_maps.put("School-5",R.drawable.school5);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
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


        tinyDB = new TinyDB(this);
        language = tinyDB.getInt("language");

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // Add a marker in Sydney and move the camera
                LatLng sydney = new LatLng(24.774265, 46.738586);
                mMap.addMarker(new MarkerOptions().position(sydney).title("شارع الحسن ابن حسين حى الروضة"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                mMap.getUiSettings().setScrollGesturesEnabled(false);
            }
        });


        /*ImageView im = findViewById(R.id.frame);
        Glide.with(this).load(R.drawable.frame2).into(im);*/

        map = findViewById(R.id.mapfield);
        text = findViewById(R.id.textfied);
        icons = findViewById(R.id.iconslayout);
        social = findViewById(R.id.social);
        titlepicmain = findViewById(R.id.titlepicmain);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);

        titletext = findViewById(R.id.titletext);


        a = findViewById(R.id.icon1);
        b = findViewById(R.id.icon2);
        c = findViewById(R.id.icon3);
        d = findViewById(R.id.icon4);
        e = findViewById(R.id.icon5);

        YoYo.with(Techniques.Pulse)
                .duration(1350)
                .playOn(a);

        YoYo.with(Techniques.Pulse)
                .duration(1350)
                .delay(3)
                .playOn(b);

        YoYo.with(Techniques.Pulse)
                .duration(1350)
                .delay(6)
                .playOn(c);

        YoYo.with(Techniques.Pulse)
                .duration(1350)
                .delay(9)
                .playOn(d);

        YoYo.with(Techniques.Pulse)
                .duration(1350)
                .delay(12)
                .playOn(e);


        titlepic = findViewById(R.id.titlepic);
        Glide.with(this).load(R.drawable.titleframe).into(titlepic);

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(titlepicmain);

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(text);

        Glide.with(this).load(R.drawable.aboutpic1).into(a);
        Glide.with(this).load(R.drawable.aboutpic5).into(b);
        Glide.with(this).load(R.drawable.aboutpic3).into(c);
        Glide.with(this).load(R.drawable.aboutpic4).into(d);
        Glide.with(this).load(R.drawable.aboutpic22).into(e);

        /*ImageView pic = (ImageView) findViewById(R.id.schoolpic);
        Glide.with(this).load(R.drawable.school).into(pic);*/

        text.setVisibility(View.VISIBLE);
        map.setVisibility(View.GONE);

        if(language==1)
        {
            icons.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            //Glide.with(this).load(R.drawable.rsaelna).into(titlepic);
            titletext.setText("رسالتنا");

            txt1.setText("الاهتمام بجميع نواحى النمو للطالب فكريا و سلوكيا و نفسيا و صحيا لممارسة ما يتعلمه فى الحياة العملية");
            txt2.setText("التحسين المستمر لكفايات العاملين و مهاراتهم بتطبيق احدث ما توصلت له النظريات الحديثة");
            txt3.setText("التحثين المستمر للبيئة التعليمية بما يتوافق مع متطلبات العصر");
            txt4.setText("و هذا و نسال الله العلى القدير ان يسدد خطانا الى مافيه الخير لابنائنا و خدمة الوطن");
            txt5.setText("نسعى الى تكوين عقول متطورة قادرة على ريادة المحاضر و المستقبل");
        }else
        {
            text.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            icons.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            //Glide.with(this).load(R.drawable.rsaelnaen).into(titlepic);
            titletext.setText("Message");

            txt1.setText("To Provide outstanding educational services based on international standards through:");
            txt2.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");
            txt3.setText("Giving due attentions to gifted and talented students to maximize tier achievements");
            txt4.setText("To Provide outstanding educational services based on international standards through:");
            txt5.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");
        }


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a();

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b();

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c();

            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d();

            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e();

            }
        });

        faceclick = findViewById(R.id.faceclick);
        twitterclick = findViewById(R.id.twitterclick);
        snapclick = findViewById(R.id.snapclick);

        faceclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMessage("تحت التجريب");
            }
        });

        twitterclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMessage("تحت التجريب");

            }
        });

        snapclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMessage("تحت التجريب");
            }
        });



    }

    public void a()
    {
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic12).into(a);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic5).into(b);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic3).into(c);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic4).into(d);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic2).into(e);

        map.setVisibility(View.VISIBLE);
        text.setVisibility(View.GONE);
        social.setVisibility(View.GONE);

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(map);

        if(language==1)
        {
            //Glide.with(getApplicationContext()).load(R.drawable.mawkeena).into(titlepic);
            titletext.setText("موقعنا");
        }else
        {
            //Glide.with(getApplicationContext()).load(R.drawable.mawkeenaen).into(titlepic);
            titletext.setText("Location");
        }

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(titlepicmain);
    }

    public void b()
    {
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic1).into(a);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic52).into(b);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic3).into(c);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic4).into(d);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic2).into(e);

        text.setVisibility(View.GONE);
        map.setVisibility(View.GONE);
        social.setVisibility(View.VISIBLE);

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(social);

        if(language==1)
        {
            social.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            //Glide.with(getApplicationContext()).load(R.drawable.tabeena).into(titlepic);
            titletext.setText("تابعنا");
        }else
        {
            social.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            //Glide.with(getApplicationContext()).load(R.drawable.tabeenaen).into(titlepic);
            titletext.setText("Follow");
        }

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(titlepicmain);
    }

    public void c()
    {
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic1).into(a);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic5).into(b);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic32).into(c);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic4).into(d);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic2).into(e);

        text.setVisibility(View.VISIBLE);
        map.setVisibility(View.GONE);
        social.setVisibility(View.GONE);

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(text);

        if(language==1)
        {
            txt1.setText("الحمد الله خلق الانسان و علمه البيان جاعل العقل نعم و الفكر موهبة و اثنى على النبى محمد خير الدعاه و المعلمين");
            txt2.setText("من هذا الصرح العلمى الشامخ ستكون انطلاقتنا بمشيئة الله لترسيخ مبادئ الدين الاسلامى فى نفوس ابنائنا");
            txt3.setText("و بناء فكرهم ليستنير بموكبة التطور العلمى و الثقافى و تنشئتهم تنشئه صالحه");
            txt4.setText("نسعى الى تكوين عقول متطورة قادرة على ريادة المحاضر و المستقبل");
            txt5.setText("و هذا و نسال الله العلى القدير ان يسدد خطانا الى مافيه الخير لابنائنا و خدمة الوطن");

            //Glide.with(getApplicationContext()).load(R.drawable.manger).into(titlepic);
            titletext.setText("كلمة مدير المدرسة");
        }else
        {
            txt1.setText("To Provide outstanding educational services based on international standards through:");
            txt2.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");
            txt3.setText("Giving due attentions to gifted and talented students to maximize tier achievements");
            txt4.setText("To Provide outstanding educational services based on international standards through:");
            txt5.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");

            //Glide.with(getApplicationContext()).load(R.drawable.mangeren).into(titlepic);
            titletext.setText("School Manger");
        }

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(titlepicmain);
    }

    public void d()
    {
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic1).into(a);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic5).into(b);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic3).into(c);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic42).into(d);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic2).into(e);

        text.setVisibility(View.VISIBLE);
        map.setVisibility(View.GONE);
        social.setVisibility(View.GONE);

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(text);

        if(language==1)
        {
            txt1.setText("و بناء فكرهم ليستنير بموكبة التطور العلمى و الثقافى و تنشئتهم تنشئه صالحه");
            txt2.setText("نسعى الى تكوين عقول متطورة قادرة على ريادة المحاضر و المستقبل");
            txt3.setText("و هذا و نسال الله العلى القدير ان يسدد خطانا الى مافيه الخير لابنائنا و خدمة الوطن");
            txt4.setText("الحمد الله خلق الانسان و علمه البيان جاعل العقل نعم و الفكر موهبة و اثنى على النبى محمد خير الدعاه و المعلمين");
            txt5.setText("من هذا الصرح العلمى الشامخ ستكون انطلاقتنا بمشيئة الله لترسيخ مبادئ الدين الاسلامى فى نفوس ابنائنا");

            //Glide.with(getApplicationContext()).load(R.drawable.ahdafna).into(titlepic);
            titletext.setText("اهدافنا");
        }else
        {
            txt1.setText("To Provide outstanding educational services based on international standards through:");
            txt2.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");
            txt3.setText("Giving due attentions to gifted and talented students to maximize tier achievements");
            txt4.setText("To Provide outstanding educational services based on international standards through:");
            txt5.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");

            //Glide.with(getApplicationContext()).load(R.drawable.ahdafnaen).into(titlepic);
            titletext.setText("Goals");
        }

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(titlepicmain);
    }

    public void e()
    {
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic1).into(a);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic5).into(b);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic3).into(c);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic4).into(d);
        Glide.with(getApplicationContext()).load(R.drawable.aboutpic22).into(e);

        text.setVisibility(View.VISIBLE);
        map.setVisibility(View.GONE);
        social.setVisibility(View.GONE);

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(text);

        if(language==1)
        {
            txt1.setText("الاهتمام بجميع نواحى النمو للطالب فكريا و سلوكيا و نفسيا و صحيا لممارسة ما يتعلمه فى الحياة العملية");
            txt2.setText("التحسين المستمر لكفايات العاملين و مهاراتهم بتطبيق احدث ما توصلت له النظريات الحديثة");
            txt3.setText("التحثين المستمر للبيئة التعليمية بما يتوافق مع متطلبات العصر");
            txt4.setText("و هذا و نسال الله العلى القدير ان يسدد خطانا الى مافيه الخير لابنائنا و خدمة الوطن");
            txt5.setText("نسعى الى تكوين عقول متطورة قادرة على ريادة المحاضر و المستقبل");

            //Glide.with(getApplicationContext()).load(R.drawable.rsaelna).into(titlepic);
            titletext.setText("رسالتنا");
        }else
        {
            txt1.setText("To Provide outstanding educational services based on international standards through:");
            txt2.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");
            txt3.setText("Giving due attentions to gifted and talented students to maximize tier achievements");
            txt4.setText("To Provide outstanding educational services based on international standards through:");
            txt5.setText("Paying attentions to all aspects of studying growth behavioral psychological and physical");

            //Glide.with(getApplicationContext()).load(R.drawable.rsaelnaen).into(titlepic);
            titletext.setText("Message");
        }

        YoYo.with(Techniques.BounceIn)
                .duration(1350)
                .playOn(titlepicmain);
    }

    public void some()
    {
        Timer timer = new Timer();
        hourTask = new TimerTask() {
            @Override
            public void run() {

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        switch (titletext.getText().toString())
                        {
                            case "رسالتنا":
                                a();
                                break;
                            case "اهدافنا":
                                b();
                                break;
                            case "كلمة مدير المدرسة":
                                c();
                                break;
                            case "تابعنا":
                                d();
                                break;
                            case "موقعنا":
                                e();
                                break;
                            case "Message":
                                a();
                                break;
                            case "Goals":
                                b();
                                break;
                            case "School Manger":
                                c();
                                break;
                            case "Follow":
                                d();
                                break;
                            case "Location":
                                e();
                                break;
                        }


                    }
                });


            }
        };
        timer.schedule(hourTask, 0L, 1000 * 3);
    }


    @Override
    protected void onDestroy() {
        mDemoSlider.stopAutoCycle();
        super.onDestroy();
    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {}

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onSliderClick(BaseSliderView slider) {}
}
