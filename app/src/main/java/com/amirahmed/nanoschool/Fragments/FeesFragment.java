package com.amirahmed.nanoschool.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Adapters.GuestLogin.ComparisonAdapter;
import com.amirahmed.nanoschool.Adapters.GuestLogin.FeesAdapter;
import com.amirahmed.nanoschool.Models.GuestLogin.ComparisonItem;
import com.amirahmed.nanoschool.Models.GuestLogin.FeesItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class FeesFragment extends Fragment {

    private static final String ARG_ASS = "position";

    String titles;

    RecyclerView rv;

    List<FeesItem> feesItemList;

    int language;

    TinyDB tinyDB;

    TextView title;

    public static FeesFragment newInstance(String ass) {
        Bundle args = new Bundle();
        FeesFragment fragment = new FeesFragment();
        args.putString(ARG_ASS,ass);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        titles = getArguments().getString("position");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fees, container, false);

        tinyDB = new TinyDB(getContext());

        language = tinyDB.getInt("language");

        rv = view.findViewById(R.id.fees_rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        title = view.findViewById(R.id.title);
        title.setText(titles);

        /*try {

            JSONObject mainObj = new JSONObject("response"); // The Object of Levels Arrays
            JSONArray mainArray = mainObj.getJSONArray(titles); // a level array contains objects of sofof  (That is the main REQUIRED)
            JSONObject childObj = mainArray.getJSONObject(0);

        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        return view;
    }

    private void initializeData() {
        feesItemList = new ArrayList<>();

        if (language == 1) {

           feesItemList.add(new FeesItem("KG 2","12000 ريال","12000 ريال","800 ريال","340 ريال","340 ريال","المصروفات الدراسية غير شامبة الأنشطة الطلابية و الرحلات"));
            feesItemList.add(new FeesItem("KG 2","12000 ريال","12000 ريال","800 ريال","340 ريال","340 ريال","المصروفات الدراسية غير شامبة الأنشطة الطلابية و الرحلات"));
            feesItemList.add(new FeesItem("KG 2","12000 ريال","12000 ريال","800 ريال","340 ريال","340 ريال","المصروفات الدراسية غير شامبة الأنشطة الطلابية و الرحلات"));


        } else {

            feesItemList.add(new FeesItem("KG 2","12000 Ryal","12000 Ryal","800 Ryal","340 Ryal","340 Ryal","Fees doesn't include student activities or trips"));
            feesItemList.add(new FeesItem("KG 2","12000 Ryal","12000 Ryal","800 Ryal","340 Ryal","340 Ryal","Fees doesn't include student activities or trips"));
            feesItemList.add(new FeesItem("KG 2","12000 Ryal","12000 Ryal","800 Ryal","340 Ryal","340 Ryal","Fees doesn't include student activities or trips"));
        }
    }

    private void initializeAdapter() {

        FeesAdapter adapter = new FeesAdapter(feesItemList);
        rv.setAdapter(adapter);

    }
}
