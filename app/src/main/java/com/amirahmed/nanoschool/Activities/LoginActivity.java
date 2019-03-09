package com.amirahmed.nanoschool.Activities;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Activities.GuestLogin.VisitorActivity;
import com.amirahmed.nanoschool.MainActivity;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import co.infinum.goldfinger.Error;
import co.infinum.goldfinger.Goldfinger;

public class LoginActivity extends Activity{

    Button login,visitor;

    TinyDB tinyDB;

    LinearLayout username,password;

    TextInputLayout usernametext,passwordtext;

    AutoCompleteTextView usernametext1,passwordtext1;

    TextView resetpass;

    int language;

    Goldfinger goldfinger;

    ImageView fingerprint;

    ImageView mainpic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        tinyDB = new TinyDB(getApplicationContext());

        tinyDB.putInt("language",2);

        language = tinyDB.getInt("language");

        goldfinger = new Goldfinger.Builder(this).build();

        fingerprint = findViewById(R.id.fingerprint);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        usernametext = findViewById(R.id.usenametext);
        passwordtext = findViewById(R.id.passwordtext);

        usernametext1 = findViewById(R.id.usenametext1);
        passwordtext1 = findViewById(R.id.passwordtext1);

        resetpass = findViewById(R.id.resetpass);

        login = findViewById(R.id.loginbutton);
        visitor = findViewById(R.id.visitorbutton);

        mainpic = findViewById(R.id.mainpic);

        if(language == 1)
        {
            Glide.with(getApplicationContext()).load(R.drawable.schoolamain).into(mainpic);
        }else
            {
                username.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                password.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                Glide.with(getApplicationContext()).load(R.drawable.schoolamainen).into(mainpic);

                usernametext.setTextDirection(View.TEXT_DIRECTION_LTR);
                passwordtext.setTextDirection(View.TEXT_DIRECTION_LTR);


                usernametext.setHint("Username");
                passwordtext.setHint("Password");

                resetpass.setText("Forget Password ?");

                login.setText("Sign in");
                visitor.setText("Guest");
            }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fingerprint.getVisibility()==View.VISIBLE)
                {
                    Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                    startActivity(intent);
                }else
                    {

                        if(usernametext1.getText().toString().equals(""))
                        {
                            if(language==1)
                            {
                                showMessage("ادخل اسم المستخدم اولا");
                            }else
                            {
                                //showMessage("Enter username first");
                            }
                        }else
                        {
                            tinyDB.putString("username",usernametext1.getText().toString());

                            Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                            startActivity(intent);
                        }

                    }



            }
        });

        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this , VisitorActivity.class);
                startActivity(intent);

                tinyDB.putString("Setting","Guest");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (goldfinger.hasFingerprintHardware() && goldfinger.hasEnrolledFingerprint()) {

          if(tinyDB.getString("username").equals(""))
          {
              username.setVisibility(View.VISIBLE);
              password.setVisibility(View.VISIBLE);
              fingerprint.setVisibility(View.GONE);
          }else
              {
                  username.setVisibility(View.GONE);
                  password.setVisibility(View.GONE);
                  fingerprint.setVisibility(View.VISIBLE);

                  login.setEnabled(false);
                  authenticateUserFingerprint();
              }

        }else
            {
                if(tinyDB.getString("username").equals(""))
                {
                   // showMessage("Enter a Username");
                }else
                    {
                        username.setVisibility(View.VISIBLE);
                        password.setVisibility(View.VISIBLE);
                        fingerprint.setVisibility(View.GONE);

                        login.setEnabled(true);
                    }

            }
    }

    @Override
    protected void onStop() {
        super.onStop();
        goldfinger.cancel();
    }

    private void authenticateUserFingerprint() {
        goldfinger.authenticate(new Goldfinger.Callback() {
            @Override
            public void onError(Error error) {
               fingerprint.setColorFilter(Color.RED);
                login.setEnabled(false);
            }

            @Override
            public void onSuccess(String value) {
                fingerprint.setColorFilter(Color.GREEN);
                login.setEnabled(true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }
}
