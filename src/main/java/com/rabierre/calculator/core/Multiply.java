package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 4:58
 * To change this template use File | Settings | File Templates.
 */
public class Multiply extends OperatorToken {
    public Multiply() {
        this.operator = Operator.MULTI;
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
        if (leftOperand instanceof Double)
            return new DoubleValueToken(((Double) leftOperand) * ((Double) leftOperand));
        else if (rightOperand instanceof Double)
            return new DoubleValueToken(((Double) leftOperand) * ((Double) rightOperand));
        else
            return new IntValueToken(((Integer) leftOperand) * ((Integer) rightOperand));
    }
}
