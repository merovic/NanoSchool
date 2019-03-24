package com.amirahmed.nanoschool.Activities.GuestLogin;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout firstname,lastname,email,password,birthdate,phone,gender,sub;

    EditText firstnameedit,lastnameedit,emailedit,passwordedit,birthdateedit,phoneedit;

    Button registration;

    Spinner genderspinner;

    List<String> genderlist = new ArrayList<>();

    Calendar myCalendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        firstname = findViewById(R.id.firstnamelayout);
        lastname = findViewById(R.id.lastnamelayout);
        email = findViewById(R.id.emaillayout);
        password = findViewById(R.id.passwordlayout);
        birthdate = findViewById(R.id.birthdatelayout);
        phone = findViewById(R.id.phonelayout);
        gender = findViewById(R.id.genderlayout);
        sub = findViewById(R.id.sub);

        firstnameedit = findViewById(R.id.firstname);
        lastnameedit = findViewById(R.id.lastname);
        emailedit = findViewById(R.id.email);
        passwordedit = findViewById(R.id.password);
        birthdateedit = findViewById(R.id.birthdate);
        phoneedit = findViewById(R.id.phone);

        registration = findViewById(R.id.sendbutton);


        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("تسجيل الدخول");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("تسجيل الدخول");

            getActionBarTextView().setText("تسجيل الدخول");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RegistrationActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);

            genderlist.add("اختر النوع");
            genderlist.add("ولد");
            genderlist.add("بنت");

        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Registration");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Registration");

            getActionBarTextView().setText("Registration");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RegistrationActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            firstnameedit.setHint("First Name");
            lastnameedit.setHint("Last Name");
            emailedit.setHint("Email");
            passwordedit.setHint("Password");
            birthdateedit.setHint("Birth date");
            phoneedit.setHint("Phone Number");

            firstname.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            lastname.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            email.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            password.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            gender.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            birthdate.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            phone.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            sub.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            registration.setText("Register");

            genderlist.add("Choose Gender");
            genderlist.add("Male");
            genderlist.add("Female");

        }

        genderspinner = findViewById(R.id.gender);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(RegistrationActivity.this, android.R.layout.simple_spinner_item, genderlist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderspinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();


        myCalendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        birthdateedit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RegistrationActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

}

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthdateedit.setText(sdf.format(myCalendar.getTime()));
    }

    private TextView getActionBarTextView() {
        TextView titleTextView = null;

        try {
            if (language == 1) {
                Field f = mToolbar.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar);
            } else {
                Field f = mToolbar2.getClass().getDeclaredField("mTitleTextView");
                f.setAccessible(true);
                titleTextView = (TextView) f.get(mToolbar2);
            }

        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return titleTextView;
    }
}
