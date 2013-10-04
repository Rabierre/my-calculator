package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public class CloseParenthesis extends OperatorToken{
    public CloseParenthesis(){
        this.operator = Operator.CLOSE_PARENTHESIS;
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
        return null;  // todo throw exception?
    }
}
