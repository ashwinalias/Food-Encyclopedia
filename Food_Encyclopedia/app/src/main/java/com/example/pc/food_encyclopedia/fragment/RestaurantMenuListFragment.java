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
import com.example.pc.food_encyclopedia.adapters.RestaurantMenuListAdapter;
import com.example.pc.food_encyclopedia.customviews.CustomItemDecoration;
import com.example.pc.food_encyclopedia.models.MenuItems;
import com.example.pc.food_encyclopedia.models.Restaurant;

import java.util.ArrayList;

/**
 * Created by user on 16-09-2018.
 */

public class RestaurantMenuListFragment extends BaseAbstractFragment {
    private RecyclerView mRestaurantMenuList;
    private RestaurantMenuListAdapter mRestaurantMenuListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.restaurant_menu_list_frag, container, false);
        initiews(v);
        setBaseFontviews(v);
        initSampleData();
        return v;
    }

    private void initSampleData() {
        mRestaurantMenuListAdapter = new RestaurantMenuListAdapter( getSampleMenuList());
        mRestaurantMenuList.setAdapter(mRestaurantMenuListAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRestaurantMenuList.setLayoutManager(llm);
        mRestaurantMenuList.addItemDecoration(new CustomItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }


    private ArrayList<MenuItems> getSampleMenuList() {
        ArrayList<MenuItems> data = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            MenuItems restaurant = new MenuItems();
            //restaurant.setName("Sample " + i);
            //restaurant.setSecName("Location");
            data.add(restaurant);
        }
        return data;
    }

    private void initiews(View v) {
        mRestaurantMenuList = v.findViewById(R.id.restaurant_menu_list);
    }
}
