package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Activities.NotificationsDetailsActivity;
import com.amirahmed.nanoschool.Models.NotificationItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder> {

    private List<NotificationItem> notificationItems;
    private TinyDB tinyDB;

    int language;

    public NotificationsAdapter(List<NotificationItem> notificationItems){

        this.notificationItems = notificationItems;
    }

    @Override
    public NotificationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NotificationsViewHolder vh;

        tinyDB = new TinyDB(parent.getContext());

        language = tinyDB.getInt("language");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        vh = new NotificationsViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final NotificationsViewHolder holder, final int position) {

        holder.title.setText(notificationItems.get(position).title);
        holder.content.setText(notificationItems.get(position).content);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NotificationsDetailsActivity.class);
                NotificationItem ni = notificationItems.get(holder.getAdapterPosition());
                intent.putExtra("details",ni.getContent());
                intent.putExtra("title",ni.getTitle());
                v.getContext().startActivity(intent);
                tinyDB.putString(String.valueOf(position),"1");
            }
        });

        if(tinyDB.getString(String.valueOf(position)).equals("1"))
        {
            holder.bell.setImageResource(R.drawable.graybell);
        }else
            {
                holder.bell.setImageResource(R.drawable.redbell);
            }

    }

    @Override
    public int getItemCount() {
        return notificationItems.size();
    }

    class NotificationsViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView content;
        ImageView bell;
        RelativeLayout container;
        Context context;

        NotificationsViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            bell = itemView.findViewById(R.id.bell);
            container = itemView.findViewById(R.id.itemlayout2);

            if(language==1)
            {
                container.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                content.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

            }else
                {
                    container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                    content.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                }


        }
    }
}
