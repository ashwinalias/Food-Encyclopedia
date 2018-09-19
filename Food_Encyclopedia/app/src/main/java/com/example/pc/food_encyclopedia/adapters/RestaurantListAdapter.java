package com.example.pc.food_encyclopedia.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.pc.food_encyclopedia.R;
import com.example.pc.food_encyclopedia.customviews.AppViewHolder;
import com.example.pc.food_encyclopedia.fragment.RestaurantListFrgament;
import com.example.pc.food_encyclopedia.listeners.onRecycleViewItemCicked;
import com.example.pc.food_encyclopedia.models.Restaurant;

import java.util.ArrayList;

/**
 * Created by user on 16-09-2018.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
    private ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    private Context mContext;
    private onRecycleViewItemCicked mOnRecycleViewItemCicked;

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> restaurants, onRecycleViewItemCicked onRecycleViewItemCicked) {
        mContext = context;
        mRestaurants = restaurants;
        this.mOnRecycleViewItemCicked = onRecycleViewItemCicked;
    }

    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public class RestaurantViewHolder extends AppViewHolder {
        ImageView mRestaurantImageView;

        TextView mNameTextView;
        RatingBar mRateBar;
        private Context mContext;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            setFonts(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecycleViewItemCicked.onItemCLicked(getAdapterPosition());
                }
            });
        }

        public void bindRestaurant(Restaurant restaurant) {
            if (restaurant != null) {
                //mNameTextView.setText(restaurant.getName());
                // mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
            }
        }
    }
}