package com.uxfinalproject.wrcomic.ui.aboutus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.uxfinalproject.wrcomic.R;
import com.uxfinalproject.wrcomic.ui.home.imagetop3Recycler;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class viewPagerAdapter extends PagerAdapter {

    private View view;
    private List<Integer> id_image = new ArrayList<Integer>();
    private Context context;
    private LayoutInflater layoutInflater;


    public viewPagerAdapter (Context context, List<Integer> id_image){
        this.context=context;
        this.id_image=id_image;
    }

    @Override
    public int getCount() {
        return id_image.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_viewpager,container,false);
        LinearLayout linearLayout = view.findViewById(R.id.item_layout_vp);
        ImageView imageView = view.findViewById(R.id.imageVP);



        Glide.with(context)
                .load(id_image.get(position))
                .fitCenter()
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
