package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.EvaluationInteractionActivity;
import com.amirahmed.nanoschool.Models.ScoresSelectItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.CircleDisplay;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class ScoresSelectAdapter extends RecyclerView.Adapter<ScoresSelectAdapter.ScoresSelectViewHolder> {

    private List<ScoresSelectItem> scoresSelectItems;
    TinyDB tinydb;
    public int language = 1;

    public ScoresSelectAdapter(List<ScoresSelectItem> scoresSelectItems){

        this.scoresSelectItems = scoresSelectItems;
    }

    @Override
    public ScoresSelectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ScoresSelectViewHolder eh;

        tinydb = new TinyDB(parent.getContext());
        language = tinydb.getInt("language");

        if(language==1)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scores_select, parent, false);
            eh = new ScoresSelectViewHolder(view);
        }else
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scores_select_en, parent, false);
            eh = new ScoresSelectViewHolder(view);
        }


        return eh;
    }

    @Override
    public void onBindViewHolder(ScoresSelectViewHolder holder, int position) {

        holder.teachername.setText(scoresSelectItems.get(position).name);
        holder.subjectname.setText(scoresSelectItems.get(position).subjectname);

        int result = Integer.parseInt(scoresSelectItems.get(position).percentage);
        int result2 = (result*100)/20;
        String result3 = String.valueOf(result2);
        holder.percentage.showValue(Float.parseFloat(result3), 100f, true);

        if(result2<50)
        {
            holder.percentage.setColor(Color.parseColor("#CE4543"));
        }else if(50<result2 && result2<70)
        {
            holder.percentage.setColor(Color.parseColor("#FEA000"));
        }else
        {
            holder.percentage.setColor(Color.parseColor("#55D450"));
        }


    }

    @Override
    public int getItemCount() {
        return scoresSelectItems.size();
    }

    class ScoresSelectViewHolder extends RecyclerView.ViewHolder {

        TextView teachername;
        TextView subjectname;
        CircleDisplay percentage;
        Context context;

        ScoresSelectViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            teachername = itemView.findViewById(R.id.teacherName);
            subjectname = itemView.findViewById(R.id.subjectName);
            percentage = itemView.findViewById(R.id.circleDisplay);


            tinydb = new TinyDB(context);
            //language = tinydb.getInt("language");


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context , EvaluationInteractionActivity.class );
                    context.startActivity(intent);
                }
            });

            percentage.setAnimDuration(3000);
            percentage.setValueWidthPercent(30f);
            percentage.setTextSize(10f);
            percentage.setColor(Color.parseColor("#5FB336"));
            percentage.setDrawText(true);
            percentage.setDrawInnerCircle(true);
            percentage.setFormatDigits(0);
            percentage.setTouchEnabled(false);
            percentage.setUnit("%");
            percentage.setStepSize(0.5f);

        }
    }

}
