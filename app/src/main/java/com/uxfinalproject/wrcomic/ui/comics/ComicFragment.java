package com.uxfinalproject.wrcomic.ui.comics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.uxfinalproject.wrcomic.R;
import com.uxfinalproject.wrcomic.model.comic;
import com.uxfinalproject.wrcomic.ui.home.imagesliderRecycler;
import com.uxfinalproject.wrcomic.ui.home.imagetop3Recycler;

import java.util.ArrayList;
import java.util.List;


public class ComicFragment extends Fragment {

    private List<comic> comics = new ArrayList<>();
    private comic comic1, comic2, comic3, comic4, comic5, comic6;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_comic, container, false);

        comic1 = new comic("LOKISM", "cowok ini punya 2 wujud! pilih yang mana ya…?",R.mipmap.comic3);
        comics.add(comic1);

        comic2 = new comic("Sweet Home", "ketika putus asa sudah melanda..Itu saatnya keluar dari sini!", R.mipmap.sweethome);
        comics.add(comic2);

        comic3 = new comic("Girl's World", "jadi bebek di antara para angsa? we will survive!", R.mipmap.comic2);
        comics.add(comic3);

        comic4 = new comic("Change", "kenapa aku berubah jadi cewek?!", R.mipmap.comic1);
        comics.add(comic4);

        comic5 = new comic("Cinema of Darkness", "gelapnya kehidupan, dibalik cerita-cerita suram", R.mipmap.comic6);
        comics.add(comic5);

        comic6 = new comic("Tower of God", "harta, kuasa, dan ndendam.. Semua yang kamu inginkan, ada di sini!", R.mipmap.comic4);
        comics.add(comic6);






        RecyclerView recyclerView = view.findViewById(R.id.rv_Comics);
        imagetop3Recycler adapterRv = new imagetop3Recycler(view.getContext(), comics);
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