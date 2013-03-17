package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 4:59
 * To change this template use File | Settings | File Templates.
 */
public class Power extends OperatorToken {
    public Power() {
        this.operator = Operator.POWER;
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
    public ValueToken calculate(Number left, Number right) {
        return new DoubleValueToken( Math.pow(left.doubleValue(), right.doubleValue()) );
    }
}
