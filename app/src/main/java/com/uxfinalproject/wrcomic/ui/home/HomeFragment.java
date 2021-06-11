package com.uxfinalproject.wrcomic.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.uxfinalproject.wrcomic.R;
import com.uxfinalproject.wrcomic.databinding.FragmentHomeBinding;
import com.uxfinalproject.wrcomic.model.comic;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<comic> top3comic = new ArrayList<>();
    private comic comic1, comic2, comic3;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        comic1 = new comic("LOKISM", "cowok ini punya 2 wujud! pilih yang mana ya…?",R.mipmap.comic3);
        top3comic.add(comic1);

        comic2 = new comic("Sweet Home", "ketika putus asa sudah melanda..Itu saatnya keluar dari sini!", R.mipmap.sweethome);
        top3comic.add(comic2);

        comic3 = new comic("Girl's World", "jadi bebek di antara para angsa? we will survive!", R.mipmap.comic2);
        top3comic.add(comic3);



        SliderView sliderView = view.findViewById(R.id.imageSlider);
        imagesliderRecycler adapter = new imagesliderRecycler(view.getContext(), top3comic);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        RecyclerView recyclerView = view.findViewById(R.id.rv_topComic);
        imagetop3Recycler adapterRv = new imagetop3Recycler(view.getContext(), top3comic);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterRv);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}