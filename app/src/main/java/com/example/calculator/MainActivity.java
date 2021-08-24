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

        if (savedInstanceState == null) {
            calculator = new Calculator();
        } else {
            calculator = savedInstanceState.getParcelable(CALCULATOR);
        }

        panel = findViewById(R.id.panel);

        findViewById(R.id.key_one).setOnClickListener(v -> {
            text = Calculator.number(1);
            updateTextView();
        });

        findViewById(R.id.key_two).setOnClickListener(v -> {
            text = Calculator.number(2);
            updateTextView();
        });

        findViewById(R.id.key_three).setOnClickListener(v -> {
            text = Calculator.number(3);
            updateTextView();
        });

        findViewById(R.id.key_four).setOnClickListener(v -> {
            text = Calculator.number(4);
            updateTextView();
        });

        findViewById(R.id.key_five).setOnClickListener(v -> {
            text = Calculator.number(5);
            updateTextView();
        });

        findViewById(R.id.key_six).setOnClickListener(v -> {
            text = Calculator.number(6);
            updateTextView();
        });

        findViewById(R.id.key_seven).setOnClickListener(v -> {
            text = Calculator.number(7);
            updateTextView();
        });

        findViewById(R.id.key_eight).setOnClickListener(v -> {
            text = Calculator.number(8);
            updateTextView();
        });

        findViewById(R.id.key_nine).setOnClickListener(v -> {
            text = Calculator.number(9);
            updateTextView();
        });

        findViewById(R.id.key_zero).setOnClickListener(v -> {
            text = Calculator.number(0);
            updateTextView();
        });

        findViewById(R.id.key_c).setOnClickListener(v -> {
            text = Calculator.clear();
            updateTextView();
        });

        findViewById(R.id.key_equal).setOnClickListener(v -> {
            text = Calculator.getResult();
            updateTextView();
        });

        findViewById(R.id.key_multiple).setOnClickListener(v -> {
            text = Calculator.newSymbol('*');
            updateTextView();
        });

        findViewById(R.id.key_plus).setOnClickListener(v -> {
            text = Calculator.newSymbol('+');
            updateTextView();
        });

        findViewById(R.id.key_minus).setOnClickListener(v -> {
            text = Calculator.newSymbol('-');
            updateTextView();
        });

        findViewById(R.id.key_division).setOnClickListener(v -> {
            text = Calculator.newSymbol('/');
            updateTextView();
        });

        findViewById(R.id.key_dot).setOnClickListener(v -> {
            text = Calculator.dot();
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