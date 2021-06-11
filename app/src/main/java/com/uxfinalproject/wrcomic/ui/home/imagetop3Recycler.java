package com.uxfinalproject.wrcomic.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uxfinalproject.wrcomic.R;
import com.uxfinalproject.wrcomic.model.comic;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class imagetop3Recycler extends RecyclerView.Adapter<imagetop3Recycler.imageViewHolder> {

    private List<comic> top3comic = new ArrayList<>();
    private Context context;
    private View view;
    public imagetop3Recycler(Context context, List<comic> top3comic){
        this.context=context;
        this.top3comic=top3comic;
    }

    @NonNull
    @NotNull
    @Override
    public imageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.top3_recycler, parent, false);
        return new imageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull imageViewHolder holder, int position) {
            final comic comic = top3comic.get(position);

            holder.txtJudul.setText(comic.getComic_name());
            holder.txtDesc.setText(comic.getDesc_comic());

            Glide.with(context)
                .load(comic.getComic_image())
                .fitCenter()
                .into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return top3comic.size();
    }


    public class imageViewHolder extends RecyclerView.ViewHolder{
        private TextView txtJudul, txtDesc;
        private ImageView imgView;

        public imageViewHolder(@NonNull View itemView){
            super(itemView);

            txtJudul = (TextView) itemView.findViewById(R.id.tv_namaKomik);
            txtDesc = (TextView) itemView.findViewById(R.id.tv_deskripsiKomik);
            imgView = (ImageView) itemView.findViewById(R.id.imgComic);
        }
    }
}
