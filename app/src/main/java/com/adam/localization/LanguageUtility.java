package com.adam.localization;

import android.content.Context;

public    class LanguageUtility {

    public static String getCurrentLanguage(Context context) {
        String language = KeyValueDB.getPreferenceValue(context, Constants.LANGUAGE);
        // Toast.makeText(getApplicationContext(),"Lang=="+language,Toast.LENGTH_SHORT).show();

        if (language == "1" | language == "2") {
            return language;
        } else {
            return "2";
        }
    }
}
