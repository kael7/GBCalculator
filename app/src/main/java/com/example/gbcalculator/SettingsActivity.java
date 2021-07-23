package com.example.gbcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseActivity implements Constants {
    private AppTheme appTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initThemeChooser();

        Button btnReturn = findViewById(R.id.button_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMyCoolStyle),
                MyAppStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialDark),
                AppThemeDarkCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLight),
                AppThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLightDarkAction),
                AppThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(MyAppStyle))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appTheme = new AppTheme(codeStyle);
                System.out.println(appTheme.getStyle_id());
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }

}