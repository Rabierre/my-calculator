package com.rabierre.calculator.core;

/**
 * @author rabierre
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
