package com.rabierre.calculator.core;

import java.util.HashMap;

/**
 * @author rabierre
 */
public class OperatorTokenFactory {
    private static HashMap operatorMap = new HashMap();

    static {
        operatorMap.put(Operator.PLUS, new Plus());
        operatorMap.put(Operator.MINUS, new Minus());
        operatorMap.put(Operator.MULTI, new Multiply());
        operatorMap.put(Operator.DIVIDE, new Divide());
        operatorMap.put(Operator.POWER, new Power());
        operatorMap.put(Operator.REMAINDER, new Remainder());
        operatorMap.put(Operator.OPEN_BRACKET, new OpenBracket());
        operatorMap.put(Operator.CLOSE_BRACKET, new CloseBracket());
        // todo trigonometric function ...
    }

    public static OperatorToken getOperator(Operator operator) {
        return (OperatorToken) operatorMap.get(operator);
    }
}
