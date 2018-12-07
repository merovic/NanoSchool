package com.amirahmed.nanoschool.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.AboutSchoolActivity;
import com.amirahmed.nanoschool.Models.SchoolsListItem;
import com.amirahmed.nanoschool.R;

import java.util.List;

public class SchoolsListAdapter extends RecyclerView.Adapter<SchoolsListAdapter.SchoolsListViewHolder> {

    List<SchoolsListItem> schoolsListItems;

    Context context;

    public SchoolsListAdapter(List<SchoolsListItem> schoolsListItems) {
        this.schoolsListItems = schoolsListItems;
    }

    @NonNull
    @Override
    public SchoolsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

     //   tinyDB = new TinyDB(context);

       // language = tinyDB.getInt("language");

        View view;


        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schoolslist, parent, false);


        SchoolsListViewHolder eh = new SchoolsListViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolsListViewHolder holder, int position) {

        holder.name.setText(schoolsListItems.get(position).getSchoolName());
        holder.distance.setText(schoolsListItems.get(position).getSchoolDistance());
        holder.type.setText(schoolsListItems.get(position).getSchoolType());
        holder.status.setText(schoolsListItems.get(position).getSchoolStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , AboutSchoolActivity.class);
                context.startActivity(intent);
            }
        });

        if(position==0 || position==3 || position==6 || position==9 || position==12 || position==15)
        {
         holder.image.setImageResource(R.drawable.schoollogo);
        }else if(position==1 || position==4 || position==7 || position==10 || position==13 || position==16)
        {
            holder.image.setImageResource(R.drawable.schoollogo4);
        }else if(position==2 || position==5 || position==8 || position==11 || position==14)
        {
            holder.image.setImageResource(R.drawable.schoollogo5);
        }

    }

    @Override
    public int getItemCount() {
        return schoolsListItems.size();
    }

    public class SchoolsListViewHolder extends RecyclerView.ViewHolder {

        TextView name,distance,status,type;
        ImageView image;

        public SchoolsListViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.logo);
            name = itemView.findViewById(R.id.name);
            distance = itemView.findViewById(R.id.distance);
            type = itemView.findViewById(R.id.type);
            status = itemView.findViewById(R.id.status);

        }
    }
}
