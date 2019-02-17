package com.example.android.practicetest.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.practicetest.R;
import com.example.android.practicetest.SharedPreference.MyPreference;

public class Fragment3 extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String TAG = "Fragment3";
    TextView textView, textView1, textView2;
    Button incrementButton;
    SharedPreferences sharedPreferences;
    MyPreference myPreference;

    public Fragment3() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.checkBoxAns);
        textView1 = view.findViewById(R.id.ListViewAns);
        textView2 = view.findViewById(R.id.showCount);
        incrementButton = view.findViewById(R.id.incrementButton);
        myPreference = new MyPreference(getContext());

        /**
         * get values from shared preference
         */
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean checkBoxValue = sharedPreferences.getBoolean("checkBox1", false);
        String countryName = sharedPreferences.getString("listView1", "");

        /**
         * set all values based on shared preference
         */
        textView.setText("" + checkBoxValue);
        textView1.setText(countryName);
        textView2.setText("" + myPreference.getCounter());
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);


        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPreference.incrementCounter();
                textView2.setText("" + myPreference.getCounter());
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        }
        super.onDestroy();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        if (s.equals("listView1")) {
            textView1.setText(sharedPreferences.getString(s, ""));
        } else if (s.equals("checkBox1")) {
            Log.d(TAG, "onSharedPreferenceChanged: " + s);
            boolean checkBoxValue = sharedPreferences.getBoolean("checkBox1", false);
            textView.setText("" + checkBoxValue);
        }

    }
}
