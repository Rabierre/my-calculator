package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 4:57
 * To change this template use File | Settings | File Templates.
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
    public ValueToken calculate(Number rightOperand, Number leftOperand) {
        if (rightOperand instanceof Double)
            return new DoubleValueToken(((Double) rightOperand) + ((Double) leftOperand));
        else if (leftOperand instanceof Double)
            return new DoubleValueToken(((Double) rightOperand) + ((Double) leftOperand));
        else
            return new IntValueToken(((Integer) rightOperand) + ((Integer) leftOperand));
    }
}
