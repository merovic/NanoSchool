package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.ExamMonthDetailsActivity;
import com.amirahmed.nanoschool.Models.MonthItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class MonthExamsAdapter extends RecyclerView.Adapter<MonthExamsAdapter.MonthExamsViewHolder>{

    List<MonthItem> monthItemList;

    TinyDB tinyDB;

    int language;

    Context context;

    public MonthExamsAdapter(List<MonthItem> monthItemList) {
        this.monthItemList = monthItemList;
    }

    @Override
    public MonthExamsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_month, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_month_en, parent, false);
            }


        MonthExamsViewHolder eh = new MonthExamsViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(@NonNull MonthExamsViewHolder holder, int position) {
        holder.date1.setText(monthItemList.get(position).examDate1);
        holder.date2.setText(monthItemList.get(position).examDate2);
        holder.subjectName.setText(monthItemList.get(position).exam);
        holder.teacherName.setText(monthItemList.get(position).teacherName);
        holder.fullmark.setText(monthItemList.get(position).finalScore);
        holder.passmark.setText(monthItemList.get(position).passScore);

        if(position==2)
        {
            holder.box.setBackgroundColor(Color.parseColor("#ff3333"));
        }

    }

    @Override
    public int getItemCount() {
        return monthItemList.size();
    }

    public class MonthExamsViewHolder extends RecyclerView.ViewHolder {

        TextView date1,date2,subjectName,teacherName,fullmark,passmark;
        LinearLayout box;

        public MonthExamsViewHolder(View itemView) {
            super(itemView);
            date1 = itemView.findViewById(R.id.date1);
            date2 = itemView.findViewById(R.id.date2);
            subjectName = itemView.findViewById(R.id.subjectName);
            teacherName = itemView.findViewById(R.id.teacherName);
            fullmark = itemView.findViewById(R.id.fullmark);
            passmark = itemView.findViewById(R.id.passmark);
            box = itemView.findViewById(R.id.subject);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent myIntent = new Intent(context, ExamMonthDetailsActivity.class);
                    context.startActivity(myIntent);

                }
            });

        }
    }
}
