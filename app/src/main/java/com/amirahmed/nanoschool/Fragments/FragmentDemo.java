package com.amirahmed.nanoschool.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amirahmed.nanoschool.R;

/**
 * Created by athbk on 8/25/17.
 */

public class FragmentDemo extends Fragment {

    private static final String ARG_ASS = "position";

    public static FragmentDemo newInstance(String ass) {
        Bundle args = new Bundle();
        FragmentDemo fragment = new FragmentDemo();
        args.putString(ARG_ASS,ass);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_demo, container, false);
        return v;
    }
}
