package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 4:17
 * To change this template use File | Settings | File Templates.
 */
public class DoubleValueToken extends ValueToken{
    private Double value;

    public DoubleValueToken(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public Token operate(OperatorToken operator, Token operand) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
