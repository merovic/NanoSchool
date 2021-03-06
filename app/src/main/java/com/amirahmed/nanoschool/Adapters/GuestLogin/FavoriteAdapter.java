package com.amirahmed.nanoschool.Adapters.GuestLogin;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.GuestLogin.SchoolDetailsActivity;
import com.amirahmed.nanoschool.Models.SchoolsListItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.like.LikeButton;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private List<SchoolsListItem> schoolsListItems;

    private Context context;

    private int language;

    public FavoriteAdapter(List<SchoolsListItem> schoolsListItems) {
        this.schoolsListItems = schoolsListItems;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        TinyDB tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;


        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schoolslist, parent, false);


        return new FavoriteAdapter.FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteViewHolder holder, int position) {

        holder.name.setText(schoolsListItems.get(position).getSchoolName());
        holder.distance.setText(schoolsListItems.get(position).getSchoolDistance());
        holder.type.setText(schoolsListItems.get(position).getSchoolType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context , SchoolDetailsActivity.class);
                context.startActivity(intent);

            }
        });

        if((position%2)==0)
        {
            // even
            holder.moon.setVisibility(View.GONE);
            holder.female.setVisibility(View.GONE);
            holder.certificate.setVisibility(View.GONE);
        }else
        {
            // odd
            holder.moon.setVisibility(View.VISIBLE);
            holder.female.setVisibility(View.VISIBLE);
            holder.certificate.setVisibility(View.VISIBLE);
        }


        holder.compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.compare.setBackgroundColor(Color.RED);
            }
        });


        if(position==0 || position==3 || position==6 || position==9 || position==12 || position==15)
        {
            holder.image.setImageResource(R.drawable.trail1);
        }else if(position==1 || position==4 || position==7 || position==10 || position==13 || position==16)
        {
            holder.image.setImageResource(R.drawable.trail2);
        }else if(position==2 || position==5 || position==8 || position==11 || position==14)
        {
            holder.image.setImageResource(R.drawable.trail3);
        }
    }

    @Override
    public int getItemCount() {
        return schoolsListItems.size();
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder {

        TextView name,distance,type;
        ImageView image,moon,female,certificate;
        LinearLayout mainlayout;
        Button compare;
        LikeButton fav;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.logo);
            name = itemView.findViewById(R.id.name);
            distance = itemView.findViewById(R.id.distance);
            type = itemView.findViewById(R.id.leveltext);
            mainlayout = itemView.findViewById(R.id.mainlayout);
            compare = itemView.findViewById(R.id.visitorbutton);
            moon = itemView.findViewById(R.id.moon);
            female = itemView.findViewById(R.id.female);
            certificate = itemView.findViewById(R.id.certificate);
            fav = itemView.findViewById(R.id.fav);

            if(language!=1)
            {
                mainlayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                compare.setText("Compare +");
                compare.setTextSize(8);

            }

            fav.setLiked(true);

            compare.setVisibility(View.GONE);


        }
    }
}
