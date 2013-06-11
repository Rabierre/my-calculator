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
            return new DoubleValueToken(((Double) left) + ((Double) right));
        else
            return new IntValueToken(((Integer) left) + ((Integer) right));
    }
}
