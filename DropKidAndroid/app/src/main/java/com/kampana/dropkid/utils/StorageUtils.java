package com.kampana.dropkid.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import javax.inject.Singleton;

/**
 * Created by daniell on 11/06/16.
 */
@Singleton
public class StorageUtils {

    public static final String appKey = "com.kampana.dropkid";

    private SharedPreferences prefs;

    public void init(Context context) {
        prefs = context.getSharedPreferences(appKey, Context.MODE_PRIVATE);
    }

    private void validateInit() {
        if (prefs == null) {
           throw new IllegalStateException("You must call init before using the prefs.");
        }
    }

    public String readString(String prefsKey, String defaultValue) {
        validateInit();
        return prefs.getString(prefsKey, defaultValue);
    }

    public void writeString(String prefsKey, String value) {
        validateInit();
        prefs.edit().putString(prefsKey, value).apply();

    }
    public void writeStringSet(String prefsKey, Set<String> value) {
        validateInit();
        prefs.edit().putStringSet(prefsKey, value).apply();
    }
}
