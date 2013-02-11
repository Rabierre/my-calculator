package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 4:58
 * To change this template use File | Settings | File Templates.
 */
public class Divide extends OperatorToken {
    public Divide() {
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
        if (leftOperand instanceof Double)
            return new DoubleValueToken(( leftOperand.doubleValue() / rightOperand.doubleValue()));
        else if (rightOperand instanceof Double)
            return new DoubleValueToken(leftOperand.doubleValue() / rightOperand.doubleValue());
        else
            return new IntValueToken((leftOperand.intValue() / rightOperand.intValue()));
    }
}
