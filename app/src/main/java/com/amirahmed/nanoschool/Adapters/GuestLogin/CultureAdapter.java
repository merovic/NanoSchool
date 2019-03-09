package com.amirahmed.nanoschool.Adapters.GuestLogin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.GuestLogin.CultureDetailsActivity;
import com.amirahmed.nanoschool.Activities.GuestLogin.NewsDetailsActivity;
import com.amirahmed.nanoschool.Models.GuestLogin.CultureItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class CultureAdapter extends RecyclerView.Adapter<CultureAdapter.CultureViewHolder> {

    List<CultureItem> cultureItemList;

    Context context;

    TinyDB tinyDB;

    int language;

    public CultureAdapter(List<CultureItem> cultureItemList) {
        this.cultureItemList = cultureItemList;
    }

    @NonNull
    @Override
    public CultureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_culture, parent, false);

        return new CultureAdapter.CultureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultureViewHolder holder, int position) {

        holder.title.setText(cultureItemList.get(position).getTitle());
        holder.date.setText(cultureItemList.get(position).getDate());
        holder.details.setText(cultureItemList.get(position).getContent());
        holder.subtitle.setText(cultureItemList.get(position).getSubtitle());

        if(position==0)
        {
            Glide.with(context).load(R.drawable.school).into(holder.photo);
        }else if(position==1)
        {
            Glide.with(context).load(R.drawable.school2).into(holder.photo);
        }else if(position==2)
        {
            Glide.with(context).load(R.drawable.school3).into(holder.photo);
        }else if(position==3)
        {
            Glide.with(context).load(R.drawable.school4).into(holder.photo);
        }

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , CultureDetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cultureItemList.size();
    }

    public class CultureViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        TextView details;
        TextView subtitle;
        Button more;
        ImageView photo;

        LinearLayout titlelayout;
        CardView maincard;

        public CultureViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            details = itemView.findViewById(R.id.details);
            more = itemView.findViewById(R.id.more);
            subtitle = itemView.findViewById(R.id.subtitle);
            photo = itemView.findViewById(R.id.photo);

            titlelayout = itemView.findViewById(R.id.titlelayout);
            maincard = itemView.findViewById(R.id.maincard);

            if(language==1)
            {

            }else
            {
                titlelayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                maincard.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                more.setText("Read More");
            }
        }
    }
}
