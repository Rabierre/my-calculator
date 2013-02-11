package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 8.
 * Time: 오후 2:55
 * To change this template use File | Settings | File Templates.
 */
public class IntValueToken extends ValueToken {
    private Integer value;

    public IntValueToken(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public ValueToken operate(OperatorToken operator, Token operand) {
        // todo test
        if (operand instanceof DoubleValueToken)
            return operate(operator.getOperator(), ((DoubleValueToken) operand).getValue());
        else
            return operate(operator.getOperator(), ((IntValueToken) operand).getValue());
    }

    private ValueToken operate(Operator operator, Double operand) {
        // todo test
        return OperatorSet.getOperator(operator).calculate(value, operand);
    }

    private ValueToken operate(Operator operator, Integer operand) {
        // todo test
        return OperatorSet.getOperator(operator).calculate(value, operand);
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
