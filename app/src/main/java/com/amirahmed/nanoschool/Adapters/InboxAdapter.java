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

import com.amirahmed.nanoschool.Activities.ReplayActivity;
import com.amirahmed.nanoschool.Models.InboxItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.InboxViewHolder> {

    List<InboxItem> inboxItems;

    TinyDB tinyDB;

    int language;

    Context context;

    public InboxAdapter(List<InboxItem> inboxItems) {
        this.inboxItems = inboxItems;
    }

    @Override
    public InboxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inbox, parent, false);
        }else
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inbox_en, parent, false);
            }


        InboxViewHolder eh = new InboxViewHolder(view);
        return eh;
    }

    @Override
    public void onBindViewHolder(@NonNull final InboxViewHolder holder, final int position) {

        holder.senderName.setText(inboxItems.get(position).senderName);
        holder.date.setText(inboxItems.get(position).Date);
        holder.messageHeader.setText(inboxItems.get(position).messageHeader);
        holder.messageBody.setText(inboxItems.get(position).messageBody);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxItems.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,inboxItems.size());
            }
        });

        holder.replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, ReplayActivity.class);
                myIntent.putExtra("Sender",inboxItems.get(position).senderName);
                myIntent.putExtra("title",inboxItems.get(position).messageHeader);
                context.startActivity(myIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return inboxItems.size();
    }

    public class InboxViewHolder extends RecyclerView.ViewHolder {

        TextView senderName,date,messageBody,messageHeader;
        ImageView delete,download,replay;

        public InboxViewHolder(View itemView) {
            super(itemView);
            senderName = itemView.findViewById(R.id.senderName);
            date = itemView.findViewById(R.id.date);
            messageBody = itemView.findViewById(R.id.messageBody);
            messageHeader = itemView.findViewById(R.id.messageHeader);
            delete = itemView.findViewById(R.id.deletebutton);
            download = itemView.findViewById(R.id.downloadattachmentbutton);
            replay = itemView.findViewById(R.id.replaybutton);
        }
    }
}
