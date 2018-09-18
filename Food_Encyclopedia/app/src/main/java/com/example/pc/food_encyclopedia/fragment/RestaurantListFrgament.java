package com.example.pc.food_encyclopedia.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.example.pc.food_encyclopedia.R;
import com.example.pc.food_encyclopedia.adapters.RestaurantListAdapter;
import com.example.pc.food_encyclopedia.customviews.CustomItemDecoration;
import com.example.pc.food_encyclopedia.models.Restaurant;

import java.util.ArrayList;

/**
 * Created by user on 16-09-2018.
 */

public class RestaurantListFrgament extends BaseAbstractFragment {
    private AutoCompleteTextView mSearchAutoCompleteTextView;
    private RecyclerView mRestaurantList;
    private RestaurantListAdapter mRestaurantListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.restaurant_list_frag, container, false);
        initiews(v);
        setBaseFontviews(v);
        initSampleData();
        return v;
    }

    private void initSampleData() {
        mRestaurantListAdapter = new RestaurantListAdapter(getActivity(), getSampleList());
        mRestaurantList.setAdapter(mRestaurantListAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRestaurantList.setLayoutManager(llm);
        mRestaurantList.addItemDecoration(new CustomItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    private ArrayList<Restaurant> getSampleList() {
        ArrayList<Restaurant> data = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName("Sample " + i);
            restaurant.setSecName("Location");
            data.add(restaurant);
        }
        return data;
    }

    private void initiews(View v) {
        mSearchAutoCompleteTextView = v.findViewById(R.id.restaurant_search);
        mRestaurantList = v.findViewById(R.id.restaurant_list);
    }
}
