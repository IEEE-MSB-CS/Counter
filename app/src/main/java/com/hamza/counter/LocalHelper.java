package com.hamza.counter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class LocalHelper {

    private static SharedPreferences sharedPreferences;

    public static void setLocal(Activity activity, String language) {
        Configuration configuration = new Configuration();
        sharedPreferences = activity.getSharedPreferences("settings", Context.MODE_PRIVATE);

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        activity.getResources().updateConfiguration(configuration, activity.getResources().getDisplayMetrics());
        sharedPreferences.edit().putString("language", language).apply();
    }

    public static void loadLocal(Activity activity) {
        sharedPreferences = activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        setLocal(activity, sharedPreferences.getString("language", "en"));
    }

    public static String getCurrentLocal() {
        return sharedPreferences.getString("language", "en");
    }
}
