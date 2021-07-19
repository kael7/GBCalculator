package com.example.gbcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Calculate calculate;
    private EditText editText_result;
    private String operator;
    private int number_1;
    private int number_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        editText_result = findViewById(R.id.editText_result);
    }

    public void NumberClick(View view) {
        Button button1 = (Button) view;
        editText_result.append(button1.getText());
    }

    public void OperationClick(View view) {
        Button button2 = (Button) view;
        number_1 = Integer.parseInt(editText_result.getText().toString());
        ClearClick(view);
        operator = (String) button2.getText();
    }

    public void EqualsClick(View view) {
        number_2 = Integer.parseInt(editText_result.getText().toString());
        calculate = new Calculate(number_1, number_2, operator);
        setTextCalculate(editText_result, calculate.o_equals(calculate.getOperator()));
    }

    public void ClearClick(View view) {
        editText_result.setText("");
    }

    private void setTextCalculate(EditText editText_result, int calculate) {
        editText_result.setText(String.format(Locale.getDefault(), "%d", calculate));
    }

    private final static String keyCalculates = "Calculates";

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(keyCalculates, calculate);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculate = (Calculate) instanceState.getSerializable(keyCalculates);
        setTextCalculate(editText_result, calculate.getNumber_result());
    }
}