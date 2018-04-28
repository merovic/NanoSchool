package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.RequestsFollowItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class RequestsFollowAdapter extends RecyclerView.Adapter<RequestsFollowAdapter.RequestsFollowViewHolder>{

    List<RequestsFollowItem> requestsFollowItems;


    TinyDB tinyDB;

    int language;

    Context context;

    public RequestsFollowAdapter(List<RequestsFollowItem> requestsFollowItems) {
        this.requestsFollowItems = requestsFollowItems;
    }

    @Override
    public RequestsFollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_requestsfollow, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_requestsfollow_en, parent, false);
            }


        RequestsFollowViewHolder eh = new RequestsFollowViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(RequestsFollowViewHolder holder, int position) {
        holder.requestno.setText(requestsFollowItems.get(position).getRequestNumber());
        holder.requestname.setText(requestsFollowItems.get(position).getRequestName());
        holder.requeststatus.setText(requestsFollowItems.get(position).getRequestStatus());
        if(requestsFollowItems.get(position).getRequestStatusPic()==0)
        {
            Glide.with(context).load(R.drawable.sample).into(holder.requeststatuspic);

        }else if(requestsFollowItems.get(position).getRequestStatusPic()==1)
        {
            Glide.with(context).load(R.drawable.sample).into(holder.requeststatuspic);

        }else if(requestsFollowItems.get(position).getRequestStatusPic()==2)
        {
            Glide.with(context).load(R.drawable.sample).into(holder.requeststatuspic);

        }else if(requestsFollowItems.get(position).getRequestStatusPic()==3)
        {
            Glide.with(context).load(R.drawable.sample).into(holder.requeststatuspic);

        }else if(requestsFollowItems.get(position).getRequestStatusPic()==4)
        {
            Glide.with(context).load(R.drawable.sample).into(holder.requeststatuspic);
            Glide.with(context).load(R.drawable.checkgreen).into(holder.list);

        }

    }

    @Override
    public int getItemCount() {
        return requestsFollowItems.size();
    }

    public class RequestsFollowViewHolder extends RecyclerView.ViewHolder {

        ImageView list,requeststatuspic;
        TextView requestno,requestname,requeststatus;

        public RequestsFollowViewHolder(View itemView) {
            super(itemView);
            list = itemView.findViewById(R.id.list);
            requeststatuspic = itemView.findViewById(R.id.requeststatuspic);
            requestno = itemView.findViewById(R.id.requestno);
            requestname = itemView.findViewById(R.id.requestname);
            requeststatus = itemView.findViewById(R.id.requeststatus);
        }
    }
}
