package com.amirahmed.nanoschool.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amirahmed.nanoschool.Adapters.GuestLogin.SchoolsListAdapter;
import com.amirahmed.nanoschool.Models.SchoolsListItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.daimajia.slider.library.SliderLayout;

import java.util.List;

public class AllSchoolsFragment extends Fragment {

    View view;

    private SliderLayout mDemoSlider;

    TinyDB tinyDB;

    int language;

    private List<SchoolsListItem> schoolsListItems;
    private RecyclerView rv2;

    SchoolsListAdapter adapter;

    ImageView culture,news;

    ImageView filter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_allschools, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
