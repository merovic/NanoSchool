package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.TermTimesItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class TermTimesAdapter extends RecyclerView.Adapter<TermTimesAdapter.TermTimesViewHolder> {

    List<TermTimesItem> termTimesItemList;

    TinyDB tinyDB;

    int language;

    Context context;

    public TermTimesAdapter(List<TermTimesItem> termTimesItemList) {
        this.termTimesItemList = termTimesItemList;
    }

    @Override
    public TermTimesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_times, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_times_en, parent, false);
            }


        TermTimesViewHolder eh = new TermTimesViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(TermTimesViewHolder holder, int position) {

        holder.subjectName.setText(termTimesItemList.get(position).subjectName);
        holder.date.setText(termTimesItemList.get(position).date);
        holder.time.setText(termTimesItemList.get(position).time);

    }

    @Override
    public int getItemCount() {
        return termTimesItemList.size();
    }

    public class TermTimesViewHolder extends RecyclerView.ViewHolder {

        TextView subjectName;
        TextView date;
        TextView time;

        public TermTimesViewHolder(View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subjectname);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }
}
