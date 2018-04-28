package com.amirahmed.nanoschool.Activities;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Fragments.WatchFragment;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.AddButtonClick;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Field;

public class WatchSyncActivity extends AppCompatActivity{

    Button scanbutton;

    TextView textView;

    private Toolbar mToolbar,mToolbar2;

    WatchFragment watchFragment;

    TinyDB tinyDB;

    int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchsync);

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

            mToolbar.setTitle("الساعة الزكية");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الساعة الزكية");

            getActionBarTextView().setText("الساعة الزكية");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WatchSyncActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Smart Watch");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Smart Watch");

            getActionBarTextView().setText("Smart Watch");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WatchSyncActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        scanbutton = findViewById(R.id.scanbutton);
        textView = findViewById(R.id.text);

        if(language==1)
        {
            scanbutton.setText("مزامنة");
            textView.setText("قم بالضغط على مزامنة حتى يتم ربط هاتفك بالساعة الذكية مما سيمكنك من تتبع طفلك");
        }else
            {
                scanbutton.setText("Sync");
                textView.setText("Press on Sync to Connect your Phone with the Smartwatch to Track your Son");
            }


        final Activity activity = this;


        scanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
                //Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();
                //watchid.setText(result.getContents());
                EventBus.getDefault().post(new AddButtonClick(result.getContents()));

                final FragmentManager fm = getFragmentManager();
                watchFragment = new WatchFragment();

                watchFragment.show(fm,"TV_tag");

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }

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
