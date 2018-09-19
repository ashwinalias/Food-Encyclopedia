package com.example.pc.food_encyclopedia.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc.food_encyclopedia.R;
import com.example.pc.food_encyclopedia.customviews.AppViewHolder;
import com.example.pc.food_encyclopedia.models.MenuItems;

import java.util.ArrayList;

/**
 * Created by user on 18-09-2018.
 */

public class RestaurantMenuListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 1;
    private ArrayList<MenuItems> mMenuList;

    public RestaurantMenuListAdapter(ArrayList<MenuItems> menuList) {
        this.mMenuList = menuList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menulist_item, parent, false);
            return  new RestaurantMenuItemiew(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RestaurantMenuItemiew) {
            MenuItems dataItem = getItem(position);
            //cast holder to VHItem and set data
        }
    }

    @Override
    public int getItemCount() {
        return mMenuList.size() ;
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    private MenuItems getItem(int position) {
        return mMenuList.get(position);
    }

    class RestaurantMenuItemiew extends AppViewHolder {
        TextView title;

        public RestaurantMenuItemiew(View itemView) {
            super(itemView);
            setFonts(itemView);
        }
    }
}
