package com.uxfinalproject.wrcomic.ui.comics;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.uxfinalproject.wrcomic.R;
import com.uxfinalproject.wrcomic.model.comic;


public class detailComicFragment  extends BottomSheetDialogFragment{

    private com.uxfinalproject.wrcomic.model.comic comic;
    private TextView tvJudul, tvDesc;
    private ImageView img_comic;
    private ImageButton btn_close;
    private Button btn_add;
    private LinearLayout layout_detail;
    private TextInputEditText quantity;
    public detailComicFragment() {
    }

    public static detailComicFragment newInstance(comic comic) {

        detailComicFragment fragment = new detailComicFragment();

        Bundle args = new Bundle();
        args.putSerializable("comic", comic);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        comic = (comic)getArguments().getSerializable("comic");

        System.out.println(comic.getComic_name());
        View view = inflater.inflate(R.layout.fragment_detail_comic, container, false);
        tvJudul = view.findViewById(R.id.tv_DnamaKomik);
        tvDesc=view.findViewById(R.id.tv_DdeskripsiKomik);
        img_comic=view.findViewById(R.id.imgDComic);
        btn_close=view.findViewById(R.id.btn_close);
        btn_add=view.findViewById(R.id.btn_add);
        layout_detail = view.findViewById(R.id.layout_detail);
        quantity= view.findViewById(R.id.quantity);

        tvJudul.setText(comic.getComic_name());
        tvDesc.setText(comic.getDesc_comic());

        Glide.with(getContext())
                .load(comic.getComic_image())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(img_comic);



        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentManager.popBackStackImmediate();
                layout_detail.setVisibility(View.GONE);

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(String.valueOf(quantity.getText()))<1||String.valueOf(quantity.getText())==""){
                    new AlertDialog.Builder(getContext())
                            .setTitle("Warning!!")
                            .setMessage("Quantity must be greater than 0!")
                            .show();
                }else{
                    new AlertDialog.Builder(getContext())
                            .setTitle("Success!")
                            .setMessage("Your books added to the cart")
                            .show();
                }
            }
        });
       return view;
    }
}