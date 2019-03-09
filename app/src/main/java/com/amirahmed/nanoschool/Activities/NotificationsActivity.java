package com.amirahmed.nanoschool.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.NotificationsAdapter;
import com.amirahmed.nanoschool.MainActivity;
import com.amirahmed.nanoschool.Models.NotificationItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<NotificationItem> notificationsItems;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;
    int language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

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

            mToolbar.setTitle("الاشعارات");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الاشعارات");

            getActionBarTextView().setText("الاشعارات");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(NotificationsActivity.this , MainActivity.class);
                    startActivity(intent);
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Notifications");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Notifications");

            getActionBarTextView().setText("Notifications");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(NotificationsActivity.this , MainActivity.class);
                    startActivity(intent);
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        mRecyclerView = findViewById(R.id.notification_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {

        notificationsItems = new ArrayList<>();
        if(language==1)
        {
            notificationsItems.add(new NotificationItem("تنبيه هام غياب","سوف يتم انعقاد اجتماع مجلس الاباء غا الساعة الخامسة عصرا و برجاء عدم التأخير "));
            notificationsItems.add(new NotificationItem("تنبيه هام اجتماع","سوف يتم انعقاد اجتماع مجلس الاباء غا الساعة الخامسة عصرا و برجاء عدم التأخير "));
            notificationsItems.add(new NotificationItem("تنبيه هام غياب","سوف يتم انعقاد اجتماع مجلس الاباء غا الساعة الخامسة عصرا و برجاء عدم التأخير "));
            notificationsItems.add(new NotificationItem("تنبيه هام اجتماع","سوف يتم انعقاد اجتماع مجلس الاباء غا الساعة الخامسة عصرا و برجاء عدم التأخير "));
            notificationsItems.add(new NotificationItem("تنبيه هام غياب","سوف يتم انعقاد اجتماع مجلس الاباء غا الساعة الخامسة عصرا و برجاء عدم التأخير "));
        }else
        {
            notificationsItems.add(new NotificationItem("Important Alert Attendance","Parents supreme will be held tomorrow 5pm so please come in time"));
            notificationsItems.add(new NotificationItem("Important Alert Meeting","Parents supreme will be held tomorrow 5pm so please come in time"));
            notificationsItems.add(new NotificationItem("Important Alert Attendance","Parents supreme will be held tomorrow 5pm so please come in time"));
            notificationsItems.add(new NotificationItem("Important Alert Meeting","Parents supreme will be held tomorrow 5pm so please come in time"));
            notificationsItems.add(new NotificationItem("Important Alert Attendance","Parents supreme will be held tomorrow 5pm so please come in time"));
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

    private void initializeAdapter() {

        NotificationsAdapter adapter = new NotificationsAdapter(notificationsItems);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NotificationsActivity.this , MainActivity.class );
        startActivity(intent);
    }
}
