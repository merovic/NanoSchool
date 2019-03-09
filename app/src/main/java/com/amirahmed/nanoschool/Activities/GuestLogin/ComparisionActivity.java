package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.GuestLogin.ComparisonAdapter;
import com.amirahmed.nanoschool.Adapters.GuestLogin.CultureAdapter;
import com.amirahmed.nanoschool.Models.GuestLogin.ComparisonItem;
import com.amirahmed.nanoschool.Models.GuestLogin.CultureItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ComparisionActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    private List<ComparisonItem> comparisonItemList;
    private RecyclerView rv2;

    LinearLayout header;

    TextView school1,school2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        header = findViewById(R.id.headerlayout);
        school1 = findViewById(R.id.school1);
        school2 = findViewById(R.id.school2);

        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("مقارنة المدارس");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("مقارنة المدارس");

            getActionBarTextView().setText("مقارنة المدارس");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ComparisionActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Culture");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Culture");

            getActionBarTextView().setText("Culture");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ComparisionActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            header.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            school1.setText("El-Amaal School");
            school2.setText("Elmostakbal School");
        }

        rv2 = findViewById(R.id.comparison_rv);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        comparisonItemList = new ArrayList<>();

        if (language == 1) {

            comparisonItemList.add(new ComparisonItem("٧ كم","المسافة","٥ كم"));
            comparisonItemList.add(new ComparisonItem("جميع المراحل","المراحل","تمهيدى"));
            comparisonItemList.add(new ComparisonItem("بنين","نوع الطلاب","مشتركة"));
            comparisonItemList.add(new ComparisonItem("حطين","الحى","قرطبة"));
            comparisonItemList.add(new ComparisonItem("صباحى","الدوام","صباحى"));
            comparisonItemList.add(new ComparisonItem("امريكى","المنهج","امريكى"));
            comparisonItemList.add(new ComparisonItem("-","الأعتماد","ADVone"));
            comparisonItemList.add(new ComparisonItem("١٣","متوسط عدد الطلاب","١٥"));
            comparisonItemList.add(new ComparisonItem("١","الملاعب","٢"));
            comparisonItemList.add(new ComparisonItem("٢","المسابح","١"));
            comparisonItemList.add(new ComparisonItem("٢","المكتبات","١"));
            comparisonItemList.add(new ComparisonItem("لا يوجد","التسجيل الألكترونى","نعم"));
            comparisonItemList.add(new ComparisonItem("لا يوجد","خصم التسجيل المبكر","٥٪"));
            comparisonItemList.add(new ComparisonItem("١٠٪","خصم المجموعات","٧٪"));
            comparisonItemList.add(new ComparisonItem("٢٠٠٠","مصروفات الصف التمهيدى الأول","٢٢٠٠"));
            comparisonItemList.add(new ComparisonItem("٣٠٠٠","مصروفات الصف التمهيدى الثانى","٣٢٠٠"));
            comparisonItemList.add(new ComparisonItem("٤٠٠٠","مصروفات الصف التمهيدى الثالث","٤٢٠٠"));
            comparisonItemList.add(new ComparisonItem("٥٠٠٠","مصروفات الصف الأبتدائى","٥٢٠٠"));
            comparisonItemList.add(new ComparisonItem("٦٠٠٠","مصروفات الصف الاعدادى","٦٢٠٠"));


        } else {

            comparisonItemList.add(new ComparisonItem("7 km","Distance","5 km"));
            comparisonItemList.add(new ComparisonItem("All Levels","Levels","Experimental"));
            comparisonItemList.add(new ComparisonItem("Boys","Genders","Multi"));
            comparisonItemList.add(new ComparisonItem("Hateen","District","Kortoba"));
            comparisonItemList.add(new ComparisonItem("Morning","Time","Morning"));
            comparisonItemList.add(new ComparisonItem("American","Course","American"));
            comparisonItemList.add(new ComparisonItem("-","Certification","ADVone"));
            comparisonItemList.add(new ComparisonItem("13","Students Average","15"));
            comparisonItemList.add(new ComparisonItem("1","Pitches","1"));
            comparisonItemList.add(new ComparisonItem("2","Pools","1"));
            comparisonItemList.add(new ComparisonItem("2","Libraries","1"));
            comparisonItemList.add(new ComparisonItem("Not Available","Online Registration","Available"));
            comparisonItemList.add(new ComparisonItem("Not Available","Early Apply Discount","5%"));
            comparisonItemList.add(new ComparisonItem("10%","Groups Discount","7%"));
            comparisonItemList.add(new ComparisonItem("2000","Early Stage 1 Fees","2200"));
            comparisonItemList.add(new ComparisonItem("3000","Early Stage 2 Fees","3200"));
            comparisonItemList.add(new ComparisonItem("4000","Early Stage 3 Fees","4200"));
            comparisonItemList.add(new ComparisonItem("5000","Primary Stage Fees","5200"));
            comparisonItemList.add(new ComparisonItem("6000","Preparatory Stage Fees","6200"));

        }
    }

    private void initializeAdapter() {

        ComparisonAdapter adapter = new ComparisonAdapter(comparisonItemList);
        rv2.setAdapter(adapter);

    }

    private TextView getActionBarTextView() {
        TextView titleTextView = null;

        try {
            if (language == 1) {
                Field f = mToolbar.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar);
            } else {
                Field f = mToolbar2.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar2);
            }

        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return titleTextView;
    }

}