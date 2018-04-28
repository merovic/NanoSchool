package com.amirahmed.nanoschool.Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirahmed.nanoschool.Adapters.TeachersListAdapter;
import com.amirahmed.nanoschool.Models.TeachersListItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class TeachersListFragment extends DialogFragment {

    RecyclerView rv;
    TeachersListAdapter adapter;
    List<TeachersListItem> teachersListItemList;

    TinyDB tinyDB;

    int language;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_teachers,container);

        rv= rootView.findViewById(R.id.mRecyerID);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        teachersListItemList = new ArrayList<>();

        tinyDB = new TinyDB(getActivity());

        language = tinyDB.getInt("language");

        if(language==1)
        {
            teachersListItemList.add(new TeachersListItem("احمد متولى تهامى المنصورى","مدرس العلوم للمرحلة الأبتدائية"));
            teachersListItemList.add(new TeachersListItem("احمد متولى تهامى المنصورى","مدرس العلوم للمرحلة الأبتدائية"));
            teachersListItemList.add(new TeachersListItem("احمد متولى تهامى المنصورى","مدرس العلوم للمرحلة الأبتدائية"));
            teachersListItemList.add(new TeachersListItem("احمد متولى تهامى المنصورى","مدرس العلوم للمرحلة الأبتدائية"));
            teachersListItemList.add(new TeachersListItem("احمد متولى تهامى المنصورى","مدرس العلوم للمرحلة الأبتدائية"));
            teachersListItemList.add(new TeachersListItem("احمد متولى تهامى المنصورى","مدرس العلوم للمرحلة الأبتدائية"));
        }else
            {
                teachersListItemList.add(new TeachersListItem("Ahmed Metwally Tohamy","Science Teacher Primary Stage"));
                teachersListItemList.add(new TeachersListItem("Ahmed Metwally Tohamy","Science Teacher Primary Stage"));
                teachersListItemList.add(new TeachersListItem("Ahmed Metwally Tohamy","Science Teacher Primary Stage"));
                teachersListItemList.add(new TeachersListItem("Ahmed Metwally Tohamy","Science Teacher Primary Stage"));
                teachersListItemList.add(new TeachersListItem("Ahmed Metwally Tohamy","Science Teacher Primary Stage"));
                teachersListItemList.add(new TeachersListItem("Ahmed Metwally Tohamy","Science Teacher Primary Stage"));
            }




        adapter=new TeachersListAdapter(this.getActivity(),teachersListItemList);
        rv.setAdapter(adapter);

        this.getDialog().setTitle("TV Shows");


        return rootView;
    }
}
