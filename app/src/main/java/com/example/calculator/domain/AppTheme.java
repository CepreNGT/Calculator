package com.example.calculator.domain;

import com.example.calculator.R;

public enum AppTheme {

    MAIN(R.style.CalcTheme, "main"),
    RED(R.style.CalcThemeRed, "red"),
    BLUE(R.style.CalcThemeBlue, "blue");

    private final int theme;
    private final String key;

    AppTheme(int value, String key) {
        this.theme = value;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getTheme() {
        return theme;
    }
}
