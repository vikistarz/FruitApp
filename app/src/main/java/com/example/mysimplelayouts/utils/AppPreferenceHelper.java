package com.example.mysimplelayouts.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mysimplelayouts.R;
import com.example.mysimplelayouts.screens.AppConstant;

public class AppPreferenceHelper {

    public static void clearPrefValue(Context context, String prefKey) {
        SharedPreferences mySharedPreference = context.getSharedPreferences(context.getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.remove(prefKey);
        myEditor.apply();
    }

    public static void saveStringPrefValue(Context context, String prefKey, String value) {
        SharedPreferences mySharedPreference = context.getSharedPreferences(context.getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putString(prefKey, value);
        myEditor.apply();
    }

    public static void saveIntPrefValue(Context context, String prefKey, int value) {
        SharedPreferences mySharedPreference = context.getSharedPreferences(context.getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putInt(prefKey, value);
        myEditor.apply();
    }
}
