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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Fragments.TeachersListFragment;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.AddButtonClick;
import com.amirahmed.nanoschool.Utils.TinyDB;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

public class MessagesActivity extends AppCompatActivity{

    EditText teacheredittext,title,content,attachedit;

    TeachersListFragment teachersListFragment;

    Button send,attach;

    private Toolbar mToolbar,mToolbar2;

    TinyDB tinyDB;

    int language;

    private ArrayList<String> docPaths = new ArrayList<>();

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

            mToolbar.setTitle("الرسائل");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("الرسائل");

            getActionBarTextView().setText("الرسائل");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MessagesActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Messages");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Messages");

            getActionBarTextView().setText("Messages");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MessagesActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);
        }

        final FragmentManager fm = getFragmentManager();
        teachersListFragment = new TeachersListFragment();


        teacheredittext = findViewById(R.id.teacheredittext);

        teacheredittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                teachersListFragment.show(fm,"TV_tag");

            }
        });

        title = findViewById(R.id.editText);
        content = findViewById(R.id.content);
        attachedit = findViewById(R.id.attachedit);
        send = findViewById(R.id.sendbutton);
        attach = findViewById(R.id.attachbutton);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacheredittext.setText("");
                title.setText("");
                content.setText("");

                if(language==1)
                {
                    showMessage("تم الارسال بنجاح");
                }else
                    {
                        showMessage("Send Successfully");
                    }


            }
        });

        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FilePickerBuilder.getInstance().setMaxCount(10)
                        .setSelectedFiles(docPaths)
                        .setActivityTheme(R.style.LibAppTheme)
                        .pickFile(MessagesActivity.this);
            }
        });

    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {

            case FilePickerConst.REQUEST_CODE_DOC:
                if(resultCode== Activity.RESULT_OK && data!=null)
                {
                    docPaths = new ArrayList<>();
                    docPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_DOCS));

                    attachedit.setText(docPaths.get(0));
                }
                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onButtonClick(AddButtonClick addButtonClick)
    {
        String name = addButtonClick.getName();
        teacheredittext.setText(name);

        teachersListFragment.dismiss();
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
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
