package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 8.
 * Time: 오후 2:55
 * To change this template use File | Settings | File Templates.
 */
public class ValueToken implements Token {
    private String value;

    public ValueToken(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValueToken)) return false;

        ValueToken that = (ValueToken) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }
}
