package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 5.
 * Time: 오전 10:56
 * To change this template use File | Settings | File Templates.
 */
public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    NONE(0);

    private int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
