package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.TokenUtil;

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
public class ReversePolishNotation {
    Stack<Token> stack = new Stack();

    public List<Token> process(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        int bracketCount = 0;

        for (Token token : tokens) {
            if (token.isOperator()) {

                if (TokenUtil.isOpenBracket(token)) {
                    bracketCount++;
                } else if (TokenUtil.isCloseBracket(token)) {
                    bracketCount--;

                    try {
                        while (!TokenUtil.isOpenBracket(stack.peek())) {
                            list.add(stack.pop());
                        }
                        stack.pop();
                    } catch (Exception e) {
                        throw new IllegalArgumentException("there are " + Math.abs(bracketCount) + " open bracket is missing.");
                    }
                    continue;

                } else if (isPriorityLower(token)) {
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

        checkBrackets(bracketCount);

        return list;
    }

    private void checkBrackets(int bracketCount) {
        if (bracketCount > 0) {
            throw new IllegalArgumentException("there are " + bracketCount + " close bracket is missing.");
        } else if (bracketCount < 0) {
            throw new IllegalArgumentException("there are " + Math.abs(bracketCount) + " open bracket is missing.");
        }
    }

    private boolean isPriorityLower(Token token) {
        if (!stack.empty() ? token.getPriority() >= stack.peek().getPriority() : token != null)
            return false;
        return true;
    }
}
