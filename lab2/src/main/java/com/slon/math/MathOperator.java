package com.slon.math;

public enum MathOperator {
    ADDITION("+"), SUBTRACTION("-"), DIVISION("/"), MULTIPLICATION("*");

    private final String value;

    MathOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
