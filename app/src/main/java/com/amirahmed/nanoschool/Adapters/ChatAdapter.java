package com.amirahmed.nanoschool.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amirahmed.nanoschool.Models.ChatItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;
import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ChatAdapter extends FirestoreRecyclerAdapter<ChatItem, ChatAdapter.NoteHolder> {

    Context context;

    TinyDB tinyDB;

    public ChatAdapter(@NonNull FirestoreRecyclerOptions<ChatItem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull ChatItem model) {

        holder.message.setText(model.getMessage());

        DateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
        try {
            Date time = model.getTimestamp();
            String t = sdf.format(time);
            holder.time.setText(t);
        }catch (Exception e)
        {
            //-
        }


        /*Glide.with(context)
                .load(model.getUser_image())
                .into(holder.image);*/
        holder.name.setText(model.getSender());



        if(model.getSender().equals(tinyDB.getString("username")))
        {
            holder.layout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            holder.message.setBackgroundResource(R.drawable.rounded_button);
            holder.layout2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            holder.layout2.setBackgroundResource(R.drawable.rounded_button);
            holder.message.setTextColor(Color.WHITE);
            holder.time.setTextColor(Color.WHITE);
            holder.name.setTextColor(Color.WHITE);
        }else
            {
                holder.layout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                holder.message.setBackgroundResource(R.drawable.rounded_button2);
                holder.layout2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                holder.layout2.setBackgroundResource(R.drawable.rounded_button2);
                holder.message.setTextColor(Color.BLACK);
                holder.time.setTextColor(Color.GRAY);

                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                holder.name.setTextColor(color);
            }

    }

    private void showMessage(String _s) {
        Toast.makeText(context, _s, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item2,
                parent, false);
        return new NoteHolder(v);
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        LinearLayout layout,layout2;
        TextView message,time,name;
        //ImageView image;

        NoteHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            layout2 = itemView.findViewById(R.id.layout2);
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);
            //image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}