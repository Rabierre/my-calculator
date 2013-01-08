package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;

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

            if (refined.get(first).isOperator() || refined.get(second).isOperator()) {
                // todo
                // invalid formula
                return;
            }

            if (refined.get(third).isOperator()) {
                doCalculate(first, second, third);
            } else if (!refined.get(third).isOperator()) {
                // shift, recursive
                run(refined.subList(first, refined.size()));
            }

        }
    }

    public void doCalculate(int operand1, int operand2, int operator) {
        // todo
        // do operand1 operator operand2
    }
}
