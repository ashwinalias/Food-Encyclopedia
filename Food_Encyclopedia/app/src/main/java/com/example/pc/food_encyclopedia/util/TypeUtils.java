package com.example.pc.food_encyclopedia.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 19-09-2018.
 */

public class TypeUtils {
    public static Typeface getBoldTypeFace(Context context){
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "Nexa Bold.otf");
        return tf;
    }
    public static Typeface getNormalTypeFace(Context context){
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "Nexa Light.otf");
        return tf;
    }
    public static void setBaseFontviews(Context context,View view) {
        try {
            Typeface tf = Typeface.DEFAULT;
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    setBaseFontviews(context,child);
                }
            } else if (view instanceof TextView) {
            }
            switch (((TextView) view).getTypeface().getStyle()) {
                case Typeface.BOLD:
                    tf = Typeface.createFromAsset(context.getAssets(), "Nexa Bold.otf");
                    break;

                default:
                    tf = Typeface.createFromAsset(context.getAssets(), "Nexa Light.otf");
                    break;
            }
            ((TextView) view).setTypeface(tf);

        } catch (Exception e) {
        }
    }
}
