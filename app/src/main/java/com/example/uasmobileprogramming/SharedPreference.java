package com.example.uasmobileprogramming;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreference {
    public  static final String Prefs_Name = "Shared_Pref_Aplikasi";

    public SharedPreference(){
        super();
    }

    public void save(Context Context, String Key, String Text) {
        SharedPreferences Settings;
        Editor Editor;

        Settings = Context.getSharedPreferences(Prefs_Name, android.content.Context.MODE_PRIVATE);
        Editor   = Settings.edit();

        Editor.putString(Key, Text);
        Editor.commit();
    }

    public String getValue(Context Context, String key) {
        SharedPreferences Settings;
        String Text;

        Settings = Context.getSharedPreferences(Prefs_Name, android.content.Context.MODE_PRIVATE);
        Text     = Settings.getString(key, null);
        return Text;
    }

    public void clearSharedPreferences(Context Context) {
        SharedPreferences Settings;
        Editor Editor;

        Settings = Context.getSharedPreferences(Prefs_Name, android.content.Context.MODE_PRIVATE);
        Editor   = Settings.edit();

        Editor.clear();
        Editor.commit();
    }
}

