package com.amirahmed.nanoschool.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirahmed.nanoschool.Adapters.TermExamsAdapter;
import com.amirahmed.nanoschool.Models.TermItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class TermFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<TermItem> termItemList;

    TermExamsAdapter adapter;

    TinyDB tinyDB;

    int language;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_term, container, false);
        mRecyclerView = view.findViewById(R.id.rv2e);

        mRecyclerView.setHasFixedSize(true);

        GridLayoutManager mGridlayoutManager = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(mGridlayoutManager);

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

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

        termItemList = new ArrayList<>();

        if(language==1)
        {
            termItemList.add(new TermItem("اختبار الفصل الدراسى الاول",0));
            termItemList.add(new TermItem("اختبار الميد تيرم ١",1));
            termItemList.add(new TermItem("اختبار الفصل الدراسى الثانى",2));
            termItemList.add(new TermItem("اختبار الميد تيرم ٢",3));
        }else
            {
                termItemList.add(new TermItem("First Semester Exams",0));
                termItemList.add(new TermItem("Midterm 1 Exams",1));
                termItemList.add(new TermItem("Second Semester Exams",2));
                termItemList.add(new TermItem("Midterm 2 Exams",3));
            }


    }

    private void initializeAdapter() {

        adapter = new TermExamsAdapter(termItemList);
        mRecyclerView.setAdapter(adapter);
    }

}
