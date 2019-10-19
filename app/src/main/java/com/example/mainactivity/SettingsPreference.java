package com.example.mainactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.preference.PreferenceFragmentCompat;

public class SettingsPreference extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.settings);
    }
}
