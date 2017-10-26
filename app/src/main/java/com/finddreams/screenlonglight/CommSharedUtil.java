package com.finddreams.screenlonglight;

/**
 * Created by JiePier on 16/12/6.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


/**
 * CommSharedUtils
 * 通用的SharedPreferences
 */
public class CommSharedUtil {

    private static final String SHARED_PATH = "app_info";
    public static final String FLAG_IS_OPEN_LONG_LIGHT = "longlight";
    private static CommSharedUtil helper;
    private SharedPreferences sharedPreferences;


    private CommSharedUtil(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PATH, Context.MODE_PRIVATE);
    }

    public static CommSharedUtil getInstance(Context context) {
        if (helper == null) {
            helper = new CommSharedUtil(context);
        }
        return helper;
    }

    public  void putInt(String key, int value) {
        Editor edit = sharedPreferences.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public  int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }


    public  void putString(String key, String value) {
        Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        edit.apply();
    }


    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }


    public  void putBoolean(String key, boolean value) {
        Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }


    public  boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public  int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public  void remove(String key) {
        Editor edit = sharedPreferences.edit();
        edit.remove(key);
        edit.apply();
    }

}
