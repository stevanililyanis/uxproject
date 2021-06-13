package com.uxfinalproject.wrcomic.ui.aboutus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.uxfinalproject.wrcomic.R;

import java.util.ArrayList;
import java.util.List;


public class AboutusFragment extends Fragment {

    private Button btnContact, btnAbout;
    ViewPager viewPager;
    PagerAdapter adapter;
    int page = 0;
    ImageView imageView;

    public AboutusFragment() {
        // Required empty public constructor
    }

    public static AboutusFragment newInstance() {
        AboutusFragment fragment = new AboutusFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

   //     setupViewPager();
   //     pageChange();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aboutus, container, false);
        btnContact = view.findViewById(R.id.btn_contactus);
        btnAbout = view.findViewById(R.id.btn_aboutus);
     //   viewPager = view.findViewById(R.id.viewPager);
        imageView=view.findViewById(R.id.about_img);
        Glide.with(getContext())
                .load(R.drawable.aboutus1)
                .fitCenter()
                .into(imageView);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getContext())
                        .load(R.drawable.contactus2)
                        .fitCenter()
                        .into(imageView);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getContext())
                        .load(R.drawable.aboutus1)
                        .fitCenter()
                        .into(imageView);
            }

        });

        return view;
    }

    private void pageChange(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position){
                    case 0:
                        btnAbout.setEnabled(false);
                        break;
                    case 1:
                        btnContact.setEnabled(false);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setupViewPager(){
        List<Integer> id_image = new ArrayList<Integer>();

        id_image.add(R.drawable.aboutus1);
        id_image.add(R.drawable.contactus2);
        adapter = new viewPagerAdapter(getContext(), id_image);
        viewPager.setAdapter(adapter);


    }

    public void prev(){
        viewPager.setCurrentItem(0,true);
    }

    public void next(){
        viewPager.setCurrentItem(1,true);
    }



}