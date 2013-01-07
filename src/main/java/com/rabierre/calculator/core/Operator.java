package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 5.
 * Time: 오전 10:56
 * To change this template use File | Settings | File Templates.
 */
public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DIVIDE("/"),
    POWER("^"),
    OPEN_BRACKET("("),
    CLOSE_BRACKET(")");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
