package com.rabierre.calculator;

import com.rabierre.calculator.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rabierre
 */
public class ReversePolishNotation implements Notation {
    private Stack<Token> stack = new Stack();

    @Override
    public List<Token> reverse(List<Token> tokens) {
        List<Token> reversed = new ArrayList<>();
        int bracketCount = 0;

        for (Token token : tokens) {
            if (token instanceof ValueToken) {  // token is variable or constant value
                reversed.add(token);
                continue;
            }

            OperatorToken operator = (OperatorToken) token;
            if (TokenUtil.isOpenBracket(operator)) {
                bracketCount++;
            } else if (TokenUtil.isCloseBracket(operator)) {
                while (!stack.empty()) {
                    if (TokenUtil.isOpenBracket((OperatorToken) stack.peek())) {
                        stack.pop();
                        break;
                    }
                    reversed.add(stack.pop());
                }

                bracketCount--;
                continue;

            } else if (!stack.empty() && !((OperatorToken) token).isHighPriorityThan((OperatorToken)stack.peek())) {
                reversed.add(stack.pop());
            }
            stack.push(token);
        }

        while (!stack.empty()) {
            reversed.add(stack.pop());
        }

        checkBrackets(bracketCount);

        return reversed;
    }

    private void checkBrackets(int bracketCount) {
        if (bracketCount > 0) {
            throw new IllegalArgumentException("there are " + bracketCount + " close bracket is missing.");
        } else if (bracketCount < 0) {
            throw new IllegalArgumentException("there are " + Math.abs(bracketCount) + " open bracket is missing.");
        }
    }
}
