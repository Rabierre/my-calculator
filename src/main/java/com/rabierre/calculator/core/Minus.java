package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 4:57
 * To change this template use File | Settings | File Templates.
 */
public class Minus extends OperatorToken {
    public Minus() {
        this.operator = Operator.MINUS;
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
    public ValueToken calculate(Number leftOperand, Number rightOperand) {
        if (leftOperand instanceof Double)
            return new DoubleValueToken(((Double) leftOperand) - ((Double) rightOperand));
        else if (rightOperand instanceof Double)
            return new DoubleValueToken(((Double) leftOperand) - ((Double) rightOperand));
        else
            return new IntValueToken(((Integer) leftOperand) - ((Integer) rightOperand));
    }
}
