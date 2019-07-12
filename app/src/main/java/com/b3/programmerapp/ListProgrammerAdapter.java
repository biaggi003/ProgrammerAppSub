package com.b3.programmerapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class ListProgrammerAdapter extends RecyclerView.Adapter<ListProgrammerAdapter.CategoryViewHolder> {
    private Context context;

    private ArrayList<Programmer> listProgrammer;

    private ArrayList<Programmer> getListProgrammer(){
        return listProgrammer;
    }

    void setListProgrammer(ArrayList<Programmer> listProgrammer) {
        this.listProgrammer = listProgrammer;
    }

    ListProgrammerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_programmer, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {

        categoryViewHolder.tvName.setText(getListProgrammer().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListProgrammer().get(position).getRemarks());

        Glide.with(context)
                .load(getListProgrammer().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListProgrammer().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
