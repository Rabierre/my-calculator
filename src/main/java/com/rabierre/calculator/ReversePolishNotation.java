package com.rabierre.calculator;

import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.TokenUtil;
import com.rabierre.calculator.core.ValueToken;

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
public class ReversePolishNotation implements Notation {
    Stack<Token> stack = new Stack();

    @Override
    public List<Token> process(List<Token> tokens) {
        List<Token> list = new ArrayList<>();
        int bracketCount = 0;

        for (Token token : tokens) {
            if (token instanceof ValueToken) {  // token is variable or constant value
                list.add(token);
                continue;
            }

            if (TokenUtil.isOpenBracket(token)) {
                bracketCount++;
            } else if (TokenUtil.isCloseBracket(token)) {
                while (!stack.empty()) {
                    if (TokenUtil.isOpenBracket(stack.peek())) {
                        stack.pop();
                        break;
                    }
                    list.add(stack.pop());
                }

                bracketCount--;
                continue;

            } else if (!stack.empty() && !((OperatorToken) token).isHighPriorityThan(stack.peek())) {
                list.add(stack.pop());
            }
            stack.push(token);
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
}
