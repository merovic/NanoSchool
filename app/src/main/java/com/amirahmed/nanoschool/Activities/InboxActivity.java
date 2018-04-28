package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.InboxAdapter;
import com.amirahmed.nanoschool.Models.InboxItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class InboxActivity extends AppCompatActivity {

    private List<InboxItem> inboxItems;
    private RecyclerView rv2;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

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

            mToolbar.setTitle("الرسائل الواردة");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الرسائل الوارد");

            getActionBarTextView().setText("الرسائل الوارد");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InboxActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Inbox");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Inbox");

            getActionBarTextView().setText("Inbox");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InboxActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }


        rv2 = findViewById(R.id.inbox_recycler_view);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

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


    private void initializeData() {
        inboxItems = new ArrayList<>();

        if (language == 1) {

            inboxItems.add(new InboxItem("احمد ابراهيم السيد", "الاستفسار عن موعد الاختبار القادم", "من فضلك استفسر عن معاد الامتحان القادم حتى اتابع نجلى فى دروسه و لأكون ايضا على معرفة بكل المطلوب منه حتى يجتاز على الامتحان و شكرا جزيلا لك", "٠٨-١٢-٢٠١٨"));
            inboxItems.add(new InboxItem("احمد ابراهيم السيد", "الاستفسار عن موعد الاختبار القادم", "من فضلك استفسر عن معاد الامتحان القادم حتى اتابع نجلى فى دروسه و لأكون ايضا على معرفة بكل المطلوب منه حتى يجتاز على الامتحان و شكرا جزيلا لك", "٠٨-١٢-٢٠١٨"));
            inboxItems.add(new InboxItem("احمد ابراهيم السيد", "الاستفسار عن موعد الاختبار القادم", "من فضلك استفسر عن معاد الامتحان القادم حتى اتابع نجلى فى دروسه و لأكون ايضا على معرفة بكل المطلوب منه حتى يجتاز على الامتحان و شكرا جزيلا لك", "٠٨-١٢-٢٠١٨"));
            inboxItems.add(new InboxItem("احمد ابراهيم السيد", "الاستفسار عن موعد الاختبار القادم", "من فضلك استفسر عن معاد الامتحان القادم حتى اتابع نجلى فى دروسه و لأكون ايضا على معرفة بكل المطلوب منه حتى يجتاز على الامتحان و شكرا جزيلا لك", "٠٨-١٢-٢٠١٨"));
            inboxItems.add(new InboxItem("احمد ابراهيم السيد", "الاستفسار عن موعد الاختبار القادم", "من فضلك استفسر عن معاد الامتحان القادم حتى اتابع نجلى فى دروسه و لأكون ايضا على معرفة بكل المطلوب منه حتى يجتاز على الامتحان و شكرا جزيلا لك", "٠٨-١٢-٢٠١٨"));
            inboxItems.add(new InboxItem("احمد ابراهيم السيد", "الاستفسار عن موعد الاختبار القادم", "من فضلك استفسر عن معاد الامتحان القادم حتى اتابع نجلى فى دروسه و لأكون ايضا على معرفة بكل المطلوب منه حتى يجتاز على الامتحان و شكرا جزيلا لك", "٠٨-١٢-٢٠١٨"));


        } else {
            inboxItems.add(new InboxItem("Ahmed Ibrahim Elsayed","Next Exam Time","Please i want to know the next exam time in order to follow my son during his study process to make him pass the exam successfully and thank you","08-12-2018"));
            inboxItems.add(new InboxItem("Ahmed Ibrahim Elsayed","Next Exam Time","Please i want to know the next exam time in order to follow my son during his study process to make him pass the exam successfully and thank you","08-12-2018"));
            inboxItems.add(new InboxItem("Ahmed Ibrahim Elsayed","Next Exam Time","Please i want to know the next exam time in order to follow my son during his study process to make him pass the exam successfully and thank you","08-12-2018"));
            inboxItems.add(new InboxItem("Ahmed Ibrahim Elsayed","Next Exam Time","Please i want to know the next exam time in order to follow my son during his study process to make him pass the exam successfully and thank you","08-12-2018"));
            inboxItems.add(new InboxItem("Ahmed Ibrahim Elsayed","Next Exam Time","Please i want to know the next exam time in order to follow my son during his study process to make him pass the exam successfully and thank you","08-12-2018"));
            inboxItems.add(new InboxItem("Ahmed Ibrahim Elsayed","Next Exam Time","Please i want to know the next exam time in order to follow my son during his study process to make him pass the exam successfully and thank you","08-12-2018"));
            inboxItems.add(new InboxItem("Ahmed Ibrahim Elsayed","Next Exam Time","Please i want to know the next exam time in order to follow my son during his study process to make him pass the exam successfully and thank you","08-12-2018"));

        }
    }

    private void initializeAdapter() {

        InboxAdapter adapter = new InboxAdapter(inboxItems);
        rv2.setAdapter(adapter);

    }
}
