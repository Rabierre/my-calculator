package com.rabierre.calculator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rabierre
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
        if (leftOperand instanceof Double || rightOperand instanceof Double)
            return new DoubleValueToken(leftOperand.doubleValue() * rightOperand.doubleValue());
        else
            return new IntValueToken(leftOperand.intValue() * rightOperand.intValue());
    }
}
