package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public class Divide extends OperatorToken {
    public Divide() {
        // todo move this
        this.operator = Operator.DIVIDE;
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
    public ValueToken calculate(Number leftOperand, Number rightOperand) {
        if (leftOperand instanceof Double || rightOperand instanceof Double)
            return new DoubleValueToken(leftOperand.doubleValue() / rightOperand.doubleValue());
        else
            return new IntValueToken((leftOperand.intValue() / rightOperand.intValue()));
    }
}
