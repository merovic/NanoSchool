package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.PlanItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlaneViewHolder> {

    List<PlanItem> planItemList;

    TinyDB tinyDB;

    int language;

    Context context;

    public PlanAdapter(List<PlanItem> planItemList) {
        this.planItemList = planItemList;
    }

    @Override
    public PlaneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_en, parent, false);
            }


        PlaneViewHolder eh = new PlaneViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(final PlaneViewHolder holder, int position) {

        holder.subjectName.setText(planItemList.get(position).subjectName);
        holder.teacherName.setText(planItemList.get(position).teacherName);
        holder.title.setText(planItemList.get(position).title);
        holder.goals.setText(planItemList.get(position).goals);
        holder.homework.setText(planItemList.get(position).homework);

        holder.layoutmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.container.getVisibility()==View.VISIBLE)
                {
                    holder.container.setVisibility(View.GONE);
                    holder.arrow.setRotation(0);
                }else
                    {
                        holder.container.setVisibility(View.VISIBLE);
                        holder.arrow.setRotation(180);
                    }
            }
        });

    }

    @Override
    public int getItemCount() {
        return planItemList.size();
    }

    class PlaneViewHolder extends RecyclerView.ViewHolder {

        TextView subjectName,teacherName,title,goals,homework;
        ImageView arrow;
        LinearLayout container,layoutmain;

        PlaneViewHolder(View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subjectName);
            teacherName = itemView.findViewById(R.id.teacherName);
            title = itemView.findViewById(R.id.title);
            goals = itemView.findViewById(R.id.goals);
            homework = itemView.findViewById(R.id.hw);

            arrow = itemView.findViewById(R.id.arrow);

            container = itemView.findViewById(R.id.container);

            layoutmain = itemView.findViewById(R.id.layoutmain);
        }
    }
}
