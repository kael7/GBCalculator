package com.example.gbcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        switch (calculate.getOperator()) {
            case "/":
                calculate.o_divide(calculate.getNumber_1(), calculate.getNumber_2());
                break;
            case "*":
                calculate.o_multiply(calculate.getNumber_1(), calculate.getNumber_2());
                break;
            case "+":
                calculate.o_plus(calculate.getNumber_1(), calculate.getNumber_2());
                break;
            case "-":
                calculate.o_minus(calculate.getNumber_1(), calculate.getNumber_2());
                break;
            default:
                calculate.getNumber_result();
                break;
        }
        editText_result.setText(Integer.toString(calculate.getNumber_result()));
    }

    public void ClearClick(View view) {
        editText_result.setText("");
    }
}