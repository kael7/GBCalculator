package com.example.gbcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class MainActivity extends BaseActivity implements Constants{
    private AppTheme appTheme;
    private Calculate calculate;
    private TextInputEditText textField_result;
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
        textField_result = findViewById(R.id.result);
        Button btnSettings = findViewById(R.id.button_Settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(runSettings);
            }
        });
    }

    public void NumberClick(View view) {
        Button button1 = (Button) view;
        textField_result.append(button1.getText());
    }

    public void OperationClick(View view) {
        Button button2 = (Button) view;
        number_1 = Integer.parseInt(textField_result.getText().toString());
        ClearClick(view);
        operator = (String) button2.getText();
    }

    private void ApplyTheme() {
//        Button btnApply = findViewById(R.id.button_apply);
//        btnApply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setAppTheme(appTheme.getStyle_id());
//            }
//        });
    }

    public void ApplyClick(View view) {
        Button button3 = (Button) view;
        try {
            setAppTheme(appTheme.getStyle_id());
        } catch (Exception e) {
            System.out.println("Error Style ID " + appTheme.getStyle_id());
        }
    }

    public void EqualsClick(View view) {
        number_2 = Integer.parseInt(textField_result.getText().toString());
        calculate = new Calculate(number_1, number_2, operator);
        setTextCalculate(textField_result, calculate.o_equals(calculate.getOperator()));
    }

    public void ClearClick(View view) {
        textField_result.setText("");
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
        setTextCalculate(textField_result, calculate.getNumber_result());
    }
}