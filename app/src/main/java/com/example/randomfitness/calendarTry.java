package com.example.randomfitness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class calendarTry extends RecyclerView.Adapter<calendarHolder> {
    private final ArrayList<String> daysOfMonth;
    private final onItemListener onItemListener;

    public calendarTry(ArrayList<String> daysOfMonth, calendarTry.onItemListener onItemListener) {
        this.daysOfMonth = daysOfMonth;
        this.onItemListener = onItemListener;
    }


    @NonNull
    @Override
    public calendarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent,false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.16666666);
        return new calendarHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull calendarHolder holder, int position) {
        holder.dayOfMonth.setText(daysOfMonth.get(position));
    }

    @Override
    public int getItemCount() {
        return daysOfMonth.size();
    }

    public interface onItemListener{
        void onItemClick(int position, String dayText);
    }
}
