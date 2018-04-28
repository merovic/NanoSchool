package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;


public class CallingActivity extends AppCompatActivity{

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    Button button;

    TextView calling;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

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

            mToolbar.setTitle("النداء");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("النداء");

            getActionBarTextView().setText("النداء");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CallingActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Calling");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Calling");

            getActionBarTextView().setText("Calling");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CallingActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language==1)
                {
                    showMessage("تم ارسال النداء بنجاح برجاء الانتظار ٥ دقائق حتى خروج نجلكم");
                }else
                {
                    showMessage("Calling sent successfully please wait 5 min until your son exit");
                }

            }
        });

        calling = findViewById(R.id.calling);

        if (language==1)
        {
            calling.setText("قم بالضغط على زر النداء عند وصولك للمدرسة حتى يتم اخراج ابنكم الى باب المدرسة وذلك لضمان أمان الطالب و تفادى وقوفه منفردا فترة طويلة");
            button.setText("ابدا النداء");

        }else
            {
                calling.setText("Press calling button when you reach the school to exit your son to the door to keep him safe an avoid leaving him alone for a long period of time");
                button.setText("Start Calling");
            }

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

}
