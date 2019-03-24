package com.amirahmed.nanoschool.Adapters.GuestLogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.GuestLogin.SchoolsFeathersItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class SchoolFeathersAdapter extends RecyclerView.Adapter<SchoolFeathersAdapter.SchoolFeathersViewHolder> {

    List<SchoolsFeathersItem> schoolsFeathersItems;

    Context context;

    int language;

    TinyDB tinyDB;

    public SchoolFeathersAdapter(List<SchoolsFeathersItem> schoolsFeathersItems) {
        this.schoolsFeathersItems = schoolsFeathersItems;
    }

    @NonNull
    @Override
    public SchoolFeathersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_featchers, parent, false);

        return new SchoolFeathersAdapter.SchoolFeathersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolFeathersViewHolder holder, int position) {

        Glide.with(context).load(schoolsFeathersItems.get(position).getBackground()).into(holder.background);
        Glide.with(context).load(schoolsFeathersItems.get(position).getLogo()).into(holder.icon);

        holder.text.setText(schoolsFeathersItems.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return schoolsFeathersItems.size();
    }

    public class SchoolFeathersViewHolder extends RecyclerView.ViewHolder {

        ImageView background,icon;
        TextView text;

        public SchoolFeathersViewHolder(@NonNull View itemView) {
            super(itemView);

            background = itemView.findViewById(R.id.background);
            icon = itemView.findViewById(R.id.icon);
            text = itemView.findViewById(R.id.text);
        }
    }
}
