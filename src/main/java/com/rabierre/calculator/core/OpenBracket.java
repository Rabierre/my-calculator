package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public class OpenBracket extends OperatorToken {
    public OpenBracket() {
        this.operator = Operator.OPEN_BRACKET;
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
