package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public class IntValueToken extends ValueToken {
    private Integer value;

    public IntValueToken(Integer value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntValueToken)) return false;

        IntValueToken that = (IntValueToken) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
