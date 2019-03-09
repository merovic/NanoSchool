package com.amirahmed.nanoschool.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.GuestLogin.DiscountRequestActivity;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.FilterSubmission;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import org.florescu.android.rangeseekbar.RangeSeekBar;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class FilterFragment extends DialogFragment {

    SeekBar seekBar1;
    RangeSeekBar seekBar2;
    TextView max1,max2,min2,boy,girl,multi;

    ImageView boypic,girlpic,multipic;

    LinearLayout mainlayout,typelayout,courselayout,sub1,sub2,multilayout,boyslayout,girlslayout;

    Button sendbutton;

    Spinner typesspinner,coursesspinner;

    List<String> types = new ArrayList<>();
    List<String> courses = new ArrayList<>();

    TinyDB tinyDB;

    int language;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_filter,container);

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

        boy = rootView.findViewById(R.id.boys);
        girl = rootView.findViewById(R.id.girls);
        multi = rootView.findViewById(R.id.multi);

        boypic = rootView.findViewById(R.id.boyspic);
        girlpic = rootView.findViewById(R.id.girlspic);
        multipic = rootView.findViewById(R.id.multipic);

        mainlayout = rootView.findViewById(R.id.mainlayout);
        typelayout = rootView.findViewById(R.id.typelayout);
        courselayout = rootView.findViewById(R.id.courselayout);
        sub1 = rootView.findViewById(R.id.sub1);
        sub2 = rootView.findViewById(R.id.sub2);
        multilayout = rootView.findViewById(R.id.multilayout);
        boyslayout = rootView.findViewById(R.id.boyslayout);
        girlslayout = rootView.findViewById(R.id.girlslayout);

        seekBar1 = rootView.findViewById(R.id.distanceseeker);
        seekBar2 = rootView.findViewById(R.id.feesseeker);

        max1 = rootView.findViewById(R.id.max1);
        max2 = rootView.findViewById(R.id.max2);
        min2 = rootView.findViewById(R.id.min2);

        sendbutton = rootView.findViewById(R.id.sendbutton);

        if(language==1)
        {

            types.add("عالمية");
            types.add("دولية");
            types.add("اهلية");
            types.add("نموزجية");
            types.add("حضانة");
            types.add("خاصة");

            courses.add("امريكى");
            courses.add("بريطانى");
            courses.add("فرنسى");
            courses.add("لافتيفى");
            courses.add("مسار مصرى");
            courses.add("برنامج دولى");

        }else
            {
                seekBar1.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                seekBar2.setRotation(180);

                boy.setText("Boys");
                girl.setText("Girls");
                multi.setText("Multiple");

                max1.setText("0 km");

                mainlayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                typelayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                courselayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                sub1.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                sub2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

                sendbutton.setText("Apply");

                types.add("Global");
                types.add("International");
                types.add("National");
                types.add("Typical");
                types.add("Incubation");
                types.add("Special");

                courses.add("American");
                courses.add("British");
                courses.add("French");
                courses.add("Latvian");
                courses.add("Egyptian");
                courses.add("National Program");
            }

        typesspinner = rootView.findViewById(R.id.type);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, types);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typesspinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        coursesspinner = rootView.findViewById(R.id.course);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, courses);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coursesspinner.setAdapter(adapter2);

        adapter2.notifyDataSetChanged();


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(language==1)
                {
                    max1.setText(String.valueOf(progress) + " كم");

                }else
                {
                    max1.setText(String.valueOf(progress) + " km");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBar2.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {

                Number min_value = bar.getSelectedMinValue();
                Number max_value = bar.getSelectedMaxValue();

                int min = (int)min_value;
                int max = (int)max_value;

                min2.setText(String.valueOf(min));
                max2.setText(String.valueOf(max));

            }
        });

        boyslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(getActivity()).load(R.drawable.boyblue).into(boypic);
                boy.setTextColor(getResources().getColor(R.color.myPrimaryDarkColor));

                Glide.with(getActivity()).load(R.drawable.girl).into(girlpic);
                girl.setTextColor(getResources().getColor(R.color.grey_400));

                Glide.with(getActivity()).load(R.drawable.boygirl).into(multipic);
                multi.setTextColor(getResources().getColor(R.color.grey_400));
            }
        });

        girlslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(getActivity()).load(R.drawable.boy).into(boypic);
                boy.setTextColor(getResources().getColor(R.color.grey_400));

                Glide.with(getActivity()).load(R.drawable.girlblue).into(girlpic);
                girl.setTextColor(getResources().getColor(R.color.myPrimaryDarkColor));

                Glide.with(getActivity()).load(R.drawable.boygirl).into(multipic);
                multi.setTextColor(getResources().getColor(R.color.grey_400));
            }
        });

        multilayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(getActivity()).load(R.drawable.boy).into(boypic);
                boy.setTextColor(getResources().getColor(R.color.grey_400));

                Glide.with(getActivity()).load(R.drawable.girl).into(girlpic);
                girl.setTextColor(getResources().getColor(R.color.grey_400));

                Glide.with(getActivity()).load(R.drawable.boygirlblue).into(multipic);
                multi.setTextColor(getResources().getColor(R.color.myPrimaryDarkColor));
            }
        });

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typesspinner.performClick();
            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursesspinner.performClick();
            }
        });


        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // EventBus.getDefault().post(new FilterSubmission(text.getText().toString()));
                dismiss();
            }
        });


        return rootView;


    }
}
