package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 7.
 * Time: 오후 1:35
 * To change this template use File | Settings | File Templates.
 */
public class Token {
    private String value;
    private int priority;
    private boolean isOperator;

    public Token(String value, boolean isOperator) {
        this.value = value;
        this.isOperator = isOperator;
        this.priority = orderPriority();
    }

    private int orderPriority() {
        switch (value) {
            case "(":
            case ")":
                return Priority.LOW.getValue();
            case "+":
            case "-":
                return Priority.MEDIUM.getValue();
            case "*":
            case "/":
            case "^":
                return Priority.HIGH.getValue();
            default:
                return Priority.NONE.getValue();
        }
    }

    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isOperator() {
        return isOperator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;

        Token token = (Token) o;

        if (isOperator != token.isOperator) return false;
        if (priority != token.priority) return false;
        if (value != null ? !value.equals(token.value) : token.value != null) return false;

        return true;
    }
}
