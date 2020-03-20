package com.adam.localization;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyValueDB {

    public KeyValueDB(){}

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(Constants.EMAIL, Context.MODE_PRIVATE);
    }
    public static String getPreferenceValue(Context context, String pref_key){
        return getPrefs(context).getString(pref_key,"not found");
    }
    public static void setPreferenceValue(Context context, String name, String value){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString(name, value);
        editor.commit();
    }
}
