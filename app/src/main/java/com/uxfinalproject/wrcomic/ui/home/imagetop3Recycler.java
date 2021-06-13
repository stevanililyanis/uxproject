package com.uxfinalproject.wrcomic.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uxfinalproject.wrcomic.R;
import com.uxfinalproject.wrcomic.model.comic;
import com.uxfinalproject.wrcomic.ui.comics.detailComicFragment;

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

            holder.rv_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    detailComicFragment detailFragment= detailComicFragment.newInstance(comic);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("comic", comic);
                    detailFragment.setArguments(bundle);
                   // detailComicFragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "comic_detail_fragment");
                  //  detailComicFragment.getActivity().getSupportFragmentManager().beginTransaction();

                    FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment_content_main,detailFragment)
                            .commit();
                }
            });

    }



    @Override
    public int getItemCount() {
        return top3comic.size();
    }


    public class imageViewHolder extends RecyclerView.ViewHolder{
        private TextView txtJudul, txtDesc;
        private ImageView imgView;
        private LinearLayout rv_item;

        public imageViewHolder(@NonNull View itemView){
            super(itemView);

            txtJudul = (TextView) itemView.findViewById(R.id.tv_namaKomik);
            txtDesc = (TextView) itemView.findViewById(R.id.tv_deskripsiKomik);
            imgView = (ImageView) itemView.findViewById(R.id.imgComic);
            rv_item = (LinearLayout) itemView.findViewById(R.id.rv_item);
        }
    }
}
