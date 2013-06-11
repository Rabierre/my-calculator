package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public class DoubleValueToken extends ValueToken{
    private Double value;

    public DoubleValueToken(Double value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleValueToken)) return false;

        DoubleValueToken that = (DoubleValueToken) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }
}
