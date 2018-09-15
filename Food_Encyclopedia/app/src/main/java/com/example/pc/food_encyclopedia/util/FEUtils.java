package com.example.pc.food_encyclopedia.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

/**
 * Created by USER on 9/8/2018.
 */

public class FEUtils {
    Context mContext;

    public FEUtils(Context context) {
        mContext = context;
    }

    public static String getCountyCode(Context context) {
        String countyCode = context.getResources().getConfiguration().locale.getCountry();
        return countyCode;
    }


}
