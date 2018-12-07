package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.TermResultsActivity;
import com.amirahmed.nanoschool.Activities.TermTimesActivity;
import com.amirahmed.nanoschool.Models.TermItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class TermExamsAdapter extends RecyclerView.Adapter<TermExamsAdapter.TermExamsViewHolder> {

    private List<TermItem> termItemList;

    TinyDB tinyDB;

    int language;

    Context context;

    public TermExamsAdapter(List<TermItem> termItemList) {
        this.termItemList = termItemList;
    }

    @NonNull
    @Override
    public TermExamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_term, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_term_en, parent, false);
            }


        return new TermExamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TermExamsViewHolder holder, int position) {
        switch (termItemList.get(position).subject)
        {
            case 0:
                Glide.with(context).load(R.drawable.final1).into(holder.exampic);
                break;
            case 1:
                Glide.with(context).load(R.drawable.mid1).into(holder.exampic);
                break;
            case 2:
                Glide.with(context).load(R.drawable.final2).into(holder.exampic);
                break;
            case 3:
                Glide.with(context).load(R.drawable.mid2).into(holder.exampic);
                break;
        }
        holder.examname.setText(termItemList.get(position).title);

        if(position==0 || position==3)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#F2F2F0"));
        }else
            {
                holder.itemView.setBackgroundColor(Color.WHITE);
            }

    }

    @Override
    public int getItemCount() {
        return termItemList.size();
    }

    class TermExamsViewHolder extends RecyclerView.ViewHolder {

        ImageView exampic;
        TextView examname;
        Button buttonresults,buttontimes;

        TermExamsViewHolder(View itemView) {
            super(itemView);
            exampic = itemView.findViewById(R.id.exampic);
            examname = itemView.findViewById(R.id.examname);
            buttonresults = itemView.findViewById(R.id.buttonresult);
            buttontimes = itemView.findViewById(R.id.buttontimes);

            buttonresults.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, TermResultsActivity.class);
                    context.startActivity(myIntent);
                }
            });

            buttontimes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, TermTimesActivity.class);
                    context.startActivity(myIntent);
                }
            });

        }
    }
}
