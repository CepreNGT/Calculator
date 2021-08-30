package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    public static final String THEME = "THEME";
    private String theme = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Intent launchIntent = getIntent();
        String someTheme = launchIntent.getStringExtra(THEME);
        if (someTheme.equals("main")) {
            findViewById(R.id.rb1).performClick();
        }
        if (someTheme.equals("red")) {
            findViewById(R.id.rb2).performClick();
        }
        if (someTheme.equals("blue")) {
            findViewById(R.id.rb3).performClick();
        }
        findViewById(R.id.rb1).setOnClickListener(v -> {
            theme = "MAIN";
        });
        findViewById(R.id.rb2).setOnClickListener(v -> {
            theme = "RED";
        });
        findViewById(R.id.rb3).setOnClickListener(v -> {
            theme = "BLUE";
        });
        findViewById(R.id.set_button).setOnClickListener(v -> {
            Intent data = new Intent();
            data.putExtra(THEME, theme);
            setResult(Activity.RESULT_OK, data);
            finish();
        });
    }
}
