package com.example.laba4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import name.ank.lab4.BibDatabase;
import name.ank.lab4.BibEntry;
import name.ank.lab4.Keys;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static int viewHolderCounts;
    private int numberItems;
    private static BibDatabase database;

    public MyAdapter(int numberItems, BibDatabase database) {
        this.numberItems = numberItems;
        this.database = database;
        viewHolderCounts = 0;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdListItem = R.layout.recyclercview_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdListItem, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        BibEntry element = database.getEntry(viewHolderCounts);
        viewHolder.viewHolderIndex.setText(element.getField(Keys.JOURNAL));
        viewHolderCounts++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView listItemElementView;
        TextView viewHolderIndex;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemElementView = itemView.findViewById(R.id.rv_list);
            viewHolderIndex = itemView.findViewById(R.id.text_view_holder_number);
        }

        void bind(int listIndex) {
            listItemElementView.setText(String.valueOf(listIndex));
        }
    }



}