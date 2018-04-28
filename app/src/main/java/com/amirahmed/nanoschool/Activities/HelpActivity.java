package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.amirahmed.nanoschool.R.id.sendbutton;

public class HelpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp;

    List<String> requests = new ArrayList<>();

    EditText details;

    Button send;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout sendinglayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

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

            mToolbar.setTitle("المساعدة");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("المساعدة");

            getActionBarTextView().setText("المساعدة");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HelpActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Help");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Help");

            getActionBarTextView().setText("Help");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HelpActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        sp = findViewById(R.id.requests);



        details = findViewById(R.id.details);
        send = findViewById(sendbutton);

        sendinglayout = findViewById(R.id.sendinglayout);


        if(language==1)
        {

            requests.add("استفسار");
            requests.add("مشكلة");
            requests.add("اقتراح");

            details.setHint("تفاصيل الطلب");

            send.setText("ارسال");

            sendinglayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        }else
        {
            requests.add("Enquiry");
            requests.add("Problem");
            requests.add("Suggestion");

            details.setHint("Request Details");

            send.setText("Send");

            sendinglayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(HelpActivity.this, android.R.layout.simple_spinner_item, requests);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);

        adapter.notifyDataSetChanged();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setSelection(0);
                details.setText("");
                if(language==1)
                {
                    showMessage("تم الارسال بنجاح");
                }else
                    {
                        showMessage("Sent Successfully");
                    }

            }
        });

    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
