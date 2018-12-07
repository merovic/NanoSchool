package com.amirahmed.nanoschool.Activities;

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

import com.amirahmed.nanoschool.Adapters.SchoolsListAdapter;
import com.amirahmed.nanoschool.Models.SchoolsListItem;
import com.amirahmed.nanoschool.R;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VisitorActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    private Toolbar mToolbar;

    private List<SchoolsListItem> schoolsListItems;
    private RecyclerView rv2;

    ImageView messages2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);

        mToolbar = findViewById(R.id.toolbar_actionbar);

        setSupportActionBar(mToolbar);

        mToolbar.setVisibility(View.VISIBLE);


        mToolbar.setTitle("الرئيسية");

        TextView textView = mToolbar.findViewById(R.id.toolbartext);
        textView.setText("الرئيسية");

        getActionBarTextView().setText("الرئيسية");


        getActionBarTextView().setVisibility(View.GONE);


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

        rv2 = findViewById(R.id.schools_recycler_view);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        messages2 = findViewById(R.id.messages2);

        messages2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitorActivity.this , AboutApplicationActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initializeData() {
        schoolsListItems = new ArrayList<>();

        schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","بنين و بنات"));
        schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","بنين فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","بنات فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","بنين و بنات"));
        schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","بنين فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","بنات فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","بنين و بنات"));
        schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","بنين فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","بنات فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","بنين و بنات"));
        schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","بنين فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","بنات فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة الأمل للغات","مفتوح من ٧ص - ٢م","١٥ كم","بنين و بنات"));
        schoolsListItems.add(new SchoolsListItem("مدرسة المستقبل الحديثة","مفتوح من ٧ص - ٢م","٣٧ كم","بنين فقط"));
        schoolsListItems.add(new SchoolsListItem("مدرسة العهد للتعليم المتقدم","مفتوح من ٧ص - ٢م","٤٠ كم","بنات فقط"));
    }

    private void initializeAdapter() {

        SchoolsListAdapter adapter = new SchoolsListAdapter(schoolsListItems);
        rv2.setAdapter(adapter);

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

    private TextView getActionBarTextView() {
        TextView titleTextView = null;

        try {

                Field f = mToolbar.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar);


        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return titleTextView;
    }
}
