package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 8.
 * Time: 오후 2:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class OperatorToken implements Token {
    protected Operator operator;
    protected Priority priority;

    abstract public int getPriority();

    abstract public Operator getOperator();

    public abstract ValueToken calculate(Number leftValue, Number rightValue);

    public ValueToken calculate(ValueToken leftOperand, ValueToken rightOperand) {
        Number leftValue, rightValue;

        // left
        // todo extract
        if (leftOperand instanceof DoubleValueToken)
            leftValue = ((DoubleValueToken) leftOperand).getValue();
        else
            leftValue = ((IntValueToken) leftOperand).getValue();

        // right
        if (rightOperand instanceof DoubleValueToken)
            rightValue = ((DoubleValueToken) rightOperand).getValue();
        else
            rightValue = ((IntValueToken) rightOperand).getValue();

        return calculate(leftValue, rightValue);
    }

    public boolean isHighPriorityThan(OperatorToken peek) {
        if (!(peek instanceof OperatorToken)) return false; // or error?

        return this.priority.getValue() >= peek.getPriority();
    }

    @Override
    public String toString() {
        return operator.getValue();
    }
}
