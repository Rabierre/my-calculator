package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public abstract class OperatorToken implements Token {
    protected Operator operator;
    protected Priority priority;

    abstract public int getPriority();

    abstract public Operator getOperator();

    public abstract ValueToken calculate(Number val1, Number val2);

    public boolean isHighPriorityThan(OperatorToken peek) {
        if (!(peek instanceof OperatorToken)) return false; // or error?

        return this.priority.getValue() >= peek.getPriority();
    }

    @Override
    public String toString() {
        return operator.getValue();
    }
}
