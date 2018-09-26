package com.example.pc.food_encyclopedia.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.food_encyclopedia.R;
import com.example.pc.food_encyclopedia.adapters.CategodyListAdapter;
import com.example.pc.food_encyclopedia.adapters.RestaurantListAdapter;
import com.example.pc.food_encyclopedia.customviews.CustomItemDecoration;
import com.example.pc.food_encyclopedia.listeners.onRecycleViewItemCicked;
import com.example.pc.food_encyclopedia.models.Restaurant;
import com.example.pc.food_encyclopedia.models.TasteCategory;

import java.util.ArrayList;

/**
 * Created by user on 26-09-2018.
 */

public class CategoryListViewFragment extends BaseAbstractFragment implements onRecycleViewItemCicked {
    private RecyclerView categoryListView;
    private CategodyListAdapter mCategodyListAdapter;
    private ArrayList<TasteCategory> mCategoryArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.category_list_frag,container,false);
        initiews(v);
        setBaseFontviews(v);
        initSampleData();
        return v;
    }



    private void initiews(View v) {
        categoryListView = v.findViewById(R.id.category_listView);

    }
    private void initSampleData() {
        mCategodyListAdapter = new CategodyListAdapter(getActivity(),getSampleList(),this);
        categoryListView.setAdapter(mCategodyListAdapter);

        categoryListView.setLayoutManager(new GridLayoutManager(getActivity(), 4, GridLayoutManager.VERTICAL, false));
        //categoryListView.addItemDecoration(new CustomItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    private ArrayList<TasteCategory> getSampleList() {
        ArrayList<TasteCategory> data = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            TasteCategory restaurant = new TasteCategory();
            data.add(restaurant);
        }
        return data;
    }

    @Override
    public void onItemCLicked(int position) {
        FragmentTransaction transactin = getActivity().getSupportFragmentManager().beginTransaction();
        RestaurantListFrgament restaurantListFragment = new RestaurantListFrgament();
        transactin.replace(R.id.fragment_base, restaurantListFragment);
        transactin.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transactin.addToBackStack(null);
        transactin.commit();
    }
}
