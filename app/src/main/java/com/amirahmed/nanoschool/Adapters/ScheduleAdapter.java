package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.ScheduleItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private List<ScheduleItem> scheduleItems;
    public TinyDB tinydb;

    public int language;

    public Context context;

    public ScheduleAdapter(List<ScheduleItem> scheduleItems){
        this.scheduleItems = scheduleItems;
    }


    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ScheduleViewHolder cvh;

        context = parent.getContext();

        tinydb = new TinyDB(parent.getContext());
        language = tinydb.getInt("language");

        View v;

        if(language==1)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        }else
            {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_en, parent, false);
            }


        cvh = new ScheduleViewHolder(v);

        return cvh;
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        holder.className.setText(scheduleItems.get(position).className);
        holder.subjectName.setText(scheduleItems.get(position).subjectName);
        holder.classRoom.setText(scheduleItems.get(position).classRoom);
        holder.from.setText(scheduleItems.get(position).from);
        holder.to.setText(scheduleItems.get(position).to);


    }

    @Override
    public int getItemCount() {

        return scheduleItems.size();
    }


    class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView className;
        TextView subjectName;
        TextView classRoom;
        TextView from;
        TextView to;
        Context context;

        ScheduleViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            className = itemView.findViewById(R.id.className);
            subjectName = itemView.findViewById(R.id.subjectName);
            classRoom = itemView.findViewById(R.id.classRoom);
            from = itemView.findViewById(R.id.fromtext);
            to = itemView.findViewById(R.id.totext);

        }

    }


}
