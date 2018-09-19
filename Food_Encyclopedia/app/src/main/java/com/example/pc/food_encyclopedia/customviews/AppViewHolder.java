package com.example.pc.food_encyclopedia.customviews;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 19-09-2018.
 */

public class AppViewHolder extends RecyclerView.ViewHolder{
    public AppViewHolder(View itemView) {
        super(itemView);
    }
    protected void setFonts(View view){
        try {
            Typeface tf = Typeface.DEFAULT;
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    setFonts(child);
                }
            } else if (view instanceof TextView) {
            }
            switch (((TextView) view).getTypeface().getStyle()) {
                case Typeface.BOLD:
                    tf = Typeface.createFromAsset(view.getContext().getAssets(), "Nexa Bold.otf");
                    break;

                default:
                    tf = Typeface.createFromAsset(view.getContext().getAssets(), "Nexa Light.otf");
                    break;
            }
            ((TextView) view).setTypeface(tf);

        } catch (Exception e) {
        }
    }
}
