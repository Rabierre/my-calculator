package com.rabierre.calculator.core;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 6:17
 * To change this template use File | Settings | File Templates.
 */
public class CloseBracket extends OperatorToken{
    public CloseBracket(){
        this.operator = Operator.CLOSE_BRACKET;
        this.priority = Priority.LOW;
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
    public ValueToken calculate(Number value, Number operand) {
        return null;
    }
}
