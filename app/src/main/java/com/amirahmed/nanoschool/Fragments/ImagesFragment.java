package com.amirahmed.nanoschool.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirahmed.nanoschool.Adapters.PhotosAdapter;
import com.amirahmed.nanoschool.Models.PhotosItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class ImagesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<PhotosItem> photosItems;

    PhotosAdapter adapter;

    TinyDB tinyDB;

    int language;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        mRecyclerView = view.findViewById(R.id.rv2e);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(llm);

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

        photosItems = new ArrayList<>();

        if(language==1)
        {
            photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
            photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
            photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
            photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
            photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
            photosItems.add(new PhotosItem("المشاركة فى اليوم العالمى للطفل","١٤ اكتوبر","٤٧ صورة"));
        }else
            {
                photosItems.add(new PhotosItem("Participation on the Child International Day","14 October","47 Pic"));
                photosItems.add(new PhotosItem("Participation on the Child International Day","14 October","47 Pic"));
                photosItems.add(new PhotosItem("Participation on the Child International Day","14 October","47 Pic"));
                photosItems.add(new PhotosItem("Participation on the Child International Day","14 October","47 Pic"));
                photosItems.add(new PhotosItem("Participation on the Child International Day","14 October","47 Pic"));
                photosItems.add(new PhotosItem("Participation on the Child International Day","14 October","47 Pic"));
            }




    }

    private void initializeAdapter() {

        adapter = new PhotosAdapter(photosItems);
        mRecyclerView.setAdapter(adapter);
    }


}
