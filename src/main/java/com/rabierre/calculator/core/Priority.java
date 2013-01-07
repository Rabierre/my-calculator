package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 5.
 * Time: 오전 10:56
 * To change this template use File | Settings | File Templates.
 */
public enum Priority {
    PLUS(2),
    MINUS(2),
    MULTI(3),
    DIVIDE(3),
    POWER(3),
    OPEN_BRACKET(1),
    CLOSE_BRACKET(1);

    private int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
