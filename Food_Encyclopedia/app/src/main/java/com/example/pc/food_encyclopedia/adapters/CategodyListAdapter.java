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
import com.example.pc.food_encyclopedia.listeners.onRecycleViewItemCicked;
import com.example.pc.food_encyclopedia.models.Restaurant;
import com.example.pc.food_encyclopedia.models.TasteCategory;

import java.util.ArrayList;

/**
 * Created by user on 26-09-2018.
 */

public class CategodyListAdapter extends  RecyclerView.Adapter<CategodyListAdapter.CategodyViewHolder> {
    private ArrayList<TasteCategory> mCategories = new ArrayList<>();
    private Context mContext;
    private onRecycleViewItemCicked mOnRecycleViewItemCicked;

    public CategodyListAdapter(Context context, ArrayList<TasteCategory> categories, onRecycleViewItemCicked onRecycleViewItemCicked) {
        mContext = context;
        mCategories = categories;
        this.mOnRecycleViewItemCicked = onRecycleViewItemCicked;
    }

    @Override
    public CategodyListAdapter.CategodyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        CategodyListAdapter.CategodyViewHolder viewHolder = new CategodyListAdapter.CategodyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategodyListAdapter.CategodyViewHolder holder, int position) {
        holder.bindRestaurant(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class CategodyViewHolder extends AppViewHolder {
        ImageView mRestaurantImageView;

        TextView mNameTextView;
        RatingBar mRateBar;
        private Context mContext;

        public CategodyViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            mRestaurantImageView = itemView.findViewById(R.id.category_img_view);
            mRestaurantImageView.setCropToPadding(true);
            setFonts(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecycleViewItemCicked.onItemCLicked(getAdapterPosition());
                }
            });
        }

        public void bindRestaurant(TasteCategory category) {
            if (category != null) {

                //mNameTextView.setText(restaurant.getName());
                // mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
            }
        }
    }
}
