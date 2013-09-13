package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public class Plus extends OperatorToken {
    public Plus() {
        this.operator = Operator.PLUS;
        this.priority = Priority.MEDIUM;
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
        if (left instanceof Double || right instanceof Double)
            return new DoubleValueToken(left.doubleValue() + right.doubleValue());
        else
            return new IntValueToken(left.intValue() + right.intValue());
    }
}
