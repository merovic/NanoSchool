package com.amirahmed.nanoschool.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.NavigationItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.NavigationDrawerCallbacks;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;


public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {

    private List<NavigationItem> mData;
    private NavigationDrawerCallbacks mNavigationDrawerCallbacks;
    private View mSelectedView;
    private int mSelectedPosition;

    TinyDB tinyDB;

    int language;

    Context context;

    View v;

    public NavigationDrawerAdapter(List<NavigationItem> data) {
        mData = data;
    }

    public NavigationDrawerCallbacks getNavigationDrawerCallbacks() {
        return mNavigationDrawerCallbacks;
    }

    public void setNavigationDrawerCallbacks(NavigationDrawerCallbacks navigationDrawerCallbacks) {
        mNavigationDrawerCallbacks = navigationDrawerCallbacks;
    }

    @NonNull
    @Override
    public NavigationDrawerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context = viewGroup.getContext();
        tinyDB = new TinyDB(context);
        language = tinyDB.getInt("language");
        if(language==1)
        {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drawer_row, viewGroup, false);
        }else
        {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drawer_row_en, viewGroup, false);
        }
        final ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.itemView.setClickable(true);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       if (mSelectedView != null) {
                                                           mSelectedView.setSelected(false);
                                                       }
                                                       mSelectedPosition = viewHolder.getAdapterPosition();
                                                       v.setSelected(true);
                                                       mSelectedView = v;
                                                       if (mNavigationDrawerCallbacks != null)
                                                           mNavigationDrawerCallbacks.onNavigationDrawerItemSelected(viewHolder.getAdapterPosition());
                                                   }
                                               }
        );
        viewHolder.itemView.setBackgroundResource(R.drawable.row_selector);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationDrawerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(mData.get(i).getText());
        tinyDB = new TinyDB(context);
        language = tinyDB.getInt("language");   //left-top-right-bottom
        if(language==1)
        {
            viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(null, null, mData.get(i).getDrawable(), null);
        }else
        {
            viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(mData.get(i).getDrawable(), null, null, null);
        }
        /*if (mSelectedPosition == i) {
            if (mSelectedView != null) {
                mSelectedView.setSelected(false);
            }
            mSelectedPosition = i;
            mSelectedView = viewHolder.itemView;
            mSelectedView.setSelected(true);
        } else {
            if (mSelectedView != null) {
                mSelectedView.setSelected(false);
            }
        }*/
    }


    public void selectPosition(int position) {
        mSelectedPosition = position;
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_name);
        }
    }
}