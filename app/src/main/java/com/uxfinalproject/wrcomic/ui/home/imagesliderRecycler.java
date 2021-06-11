package com.uxfinalproject.wrcomic.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.renderscript.Allocation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.uxfinalproject.wrcomic.R;
import com.uxfinalproject.wrcomic.model.comic;
import java.util.ArrayList;
import java.util.List;

public class imagesliderRecycler extends SliderViewAdapter<imagesliderRecycler.SliderAdapter> {
    private Context context;
    private List<comic> top3comic = new ArrayList<>();




    public  imagesliderRecycler(Context context, List<comic> top3comic){
        this.context = context;
        this.top3comic= top3comic;
    }

    @Override
    public SliderAdapter onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_slider, null);
        return new SliderAdapter(inflate);
    }
    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return top3comic.size();
    }

    @Override
    public void onBindViewHolder(SliderAdapter viewHolder, final int position) {

        comic sliderItem = top3comic.get(position);

        Glide.with(viewHolder.itemView)
                .load(sliderItem.getComic_image())
                .fitCenter()
                .into(viewHolder.imageViewBackground);


    }

    public class SliderAdapter extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;
        public SliderAdapter(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            this.itemView = itemView;
        }
    }
}
