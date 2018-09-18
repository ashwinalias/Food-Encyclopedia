package com.example.pc.food_encyclopedia.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc.food_encyclopedia.R;
import com.example.pc.food_encyclopedia.models.MenuItems;

import java.util.ArrayList;

/**
 * Created by user on 18-09-2018.
 */

public class RestaurantMenuListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private ArrayList<MenuItems> mMenuList;

    public RestaurantMenuListAdapter(ArrayList<MenuItems> menuList) {
        this.mMenuList = menuList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menulist_item, parent, false);
            return  new RestaurantMenuItemiew(v);
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menulist_header, parent, false);
            return new MenuHeaderView(v);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RestaurantMenuItemiew) {
            MenuItems dataItem = getItem(position);
            //cast holder to VHItem and set data
        } else if (holder instanceof MenuHeaderView) {
            //cast holder to VHHeader and set data for header.
        }
    }

    @Override
    public int getItemCount() {
        return mMenuList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private MenuItems getItem(int position) {
        return mMenuList.get(position - 1);
    }

    class RestaurantMenuItemiew extends RecyclerView.ViewHolder {
        TextView title;

        public RestaurantMenuItemiew(View itemView) {
            super(itemView);
        }
    }

    class MenuHeaderView extends RecyclerView.ViewHolder {
        Button button;

        public MenuHeaderView(View itemView) {
            super(itemView);
        }
    }
}
