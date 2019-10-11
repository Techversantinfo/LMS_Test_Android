package com.example.lmsmobileapp.Controller.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"WeakerAccess", "unused"})

//Shared prefs implementation
public class PreferenceManager {

    private SharedPreferences preferences;
    private static PreferenceManager sInstance;
    // shared pref mode
    int PRIVATE_MODE = 0;
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PreferenceManager(Context context) {
        preferences = context.getSharedPreferences("SESSION_PREF", Context.MODE_PRIVATE);
    }

    public static synchronized PreferenceManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferenceManager(context);
        }
        return sInstance;
    }

    public void put(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void put(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void put(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void put(String key, Set<String> value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public Set<String> getSet(String key) {
        return preferences.getStringSet(key, new HashSet<String>());
    }

    public void increment(String key) {
        int curr = getInt(key);
        put(key, ++curr);
    }

    public void clear() {
        SharedPreferences.Editor edit= preferences.edit();
        edit.clear().apply();
    }

    public ArrayList<String> getArrayList(String key){
        Gson gson = new Gson();
        String jsonText = preferences.getString(key, null);
        //  String[] text = gson.fromJson(jsonText, String[].class);  //EDIT: gso to gson
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, gson.fromJson(jsonText, String[].class));
        return arrayList;
    }

    public void put(String key, ArrayList<String> arrayList){
        //Set the values
        Gson gson = new Gson();
        String jsonText = gson.toJson(arrayList);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, jsonText);
        editor.apply();
    }

    // For welcome screen walkthrough
    public void setFirstTimeLaunch(boolean isFirstTime) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}