package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.TeachersListItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.AddButtonClick;
import com.amirahmed.nanoschool.Utils.TinyDB;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class TeachersListAdapter extends RecyclerView.Adapter<TeachersListAdapter.TeachersListViewHolder>{

    Context c;
    List<TeachersListItem> teachersListItemList;

    TinyDB tinyDB;

    int language;

    public TeachersListAdapter(Context c, List<TeachersListItem> teachersListItemList) {
        this.c = c;
        this.teachersListItemList = teachersListItemList;
    }

    @Override
    public TeachersListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        c = parent.getContext();
        tinyDB = new TinyDB(c);

        language = tinyDB.getInt("language");

        View v;

        if(language==1)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacherslist,parent,false);
        }else
            {
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacherslist_en,parent,false);
            }


        TeachersListViewHolder holder = new TeachersListViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeachersListViewHolder holder, final int position) {

        holder.nameTxt.setText(teachersListItemList.get(position).getTeacherName());
        holder.nameTxt2.setText(teachersListItemList.get(position).getTeacherJob());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().post(new AddButtonClick(teachersListItemList.get(position).getTeacherName()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return teachersListItemList.size();
    }

    class TeachersListViewHolder extends RecyclerView.ViewHolder {

        TextView nameTxt,nameTxt2;

        TeachersListViewHolder(View itemView) {
            super(itemView);
            nameTxt= itemView.findViewById(R.id.nameTxt);
            nameTxt2= itemView.findViewById(R.id.nameTxt2);
        }
    }
}
