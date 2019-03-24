package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DistanceSelectionActivity extends AppCompatActivity {

    LinearLayout layout1;

    TinyDB tinyDB;

    int language;

    private Toolbar mToolbar,mToolbar2;

    Spinner distancespinner;

    List<String> distancelist = new ArrayList<>();

    LinearLayout layout;

    Button milebutton,kmbutton;

    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_distance);


        tinyDB = new TinyDB(getApplicationContext());

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        layout1 = findViewById(R.id.distancelayout);

        layout = findViewById(R.id.layout);

        milebutton = findViewById(R.id.milebutton);

        kmbutton = findViewById(R.id.kmbutton);

        text = findViewById(R.id.text);

        if(language==1)
        {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("الاعدادات");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الاعدادات");

            getActionBarTextView().setText("الاعدادات");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    DistanceSelectionActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

            distancelist.add("كم");
            distancelist.add("ميل");

        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Setting");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Setting");

            getActionBarTextView().setText("Setting");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DistanceSelectionActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            layout1.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            layout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            distancelist.add("Km");
            distancelist.add("Mile");

            kmbutton.setText("KM");
            milebutton.setText("Miles");

            text.setText("Distance");

        }

        distancespinner = findViewById(R.id.distance);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(DistanceSelectionActivity.this, android.R.layout.simple_spinner_item, distancelist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distancespinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        milebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kmbutton.setBackground(getDrawable(R.drawable.roundedtext3));
                milebutton.setBackground(getDrawable(R.drawable.roundedfill));

                kmbutton.setTextColor(Color.parseColor("#4690D9"));
                milebutton.setTextColor(Color.WHITE);
            }
        });

        kmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kmbutton.setBackground(getDrawable(R.drawable.roundedfill));
                milebutton.setBackground(getDrawable(R.drawable.roundedtext3));

                kmbutton.setTextColor(Color.WHITE);
                milebutton.setTextColor(Color.parseColor("#4690D9"));
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
}
