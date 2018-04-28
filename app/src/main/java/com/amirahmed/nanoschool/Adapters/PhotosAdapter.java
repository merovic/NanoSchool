package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.ImagesActivity;
import com.amirahmed.nanoschool.Models.PhotosItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>{

    private List<PhotosItem> photosItems;

    TinyDB tinyDB;

    int language;

    Context context;

    public PhotosAdapter(List<PhotosItem> photosItems) {
        this.photosItems = photosItems;
    }

    @Override
    public PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photos, parent, false);
        PhotosViewHolder eh = new PhotosViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(PhotosViewHolder holder, int position) {

        holder.title.setText(photosItems.get(position).getTitle());
        holder.date.setText(photosItems.get(position).getDate());
        holder.number.setText(photosItems.get(position).getNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , ImagesActivity.class);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return photosItems.size();
    }

    class PhotosViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView title,date,number;

        PhotosViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            number = itemView.findViewById(R.id.number);
        }
    }
}
