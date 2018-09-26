package com.example.pc.food_encyclopedia.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.food_encyclopedia.R;

/**
 * Created by user on 16-09-2018.
 */

public class AboutRestaurantFragment extends  BaseAbstractFragment {
    private ViewPager mViewPager;
    private TextView de;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_restaurant_frag,container,false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {

    }
}
