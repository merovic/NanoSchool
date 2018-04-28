package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amirahmed.nanoschool.Activities.PicsSliderActivity;
import com.amirahmed.nanoschool.Models.PhotosItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class Photos2Adapter extends RecyclerView.Adapter<Photos2Adapter.Photos2ViewHolder>{

    private List<PhotosItem> photosItems;

    TinyDB tinyDB;

    int language;

    Context context;

    public Photos2Adapter(List<PhotosItem> photosItems) {
        this.photosItems = photosItems;
    }

    @Override
    public Photos2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photos2, parent, false);
        Photos2ViewHolder eh = new Photos2ViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(Photos2ViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , PicsSliderActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return photosItems.size();
    }

    public class Photos2ViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;

        public Photos2ViewHolder(View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
        }
    }
}
