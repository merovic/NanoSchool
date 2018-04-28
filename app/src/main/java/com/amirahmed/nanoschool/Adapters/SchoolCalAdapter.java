package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.SchoolEvent;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;


public class SchoolCalAdapter extends RecyclerView.Adapter<SchoolCalAdapter.SchoolCalViewHolder> {

    private List<SchoolEvent> events;

    public SchoolCalAdapter(List<SchoolEvent> events) {
        this.events = events;
    }

    TinyDB tinyDB;

    int language;

    Context context;

    @Override
    public SchoolCalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schoolcal, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schoolcal_en, parent, false);
            }

        SchoolCalViewHolder vh;

        vh = new SchoolCalViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(SchoolCalViewHolder holder, int position) {
        holder.eventname.setText(events.get(position).getEventName());
        holder.dayname.setText(events.get(position).getDayName());
        holder.daymonth.setText(events.get(position).getDayMonth());
        holder.datehijry.setText(events.get(position).getDateHijry());

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class SchoolCalViewHolder extends RecyclerView.ViewHolder {

        TextView eventname,dayname,daymonth,datehijry;

        SchoolCalViewHolder(View itemView) {
            super(itemView);

            eventname = itemView.findViewById(R.id.name);
            dayname = itemView.findViewById(R.id.day);
            daymonth = itemView.findViewById(R.id.month);
            datehijry = itemView.findViewById(R.id.datehijry);
        }
    }
}
