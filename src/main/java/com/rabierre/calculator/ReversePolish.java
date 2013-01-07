package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 7.
 * Time: 오후 12:31
 * To change this template use File | Settings | File Templates.
 */
public class ReversePolish {
    Stack<Token> stack = new Stack();

    public List<Token> doSomething(List<Token> tokens) {
        List<Token> list = new ArrayList<>();

        for (Token token : tokens) {
            if (token.isOperator()) {
                if (isHigherThanLastOne(token)) {
                    list.add(stack.pop());
                }
                stack.push(token);
            } else {    // token is variable
                list.add(token);
            }
        }

        while (!stack.empty()) {
            list.add(stack.pop());
        }

        return list;
    }

    private boolean isHigherThanLastOne(Token token) {
        if (!stack.empty() ? token.getPriority() > stack.peek().getPriority() : token != null)
            return false;
        return true;
    }
}
