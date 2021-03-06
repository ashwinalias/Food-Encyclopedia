package com.example.pc.food_encyclopedia.fragment;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 16-09-2018.
 */

public class BaseAbstractFragment extends Fragment {

    protected void setBaseFontviews(View view) {
        try {
            Typeface tf = Typeface.DEFAULT;
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    setBaseFontviews(child);
                }
            } else if (view instanceof TextView) {
            }
            switch (((TextView) view).getTypeface().getStyle()) {
                case Typeface.BOLD:
                    tf = Typeface.createFromAsset(getContext().getAssets(), "Nexa Bold.otf");
                    break;

                default:
                    tf = Typeface.createFromAsset(getContext().getAssets(), "Nexa Light.otf");
                    break;
            }
            ((TextView) view).setTypeface(tf);

        } catch (Exception e) {
        }
    }
}
