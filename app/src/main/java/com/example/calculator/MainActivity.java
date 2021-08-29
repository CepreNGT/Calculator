package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calculator.domain.Calculator;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private static final String CALCULATOR = "CALCULATOR";
    private String text;
    private TextView panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panel = findViewById(R.id.panel);
        if (savedInstanceState == null) {
            calculator = new Calculator();
        } else {
            calculator = savedInstanceState.getParcelable(CALCULATOR);
            text = calculator.getReturnStatement();
            updateTextView();
        }

        findViewById(R.id.key_one).setOnClickListener(v -> {
            text = calculator.number(1);
            updateTextView();
        });

        findViewById(R.id.key_two).setOnClickListener(v -> {
            text = calculator.number(2);
            updateTextView();
        });

        findViewById(R.id.key_three).setOnClickListener(v -> {
            text = calculator.number(3);
            updateTextView();
        });

        findViewById(R.id.key_four).setOnClickListener(v -> {
            text = calculator.number(4);
            updateTextView();
        });

        findViewById(R.id.key_five).setOnClickListener(v -> {
            text = calculator.number(5);
            updateTextView();
        });

        findViewById(R.id.key_six).setOnClickListener(v -> {
            text = calculator.number(6);
            updateTextView();
        });

        findViewById(R.id.key_seven).setOnClickListener(v -> {
            text = calculator.number(7);
            updateTextView();
        });

        findViewById(R.id.key_eight).setOnClickListener(v -> {
            text = calculator.number(8);
            updateTextView();
        });

        findViewById(R.id.key_nine).setOnClickListener(v -> {
            text = calculator.number(9);
            updateTextView();
        });

        findViewById(R.id.key_zero).setOnClickListener(v -> {
            text = calculator.number(0);
            updateTextView();
        });

        findViewById(R.id.key_c).setOnClickListener(v -> {
            text = calculator.clear();
            updateTextView();
        });

        findViewById(R.id.key_equal).setOnClickListener(v -> {
            text = calculator.getResult();
            updateTextView();
        });

        findViewById(R.id.key_multiple).setOnClickListener(v -> {
            text = calculator.newSymbol('*');
            updateTextView();
        });

        findViewById(R.id.key_plus).setOnClickListener(v -> {
            text = calculator.newSymbol('+');
            updateTextView();
        });

        findViewById(R.id.key_minus).setOnClickListener(v -> {
            text = calculator.newSymbol('-');
            updateTextView();
        });

        findViewById(R.id.key_division).setOnClickListener(v -> {
            text = calculator.newSymbol('/');
            updateTextView();
        });

        findViewById(R.id.key_dot).setOnClickListener(v -> {
            text = calculator.dot();
            updateTextView();
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CALCULATOR, calculator);
    }

    private void updateTextView() {
        panel.setText(String.valueOf(text));
    }
}