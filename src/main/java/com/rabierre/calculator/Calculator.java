package com.rabierre.calculator;

import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.ValueToken;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 7.
 * Time: 오후 10:40
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public void run(List<Token> refined) {
        // todo
        for (int i = 0; i < refined.size() - 2; i++) {
            int first = i;
            int second = i + 1;
            int third = i + 2;

            if (!(refined.get(first) instanceof ValueToken) || !(refined.get(second) instanceof ValueToken)) {
                // todo invalid formula?
                return;
            }

            if (refined.get(third) instanceof OperatorToken) {
                ((OperatorToken) refined.get(third)).calculate(refined.get(first), refined.get(second));
            } else {
                // shift, recursive
                run(refined.subList(first, refined.size()));    // todo fix this
            }
        }
    }

    public void doCalculate(Token operand1, Token operand2, OperatorToken operator) {
        // todo
        // do operand1 operator operand2
    }
}
