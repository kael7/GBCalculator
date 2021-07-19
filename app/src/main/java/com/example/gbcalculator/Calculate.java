package com.example.gbcalculator;

import java.io.Serializable;

public class Calculate implements Serializable {
    private int number_1;
    private int number_2;
    private int number_result;
    private String operator;

    public Calculate() {
        this(0, 0, "");
    }

    public Calculate(int number_1, int number_2, String operator) {
        this.number_1 = number_1;
        this.number_2 = number_2;
        this.operator = operator;
    }

    public int getNumber_1() {
        return number_1;
    }

    public int getNumber_2() {
        return number_2;
    }

    public int getNumber_result() {
        return number_result;
    }

    public String getOperator() {
        return operator;
    }

    public void setNumber_1(int number_1) {
        this.number_1 = number_1;
    }

    public void setNumber_2(int number_2) {
        this.number_2 = number_2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int o_plus(int number_1, int number_2) {
        number_result = number_1 + number_2;
        return number_result;
    }

    public int o_minus(int number_1, int number_2) {
        number_result = number_1 - number_2;
        return number_result;
    }

    public int o_divide(int number_1, int number_2) {
        if (number_2 == 0) {
            number_result = 0;
        } else {
            number_result = number_1 / number_2;
        }

        return number_result;
    }

    public int o_multiply(int number_1, int number_2) {
        number_result = number_1 * number_2;
        return number_result;
    }

    public int o_equals(String operator){
        switch (operator) {
            case "/":
                o_divide(number_1, number_2);
                break;
            case "*":
                o_multiply(number_1, number_2);
                break;
            case "+":
                o_plus(number_1, number_2);
                break;
            case "-":
                o_minus(number_1, number_2);
                break;
            default:
                return 0;
        }
        return number_result;
    }

}
