package com.amirahmed.nanoschool.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.MonthExamsAdapter;
import com.amirahmed.nanoschool.Models.MonthItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

import static com.amirahmed.nanoschool.R.id.rv2;

public class MonthFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<MonthItem> monthItems;

    MonthExamsAdapter adapter;

    TinyDB tinyDB;

    int language;

    TextView title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_month, container, false);
        mRecyclerView = view.findViewById(rv2);

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(llm);

        title = view.findViewById(R.id.title);

        if(language==1)
        {
            title.setText("اختبارات شهر مارس للعام الدراسى ٢٠١٨/٢٠١٩");
        }else
            {
                title.setText("March Exams for Educational Year 2018/2019");
            }

        initializeData();
        initializeAdapter();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {

        monthItems = new ArrayList<>();
        if(language==1)
        {
            monthItems.add(new MonthItem("٢٣ مارس","الاحد","اللغة العربية","عبد الرحمن مهران","٢٠","١٠"));
            monthItems.add(new MonthItem("٢٣ مارس","الاحد","اللغة العربية","عبد الرحمن مهران","٢٠","١٠"));
            monthItems.add(new MonthItem("٢٣ مارس","الاحد","اللغة العربية","عبد الرحمن مهران","٢٠","١٠"));
            monthItems.add(new MonthItem("٢٣ مارس","الاحد","اللغة العربية","عبد الرحمن مهران","٢٠","١٠"));
            monthItems.add(new MonthItem("٢٣ مارس","الاحد","اللغة العربية","عبد الرحمن مهران","٢٠","١٠"));
            monthItems.add(new MonthItem("٢٣ مارس","الاحد","اللغة العربية","عبد الرحمن مهران","٢٠","١٠"));
            monthItems.add(new MonthItem("٢٣ مارس","الاحد","اللغة العربية","عبد الرحمن مهران","٢٠","١٠"));
        }else
            {
                monthItems.add(new MonthItem("23 March","Sunday","Arabic Language","Abdelrahman Mahran","20","10"));
                monthItems.add(new MonthItem("23 March","Sunday","Arabic Language","Abdelrahman Mahran","20","10"));
                monthItems.add(new MonthItem("23 March","Sunday","Arabic Language","Abdelrahman Mahran","20","10"));
                monthItems.add(new MonthItem("23 March","Sunday","Arabic Language","Abdelrahman Mahran","20","10"));
                monthItems.add(new MonthItem("23 March","Sunday","Arabic Language","Abdelrahman Mahran","20","10"));
                monthItems.add(new MonthItem("23 March","Sunday","Arabic Language","Abdelrahman Mahran","20","10"));
                monthItems.add(new MonthItem("23 March","Sunday","Arabic Language","Abdelrahman Mahran","20","10"));
            }

    }

    private void initializeAdapter() {

        adapter = new MonthExamsAdapter(monthItems);
        mRecyclerView.setAdapter(adapter);
    }

}
