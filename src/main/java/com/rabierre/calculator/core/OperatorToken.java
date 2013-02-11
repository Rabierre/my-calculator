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

    public abstract ValueToken calculate(Number value, Number operand);

    public ValueToken calculate(ValueToken leftOperand, ValueToken rightOperand) {
        Number leftValue, rightValue;

        if (leftOperand instanceof DoubleValueToken)
            leftValue = ((DoubleValueToken) leftOperand).getValue();
        else
            leftValue = ((IntValueToken) leftOperand).getValue();

        if (rightOperand instanceof DoubleValueToken)
            rightValue = ((DoubleValueToken) rightOperand).getValue();
        else
            rightValue = ((IntValueToken) rightOperand).getValue();

        return calculate(leftValue, rightValue);
    }

    public boolean isHighPriorityThan(OperatorToken peek) {
        if (!(peek instanceof OperatorToken)) return false; // or error?

        return this.priority.getValue() >= ((OperatorToken) peek).getPriority();
    }

    @Override
    public String toString() {
        return operator.getValue();
    }

    /*private String value;
    private int priority;

    public OperatorToken(String value) {
        this.value = value;
        this.priority = orderPriority();
    }

    private int orderPriority() {
        switch (value) {
            case "(":
            case ")":
                return Priority.LOW.getValue();
            case "+":
            case "-":
                return Priority.MEDIUM.getValue();
            case "*":
            case "/":
            case "^":
                return Priority.HIGH.getValue();
            default:
                return Priority.NONE.getValue();
        }
    }

    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperatorToken)) return false;

        OperatorToken that = (OperatorToken) o;

        if (priority != that.priority) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    public Token calculate(Token token1, Token token2) {
        return null;
    }*/
}
