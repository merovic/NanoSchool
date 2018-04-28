package com.amirahmed.nanoschool.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.lang.reflect.Field;

public class EvaluationInteractionActivity extends AppCompatActivity {

    private Toolbar mToolbar,mToolbar2;

    LinearLayout layout1,layout2,layout3,commentlayout;

    TextView commentbody,comment;

    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;

    ImageView st1,st2,st3,st4,st5,st6,st7,st8,st9;

    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;

    Boolean stv1,stv2,stv3,stv4,stv5,stv6,stv7,stv8,stv9;

    TinyDB tinyDB;

    int language;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        commentlayout = findViewById(R.id.commentlayout);


        comment = findViewById(R.id.comment);
        commentbody = findViewById(R.id.commentass);


        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);
        textView5 = findViewById(R.id.text5);
        textView6 = findViewById(R.id.text6);
        textView7 = findViewById(R.id.text7);
        textView8 = findViewById(R.id.text8);
        textView9 = findViewById(R.id.text9);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);

        st1 = findViewById(R.id.st1);
        st2 = findViewById(R.id.st2);
        st3 = findViewById(R.id.st3);
        st4 = findViewById(R.id.st4);
        st5 = findViewById(R.id.st5);
        st6 = findViewById(R.id.st6);
        st7 = findViewById(R.id.st7);
        st8 = findViewById(R.id.st8);
        st9 = findViewById(R.id.st9);

        stv1 = true;
        stv2 = true;
        stv3 = false;
        stv4 = true;
        stv5 = true;
        stv6 = false;
        stv7 = true;
        stv8 = true;
        stv9 = false;

        st1.setImageDrawable(getResources().getDrawable(R.drawable.redx));
        st2.setImageDrawable(getResources().getDrawable(R.drawable.checkgreen));
        st3.setImageDrawable(getResources().getDrawable(R.drawable.checkgreen));
        st4.setImageDrawable(getResources().getDrawable(R.drawable.checkgreen));
        st5.setImageDrawable(getResources().getDrawable(R.drawable.redx));
        st6.setImageDrawable(getResources().getDrawable(R.drawable.checkgreen));
        st7.setImageDrawable(getResources().getDrawable(R.drawable.checkgreen));
        st8.setImageDrawable(getResources().getDrawable(R.drawable.checkgreen));
        st9.setImageDrawable(getResources().getDrawable(R.drawable.redx));


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

            mToolbar.setTitle("التقييم");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("التقييم");

            getActionBarTextView().setText("التقييم");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EvaluationInteractionActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);


            layout1.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            layout2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            layout3.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            commentlayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);



            comment.setText("تعليق المعلم بشأن هذا الطالب *");
            commentbody.setText("هذا الطالب فى تقدم مستمر");


            textView1.setText("الواجب");
            textView2.setText("التفاعل");
            textView3.setText("الانتباه");
            textView4.setText("الكتابة");
            textView5.setText("احضار الكتاب");
            textView6.setText("احترام المعلم");
            textView7.setText("عام");
            textView8.setText("متطور");
            textView9.setText("الشجار");


        }else
        {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("Evaluation");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("Evaluation");

            getActionBarTextView().setText("Evaluation");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EvaluationInteractionActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);


            layout1.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            layout2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            layout3.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

            commentlayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);


            comment.setText("Teacher Comment about this Student");
            commentbody.setText("This Student is Developing");


            textView1.setText("Homework");
            textView2.setText("Interaction");
            textView3.setText("Attention");
            textView4.setText("Writing");
            textView5.setText("Books");
            textView6.setText("Respect");
            textView7.setText("General");
            textView8.setText("Advanced");
            textView9.setText("Fighting");

        }


    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
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
