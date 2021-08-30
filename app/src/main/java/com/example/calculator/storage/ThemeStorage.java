package com.example.calculator.storage;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

import com.example.calculator.domain.AppTheme;

public class ThemeStorage {

    private static final String KEY_THEME = "KEY_THEME";

    private final Context context;

    private final SharedPreferences sharedPreferences;

    public ThemeStorage(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences("theme_storage", MODE_PRIVATE);
    }

    public AppTheme getAppTheme() {
        String value = sharedPreferences.getString(KEY_THEME, AppTheme.MAIN.getKey());

        for (AppTheme theme : AppTheme.values()) {
            if (theme.getKey().equals(value)) {
                return theme;
            }
        }

        return AppTheme.MAIN;
    }

    public void setAppTheme(AppTheme appTheme) {
        sharedPreferences.edit()
                .putString(KEY_THEME, appTheme.getKey())
                .apply();
    }
}