package com.example.android.practicetest.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference {

    private static final String COUNTER_VALUE = "IncrementalCounter";
    private static final String SHAREDPREFERENCE_NAME = "com.example.android.practicetest.SharedPreference.myPreference";
    SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    public MyPreference(Context context) {

        sharedPreferences = context.getSharedPreferences(SHAREDPREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void incrementCounter() {
        int count = sharedPreferences.getInt(COUNTER_VALUE, 0);
        editor.putInt(COUNTER_VALUE, count + 1);
        editor.apply();

    }

    public int getCounter() {
        int count = sharedPreferences.getInt(COUNTER_VALUE, 0);
        return count;
    }
}
