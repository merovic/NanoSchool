package com.amirahmed.nanoschool.Adapters.GuestLogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.GuestLogin.ComparisonItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class ComparisonAdapter extends RecyclerView.Adapter<ComparisonAdapter.ComparisonViewHolder> {

    List<ComparisonItem> comparisonItemList;

    Context context;

    TinyDB tinyDB;

    int language;

    public ComparisonAdapter(List<ComparisonItem> comparisonItemList) {
        this.comparisonItemList = comparisonItemList;
    }

    @NonNull
    @Override
    public ComparisonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_compariosn, parent, false);

        return new ComparisonAdapter.ComparisonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComparisonViewHolder holder, int position) {

        holder.point1.setText(comparisonItemList.get(position).getPoint1());
        holder.pointCompariosn.setText(comparisonItemList.get(position).getPointComparison());
        holder.point2.setText(comparisonItemList.get(position).getPoint2());

        if(position==0)
        {
            Glide.with(context).load(R.drawable.distancecomp).into(holder.icon);
        }else if(position==1)
        {
            Glide.with(context).load(R.drawable.capcomp).into(holder.icon);
        }else if(position==2)
        {
            Glide.with(context).load(R.drawable.boysgirlscomp).into(holder.icon);
        }
        else if(position==3)
        {
            Glide.with(context).load(R.drawable.districtcomp).into(holder.icon);
        }
        else if(position==4)
        {
            Glide.with(context).load(R.drawable.timecomp).into(holder.icon);
        }else if(position==5)
        {
            Glide.with(context).load(R.drawable.educationcomp).into(holder.icon);
        }else if(position==6)
        {
            Glide.with(context).load(R.drawable.certifiedcom).into(holder.icon);
        }else if(position==7)
        {
            Glide.with(context).load(R.drawable.studentscomp).into(holder.icon);
        }else if(position==8)
        {
            Glide.with(context).load(R.drawable.pitchescomp).into(holder.icon);
        }else if(position==9)
        {
            Glide.with(context).load(R.drawable.poolcomp).into(holder.icon);
        }else if(position==10)
        {
            Glide.with(context).load(R.drawable.educationcomp).into(holder.icon);
        }else if(position==11)
        {
            Glide.with(context).load(R.drawable.onlineappcom).into(holder.icon);
        }else if(position==12)
        {
            Glide.with(context).load(R.drawable.discountcom).into(holder.icon);
        }else if(position==13)
        {
            Glide.with(context).load(R.drawable.groupscom).into(holder.icon);
        }else
        {
            Glide.with(context).load(R.drawable.moneycomp).into(holder.icon);
        }


    }

    @Override
    public int getItemCount() {
        return comparisonItemList.size();
    }

    public class ComparisonViewHolder extends RecyclerView.ViewHolder {

        TextView point1;
        TextView pointCompariosn;
        TextView point2;
        ImageView icon;

        LinearLayout layout;

        public ComparisonViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.iconcompare);
            point1 = itemView.findViewById(R.id.point1);
            pointCompariosn = itemView.findViewById(R.id.pointcomparison);
            point2 = itemView.findViewById(R.id.point2);
            layout = itemView.findViewById(R.id.layout);

            if(language==1)
            {

            }else
                {
                    layout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                }
        }
    }
}
