package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.TermResultsItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.CircleDisplay;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class TermResultsAdapter extends RecyclerView.Adapter<TermResultsAdapter.TermResultsViewHolder> {

    List<TermResultsItem> termResultsItemList;

    TinyDB tinyDB;

    int language;

    Context context;

    public TermResultsAdapter(List<TermResultsItem> termResultsItemList) {
        this.termResultsItemList = termResultsItemList;
    }

    @Override
    public TermResultsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_results, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_results_en, parent, false);
            }


        TermResultsViewHolder eh = new TermResultsViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(TermResultsViewHolder holder, int position) {

        holder.subjectName.setText(termResultsItemList.get(position).subject);

        holder.score.setText(termResultsItemList.get(position).result);

        int result = Integer.parseInt(termResultsItemList.get(position).result);
        int result2 = (result*100)/50;
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
        return termResultsItemList.size();
    }

    public class TermResultsViewHolder extends RecyclerView.ViewHolder {

        TextView subjectName,score;
        CircleDisplay percentage;

        public TermResultsViewHolder(View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subjectname);
            score = itemView.findViewById(R.id.score);
            percentage = itemView.findViewById(R.id.cd);

            percentage.setAnimDuration(3000);
            percentage.setValueWidthPercent(30f);
            percentage.setTextSize(10f);
            //percentage.setColor(Color.parseColor("#9A173E"));
            percentage.setDrawText(true);
            percentage.setDrawInnerCircle(true);
            percentage.setFormatDigits(0);
            percentage.setTouchEnabled(false);
            percentage.setUnit("%");
            percentage.setStepSize(0.5f);

        }
    }
}
