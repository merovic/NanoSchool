package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Adapters.RequestsFollowAdapter;
import com.amirahmed.nanoschool.Models.RequestsFollowItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;


public class RequestsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp;

    List<String> requests = new ArrayList<>();

    EditText details;

    Button sendbutton;

    SegmentedGroup tabsgroup;
    RadioButton send,follow;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout sendinglayout;

    private RecyclerView rv2;

    List<RequestsFollowItem> requestsFollowItemList;

    RequestsFollowAdapter adapterrv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

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

            mToolbar.setTitle("طلبات ولى الأمر");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("طلبات ولى الأمر");

            getActionBarTextView().setText("طلبات ولى الأمر");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RequestsActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Requests");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Requests");

            getActionBarTextView().setText("Requests");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RequestsActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        sendinglayout = findViewById(R.id.sendinglayout);
        sendinglayout.setVisibility(View.VISIBLE);

        rv2 = findViewById(R.id.rv2);
        rv2.setVisibility(View.GONE);

        tabsgroup = findViewById(R.id.segmented2);

        send = findViewById(R.id.button22);
        follow = findViewById(R.id.button21);




        details = findViewById(R.id.details);
        sendbutton = findViewById(R.id.sendbutton);

        if(language==1)
        {
            send.setText("طلب جديد");
            follow.setText("متابعة الطلبات");

            send.setChecked(true);
            follow.setChecked(false);

            requests.add("نوع الطلب");
            requests.add("طلب غياب");
            requests.add("طلب شهادة قيد");
            requests.add("طلب اثبات درجات");

            details.setHint("تفاصيل الطلب");

            sendbutton.setText("ارسال");

            sendinglayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendinglayout.setVisibility(View.VISIBLE);
                    rv2.setVisibility(View.GONE);

                }
            });

            follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendinglayout.setVisibility(View.GONE);
                    rv2.setVisibility(View.VISIBLE);

                }
            });

        }else
            {
                send.setText("Requests Following");
                follow.setText("New Request");

                send.setChecked(false);
                follow.setChecked(true);

                requests.add("Request Type");
                requests.add("Attendance Request");
                requests.add("Approval Request");
                requests.add("Transcript Request");

                details.setHint("Request Details");

                sendbutton.setText("Send");

                sendinglayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                follow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendinglayout.setVisibility(View.VISIBLE);
                        rv2.setVisibility(View.GONE);

                    }
                });

                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendinglayout.setVisibility(View.GONE);
                        rv2.setVisibility(View.VISIBLE);

                    }
                });

            }




        sp = findViewById(R.id.requests);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(RequestsActivity.this, android.R.layout.simple_spinner_item, requests);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);

        adapter.notifyDataSetChanged();


        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();


        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language==1)
                {
                    if(sp.getSelectedItemPosition()== 0 || details.getText().toString().equals(""))
                    {
                        showMessage("احد الحقول فارغة");

                    }else
                        {
                            showMessage("تم الارسال بنجاح");
                        }

                }else
                    {

                        if(sp.getSelectedItemPosition()== 0 || details.getText().toString().equals(""))
                        {
                            showMessage("Input Missing");

                        }else
                        {
                            showMessage("Sent Successfully");
                        }
                    }

                sp.setSelection(0);
                details.setText("");

            }
        });


    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
    }


    private void initializeData() {
        requestsFollowItemList = new ArrayList<>();

        if(language==1)
        {
            requestsFollowItemList.add(new RequestsFollowItem("الطلب رقم ٠٠١","طلب اثبات قيد للأدارة التعليمية",0,"تم ارسال الطلب"));
            requestsFollowItemList.add(new RequestsFollowItem("الطلب رقم ٠٠١","طلب اثبات قيد للأدارة التعليمية",0,"تم ارسال الطلب"));
            requestsFollowItemList.add(new RequestsFollowItem("الطلب رقم ٠٠١","طلب اثبات قيد للأدارة التعليمية",0,"تم ارسال الطلب"));
            requestsFollowItemList.add(new RequestsFollowItem("الطلب رقم ٠٠١","طلب اثبات قيد للأدارة التعليمية",4,"تم ارسال الطلب"));
            requestsFollowItemList.add(new RequestsFollowItem("الطلب رقم ٠٠١","طلب اثبات قيد للأدارة التعليمية",0,"تم ارسال الطلب"));
            requestsFollowItemList.add(new RequestsFollowItem("الطلب رقم ٠٠١","طلب اثبات قيد للأدارة التعليمية",0,"تم ارسال الطلب"));

        }else
        {
            requestsFollowItemList.add(new RequestsFollowItem("Request No.001","Approval Request for Education",0,"Request Prepared"));
            requestsFollowItemList.add(new RequestsFollowItem("Request No.001","Approval Request for Education",0,"Request Prepared"));
            requestsFollowItemList.add(new RequestsFollowItem("Request No.001","Approval Request for Education",0,"Request Prepared"));
            requestsFollowItemList.add(new RequestsFollowItem("Request No.001","Approval Request for Education",4,"Request Prepared"));
            requestsFollowItemList.add(new RequestsFollowItem("Request No.001","Approval Request for Education",0,"Request Prepared"));
            requestsFollowItemList.add(new RequestsFollowItem("Request No.001","Approval Request for Education",0,"Request Prepared"));

        }


    }

    private void initializeAdapter() {
        adapterrv = new RequestsFollowAdapter(requestsFollowItemList);
        rv2.setAdapter(adapterrv);
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
