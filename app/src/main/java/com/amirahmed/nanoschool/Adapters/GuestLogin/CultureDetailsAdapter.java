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

public class CultureDetailsAdapter extends RecyclerView.Adapter<CultureDetailsAdapter.CultureDetailsViewHolder> {

    List<CultureItem> cultureItemList;

    TinyDB tinyDB;

    Context context;

    int language;

    public CultureDetailsAdapter(List<CultureItem> cultureItemList) {
        this.cultureItemList = cultureItemList;
    }

    @NonNull
    @Override
    public CultureDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_culture_details, parent, false);

        return new CultureDetailsAdapter.CultureDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultureDetailsViewHolder holder, int position) {

        holder.title.setText(cultureItemList.get(position).getTitle());
        holder.date.setText(cultureItemList.get(position).getDate());
        holder.details.setText(cultureItemList.get(position).getContent());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class CultureDetailsViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        TextView details;

        ImageView photo;

        LinearLayout titlelayout;

        public CultureDetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            details = itemView.findViewById(R.id.details);
            photo = itemView.findViewById(R.id.photo);

            titlelayout = itemView.findViewById(R.id.titlelayout);

            Glide.with(context).load(R.drawable.school).into(photo);

            if(language==1)
            {

            }else
            {
                titlelayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            }

        }
    }
}
