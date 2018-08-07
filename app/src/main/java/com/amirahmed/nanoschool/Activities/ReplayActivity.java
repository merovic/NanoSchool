package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;

public class ReplayActivity extends AppCompatActivity{


    EditText teacheredittext,titleedit,content;

    Button send;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");
        if(language==1)
        {
            setContentView(R.layout.activity_messages);
        }else
        {
            setContentView(R.layout.activity_messages_en);
        }


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

            mToolbar.setTitle("الرد");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الرد");

            getActionBarTextView().setText("الرد");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReplayActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Replay");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Replay");

            getActionBarTextView().setText("Replay");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReplayActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);


        }

        Bundle extras  = getIntent().getExtras();

        String sender = extras.getString("Sender");

        String title = extras.getString("title");

        teacheredittext = findViewById(R.id.teacheredittext);
        titleedit = findViewById(R.id.editText);
        send = findViewById(R.id.sendbutton);

        teacheredittext.setText(sender);
        titleedit.setText(title);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(language==1)
                {
                    showMessage("تم الارسال بنجاح");
                }else
                {
                    showMessage("Send Successfully");
                }

                finish();

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
}
