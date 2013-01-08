package com.rabierre.calculator;

import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.ValueToken;

import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 7.
 * Time: 오후 10:40
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {

    public Token run(List<Token> refined) {
        Stack<Token> stack = new Stack();

        for (Token token : refined) {
            // if variable or constant value
            if (token instanceof ValueToken) {
                stack.push(token);
                continue;
            }

            // if operator
            if (stack.empty()) return token;
            if (stack.size() < 2) return token;

            Token operand1 = stack.pop();
            Token operand2 = stack.pop();
            Token result = ((OperatorToken) token).calculate(operand1, operand2);

            stack.push(result);
        }

        return stack.pop();
    }
}
