package com.example.gbcalculator;

public class AppTheme {
    public AppTheme(int style_id) {
        this.style_id = style_id;
    }

    public AppTheme() {
        this(0);
    }

    public int getStyle_id() {
        return style_id;
    }

    private int style_id;
}
