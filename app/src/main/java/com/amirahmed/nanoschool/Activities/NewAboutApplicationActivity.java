package com.amirahmed.nanoschool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.codemybrainsout.ratingdialog.RatingDialog;

import java.lang.reflect.Field;


public class NewAboutApplicationActivity extends AppCompatActivity {

    private Toolbar mToolbar, mToolbar2;

    TinyDB tinyDB;

    int language;

    LinearLayout aboutlayout,termslayout,ratelayout,sharelayout;

    TextView abouttext,termstext,ratetext,sharetext;

    ImageView arrow1,arrow2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaboutapplication);

        tinyDB = new TinyDB(this);

        language = tinyDB.getInt("language");

        mToolbar = findViewById(R.id.toolbar_actionbar);
        mToolbar2 = findViewById(R.id.toolbar_actionbar_en);
        setSupportActionBar(mToolbar);
        setSupportActionBar(mToolbar2);

        ImageView arrow = mToolbar.findViewById(R.id.arrow);
        ImageView arrowen = mToolbar2.findViewById(R.id.arrowen);

        aboutlayout = findViewById(R.id.abouttap);
        termslayout = findViewById(R.id.termstap);
        ratelayout = findViewById(R.id.ratetap);
        sharelayout = findViewById(R.id.sharetap);

        abouttext = findViewById(R.id.text1);
        termstext = findViewById(R.id.text2);
        ratetext = findViewById(R.id.text3);
        sharetext = findViewById(R.id.text4);

        arrow1 =findViewById(R.id.arrow1);
        arrow2 =findViewById(R.id.arrow2);



        if (language == 1) {
            mToolbar.setVisibility(View.VISIBLE);
            mToolbar2.setVisibility(View.GONE);

            mToolbar.setTitle("عن التطبيق");

            TextView textView = mToolbar.findViewById(R.id.toolbartext);
            textView.setText("عن التطبيق");

            getActionBarTextView().setText("عن التطبيق");

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewAboutApplicationActivity.super.onBackPressed();
                }
            });

            getActionBarTextView().setVisibility(View.GONE);
        } else {
            mToolbar2.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.GONE);

            mToolbar2.setTitle("About Application");

            TextView textView = mToolbar2.findViewById(R.id.toolbartext);
            textView.setText("About Application");

            getActionBarTextView().setText("About Application");

            arrowen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewAboutApplicationActivity.super.onBackPressed();
                }
            });


            getActionBarTextView().setVisibility(View.GONE);

            aboutlayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            termslayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            ratelayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            sharelayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

            abouttext.setText("About us");
            termstext.setText("Terms and Conditions");
            ratetext.setText("Rate us");
            sharetext.setText("Share Application");

            arrow1.setRotation(270);
            arrow2.setRotation(270);
        }

        aboutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        termslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ratelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateApp();
            }
        });

        sharelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, "Share App Link");
                startActivity(Intent.createChooser(intent2, "Share via"));
            }
        });


    }

    public void rateApp()
    {
        if(language==1)
        {
            final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                    .icon(getDrawable(R.drawable.stars))
                    .threshold(3)
                    .title("كيف هى تجربتك معنا ؟")
                    .titleTextColor(R.color.black)
                    .positiveButtonText("ليس الأن")
                    .negativeButtonText("أبدا")
                    .positiveButtonTextColor(R.color.myPrimaryColor)
                    .negativeButtonTextColor(R.color.myPrimaryColor)
                    .formTitle("أرسل رأيك")
                    .formHint("أخبرنا كيف نقوم بتحسين خدماتنا")
                    .formSubmitText("حفظ")
                    .formCancelText("ألغاء")
                    .ratingBarColor(R.color.myPrimaryColor)
                    .playstoreUrl("")
                    .onThresholdCleared(new RatingDialog.Builder.RatingThresholdClearedListener() {
                        @Override
                        public void onThresholdCleared(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                            //do something
                            ratingDialog.dismiss();
                        }
                    })
                    .onThresholdFailed(new RatingDialog.Builder.RatingThresholdFailedListener() {
                        @Override
                        public void onThresholdFailed(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                            //do something
                            ratingDialog.dismiss();
                        }
                    })
                    .onRatingChanged(new RatingDialog.Builder.RatingDialogListener() {
                        @Override
                        public void onRatingSelected(float rating, boolean thresholdCleared) {

                        }
                    })
                    .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                        @Override
                        public void onFormSubmitted(String feedback) {

                        }
                    }).build();

            ratingDialog.show();
        }else
        {
            final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                    .icon(getDrawable(R.drawable.stars))
                    .threshold(3)
                    .title("How was your experience with us?")
                    .titleTextColor(R.color.black)
                    .positiveButtonText("Not Now")
                    .negativeButtonText("Never")
                    .positiveButtonTextColor(R.color.myPrimaryColor)
                    .negativeButtonTextColor(R.color.myPrimaryColor)
                    .formTitle("Submit Feedback")
                    .formHint("Tell us where we can improve")
                    .formSubmitText("Submit")
                    .formCancelText("Cancel")
                    .ratingBarColor(R.color.myPrimaryColor)
                    .playstoreUrl("")
                    .onThresholdCleared(new RatingDialog.Builder.RatingThresholdClearedListener() {
                        @Override
                        public void onThresholdCleared(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                            //do something
                            ratingDialog.dismiss();
                        }
                    })
                    .onThresholdFailed(new RatingDialog.Builder.RatingThresholdFailedListener() {
                        @Override
                        public void onThresholdFailed(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                            //do something
                            ratingDialog.dismiss();
                        }
                    })
                    .onRatingChanged(new RatingDialog.Builder.RatingDialogListener() {
                        @Override
                        public void onRatingSelected(float rating, boolean thresholdCleared) {

                        }
                    })
                    .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                        @Override
                        public void onFormSubmitted(String feedback) {

                        }
                    }).build();

            ratingDialog.show();
        }



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
