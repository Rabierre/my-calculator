package com.rabierre.calculator;

import com.rabierre.calculator.core.Operator;
import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.ValueToken;

import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author rabierre
 */
public class Calculator {
    private Stack<ValueToken> values = new Stack<>();
    private Stack<OperatorToken> operators = new Stack<>();
    private int bracketCnt;

    public Token run(List<Token> tokens) {
        for (Token token : tokens) {
            if (token instanceof ValueToken) {
                values.push((ValueToken) token);
                continue;
            }

            OperatorToken o = (OperatorToken) token;
            if (Operator.OPEN_BRACKET == o.getOperator()) {
                operators.push(o);
                bracketCnt++;
            } else if (Operator.CLOSE_BRACKET == o.getOperator()) {
                while (operators.peek().getOperator() != Operator.OPEN_BRACKET) {
                    operate();
                }
                operators.pop();
                bracketCnt--;
            } else {
                if(!operators.empty() && o.getPriority() < operators.peek().getPriority()) {
                    operate();
                }
                operators.push(o);
            }
        }

        while (!operators.empty()) {
            operate();
        }

        // todo bracket 개수 검사
        return values.pop();
    }

    private void operate() {
        OperatorToken op = operators.pop();
        ValueToken val2 = values.pop();
        ValueToken val1 = values.pop();

        Number n1 = val1.getValue();
        Number n2 = val2.getValue();
        ValueToken result = op.calculate(n1, n2);
        values.push(result);
    }
}
