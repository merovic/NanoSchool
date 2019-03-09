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

import com.amirahmed.nanoschool.Activities.GuestLogin.NewsDetailsActivity;
import com.amirahmed.nanoschool.Activities.GuestLogin.SchoolDetailsActivity;
import com.amirahmed.nanoschool.Activities.GuestLogin.SocialMediaActivity;
import com.amirahmed.nanoschool.Models.GuestLogin.NewsItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<NewsItem> newsItemList;

    Context context;

    TinyDB tinyDB;

    int language;

    public NewsAdapter(List<NewsItem> newsItemList) {
        this.newsItemList = newsItemList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        holder.title.setText(newsItemList.get(position).getTitle());
        holder.date.setText(newsItemList.get(position).getDate());
        holder.details.setText(newsItemList.get(position).getContent());

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
                Intent intent = new Intent(context , NewsDetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        TextView details;
        Button more;
        ImageView photo;

        LinearLayout titlelayout;
        CardView maincard;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            details = itemView.findViewById(R.id.details);
            more = itemView.findViewById(R.id.more);
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
