package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 4:57
 * To change this template use File | Settings | File Templates.
 */
public class Remainder extends OperatorToken {
    public Remainder() {
        this.operator = Operator.REMAINDER;
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
        if (left instanceof Double || right instanceof Double)
            return new DoubleValueToken(left.doubleValue() % right.doubleValue());
        else
            return new IntValueToken(left.intValue() % right.intValue());
    }
}
