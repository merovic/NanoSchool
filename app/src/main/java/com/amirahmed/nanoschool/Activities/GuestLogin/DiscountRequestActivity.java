package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    LinearLayout container,header,name,email,mobile,sons,levels;

    EditText nameedittext,mobileedittext,emailedittext,detailsedittext;

    Spinner sonsspinner,levelsspinner;

    List<String> sonslist = new ArrayList<>();
    List<String> levelslist = new ArrayList<>();

    Button send;

    TextView schoolname,schoollevels,headertext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        tinyDB = new TinyDB(getApplicationContext());
        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        container = findViewById(R.id.containerlayout);

        schoolname = findViewById(R.id.schoolname);

        schoollevels = findViewById(R.id.schoollevels);

        headertext = findViewById(R.id.headertext);
        header = findViewById(R.id.headerlayout);

        name = findViewById(R.id.namelayout);
        email = findViewById(R.id.emaillayout);
        mobile = findViewById(R.id.mobilelayout);
        sons = findViewById(R.id.sonslayout);
        levels = findViewById(R.id.levelslayout);

        nameedittext = findViewById(R.id.name);
        mobileedittext = findViewById(R.id.mobile);
        emailedittext = findViewById(R.id.email);
        detailsedittext = findViewById(R.id.details);

        send = findViewById(R.id.sendbutton);


        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("طلب خصم");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("طلب خصم");

            getActionBarTextView().setText("طلب خصم");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DiscountRequestActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

            levelslist.add("اختر المرحلة التعليمية");
            sonslist.add("اختر عدد الأبناء");

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Discount Request");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Discount Request");

            getActionBarTextView().setText("Discount Request");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DiscountRequestActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            schoolname.setText("EL-Eleem Educational School");

            schoollevels.setText("International | All Levels");

            header.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            headertext.setText("Discount Request");

            name.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            email.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            mobile.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            sons.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            levels.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            nameedittext.setHint("Enter Name");
            mobileedittext.setHint("Mobile Number");
            emailedittext.setHint("Email Address");
            detailsedittext.setHint("Notes");

            send.setText("Send");

            levelslist.add("Enter Educational Level");
            sonslist.add("Enter Number of Kids");
        }

        levelslist.add("KG 1-2");
        levelslist.add("Grade 1-6");
        levelslist.add("KG 4-2");

        sonslist.add("1");
        sonslist.add("2");
        sonslist.add("3");
        sonslist.add("4");
        sonslist.add("5");

        sonsspinner = findViewById(R.id.sons);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(DiscountRequestActivity.this, android.R.layout.simple_spinner_item, sonslist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sonsspinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        levelsspinner = findViewById(R.id.levels);

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
