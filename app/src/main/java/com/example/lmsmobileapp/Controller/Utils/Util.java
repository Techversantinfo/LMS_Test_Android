package com.example.lmsmobileapp.Controller.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Util {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo netInfo = connectivity.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnected();
        }
    }

}
