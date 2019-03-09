package com.amirahmed.nanoschool.Adapters.GuestLogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amirahmed.nanoschool.Models.GuestLogin.FeesItem;
import com.amirahmed.nanoschool.R;
import com.amirahmed.nanoschool.Utils.TinyDB;

import java.util.List;

public class FeesAdapter extends RecyclerView.Adapter<FeesAdapter.FeesViewHolder> {

    List<FeesItem> feesItemList;

    Context context;

    TinyDB tinyDB;

    int language;

    public FeesAdapter(List<FeesItem> feesItemList) {
        this.feesItemList = feesItemList;
    }

    @NonNull
    @Override
    public FeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        context = parent.getContext();

        tinyDB = new TinyDB(context);

        language = tinyDB.getInt("language");

        View view;

        if(language==1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fees, parent, false);
        }else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fees, parent, false);
        }

        return new FeesAdapter.FeesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeesViewHolder feesViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return feesItemList.size();
    }

    public class FeesViewHolder extends RecyclerView.ViewHolder {

        LinearLayout container;
        TextView uniformtext,bustext,bookstext,notiestext,comment;

        public FeesViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.cotainer);

            uniformtext = itemView.findViewById(R.id.uniformtext);
            bustext = itemView.findViewById(R.id.bustext);
            bookstext = itemView.findViewById(R.id.bookstext);
            notiestext = itemView.findViewById(R.id.notiestext);
            comment = itemView.findViewById(R.id.comment);

            if(language==1)
            {

            }else
                {
                    container.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                    uniformtext.setText("Uniform");
                    bustext.setText("Bus");
                    bookstext.setText("Books");
                    notiestext.setText("Notes");

                    comment.setText("Fees doesn't include student activities or trips");
                }

        }
    }
}
