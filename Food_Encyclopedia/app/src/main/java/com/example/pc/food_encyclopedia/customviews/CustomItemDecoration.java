package com.example.pc.food_encyclopedia.customviews;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.pc.food_encyclopedia.R;

/**
 * Created by user on 18-09-2018.
 */

public class CustomItemDecoration extends DividerItemDecoration {
    public CustomItemDecoration(Context context, int orientation) {
        super(context,orientation);
        setDrawable(ContextCompat.getDrawable(context, R.drawable.line_divider));
    }
}
