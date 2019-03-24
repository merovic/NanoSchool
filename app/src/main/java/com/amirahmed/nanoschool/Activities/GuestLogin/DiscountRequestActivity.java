package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.RequestsActivity;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DiscountRequestActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout container,header,name,email,mobile,sons,levels,mobilemain,add,kidname,level,row,sub,sub2;

    EditText nameedittext,mobileedittext,emailedittext,detailsedittext,codeedittext,kidnameedittext;

    CheckBox additional;

    Spinner rowsspinner,levelsspinner;

    List<String> rowslist = new ArrayList<>();
    List<String> levelslist = new ArrayList<>();

    Button send;

    TextView schoolname,discountetext,headertext,addtext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");
        if(language==1)
        {
            setContentView(R.layout.activity_discount);
        }else
            {
                setContentView(R.layout.activity_discount_en);
            }


        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        container = findViewById(R.id.containerlayout);

        schoolname = findViewById(R.id.schoolname);

        discountetext = findViewById(R.id.discounttext);

        headertext = findViewById(R.id.headertext);
        header = findViewById(R.id.headerlayout);

        addtext = findViewById(R.id.addtext);

        name = findViewById(R.id.namelayout);
        email = findViewById(R.id.emaillayout);
        mobile = findViewById(R.id.mobilelayout);
        sons = findViewById(R.id.sonslayout);
        levels = findViewById(R.id.levelslayout);
        mobilemain = findViewById(R.id.mobilemainlayout);
        add = findViewById(R.id.addlayout);
        kidname = findViewById(R.id.kidnamelayout);
        level = findViewById(R.id.levellayout);
        row = findViewById(R.id.rowlayout);
        sub = findViewById(R.id.sub);
        sub2 = findViewById(R.id.sub2);

        nameedittext = findViewById(R.id.name);
        mobileedittext = findViewById(R.id.mobile);
        emailedittext = findViewById(R.id.email);
        detailsedittext = findViewById(R.id.details);
        codeedittext = findViewById(R.id.code);
        kidnameedittext = findViewById(R.id.kidname);

        additional = findViewById(R.id.additionalcheck);
        send = findViewById(R.id.sendbutton);


        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("طلب تسجيل");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("طلب تسجيل");

            getActionBarTextView().setText("طلب تسجيل");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DiscountRequestActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

            levelslist.add("اختر المرحلة التعليمية");

            levelslist.add("اختر المرحلة");
            levelslist.add("الأبتدائية");
            levelslist.add("الأعدادية");
            levelslist.add("الثانوية");

            rowslist.add("اختر الصف");
            rowslist.add("١-١");
            rowslist.add("٢-١");
            rowslist.add("٣-١");
            rowslist.add("٤-١");
            rowslist.add("٥-١");

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Registration Request");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Registration Request");

            getActionBarTextView().setText("Registration Request");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DiscountRequestActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            schoolname.setText("EL-Eleem Educational School");

            discountetext.setText("School Accepts Installments");

            header.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            headertext.setText("Discount Request");

            name.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            email.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            mobile.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            sons.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            levels.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            add.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            kidname.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            level.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            row.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            sub.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            sub2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            mobilemain.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            nameedittext.setHint("Enter your Name");
            mobileedittext.setHint("Mobile Number");
            emailedittext.setHint("Email Address");
            detailsedittext.setHint("Notes");
            kidnameedittext.setHint("Son Name");

            addtext.setText("Add Sons");

            additional.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            additional.setText("Request Additional Discount");

            send.setText("Send");

            levelslist.add("Enter Educational Level");

            levelslist.add("Choose Level");
            levelslist.add("Primary");
            levelslist.add("Intermediate");
            levelslist.add("Secondary");

            rowslist.add("Choose Grade");
            rowslist.add("1-1");
            rowslist.add("2-1");
            rowslist.add("3-1");
            rowslist.add("4-1");
            rowslist.add("5-1");
        }



        rowsspinner = findViewById(R.id.row);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(DiscountRequestActivity.this, android.R.layout.simple_spinner_item, rowslist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rowsspinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        levelsspinner = findViewById(R.id.level);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(DiscountRequestActivity.this, android.R.layout.simple_spinner_item, levelslist);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelsspinner.setAdapter(adapter2);

        adapter2.notifyDataSetChanged();


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
