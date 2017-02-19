package com.yichenapp.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class SharePreferencesHelper {
    public final static String NAME = "SharePreferencesHelper.NAME";

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getmEditor() {
        return mEditor;
    }

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor mEditor;

    public static void init(Context context){
        sharedPreferences = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        mEditor = sharedPreferences.edit();
    }

    public static void saveObject(String key, Object object){
        Gson gson = new Gson();
        String str = gson.toJson(object);
        mEditor.putString(key,str).commit();
    }

    public static <T> T getObject(String key,Class<T> cla){
        String temp = sharedPreferences.getString(key,"");
        if(TextUtils.isEmpty(temp)){
            return null;
        }
        Gson gson = new Gson();
        try {
            T t=gson.fromJson(temp,cla);
            return t;
        }catch (JsonSyntaxException e){
            return null;
        }
    }

    public static void removeByKey(String key){
        mEditor.remove(key).commit();
    }
}
