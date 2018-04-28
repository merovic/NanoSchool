package com.amirahmed.nanoschool.Activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;


public class NotificationsDetailsActivity extends Activity {

    TextView tx,tx2;
    ImageView back;

    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_notifidetails);

        tinyDB = new TinyDB(this);


        tx = findViewById(R.id.notifidetails);
        tx2 = findViewById(R.id.notifititle);

        Bundle extras  = getIntent().getExtras();

        String notificationdetails = extras.getString("details");
        String notificationtitle = extras.getString("title");

        tx.setText(notificationdetails);
        tx2.setText(notificationtitle);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NotificationsDetailsActivity.this , NotificationsActivity.class );
        startActivity(intent);
    }
}
