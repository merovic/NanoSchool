package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(InboxViewHolder holder, int position) {

        holder.senderName.setText(inboxItems.get(position).senderName);
        holder.date.setText(inboxItems.get(position).Date);
        holder.messageHeader.setText(inboxItems.get(position).messageHeader);
        holder.messageBody.setText(inboxItems.get(position).messageBody);

    }

    @Override
    public int getItemCount() {
        return inboxItems.size();
    }

    public class InboxViewHolder extends RecyclerView.ViewHolder {

        TextView senderName,date,messageBody,messageHeader;

        public InboxViewHolder(View itemView) {
            super(itemView);
            senderName = itemView.findViewById(R.id.senderName);
            date = itemView.findViewById(R.id.date);
            messageBody = itemView.findViewById(R.id.messageBody);
            messageHeader = itemView.findViewById(R.id.messageHeader);
        }
    }
}
