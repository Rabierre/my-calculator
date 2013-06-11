package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public class Power extends OperatorToken {
    public Power() {
        this.operator = Operator.POWER;
        this.priority = Priority.HIGH;
    }
    @Override
    public int getPriority() {
        return this.priority.getValue();
    }

    @Override
    public Operator getOperator() {
        return this.operator;
    }

    @Override
    public ValueToken calculate(Number left, Number right) {
        return new DoubleValueToken( Math.pow(left.doubleValue(), right.doubleValue()) );
    }
}
