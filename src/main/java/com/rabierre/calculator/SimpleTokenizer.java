package com.rabierre.calculator;

import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.TokenUtil;
import com.rabierre.calculator.core.ValueToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 5.
 * Time: 오전 11:15
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTokenizer implements Tokenizer {

    @Override
    public List<Token> tokenize(String args) {
        List<Token> tokens = new ArrayList<>();
        StringBuffer operandBuffer = new StringBuffer();

        for (char arg : args.toCharArray()) {
            String value = String.valueOf(arg);

            if (TokenUtil.isOperator(value)) {
                flushBuffer(operandBuffer, tokens);
                tokens.add(new OperatorToken(value));
            } else {    // operand
                operandBuffer.append(value);
            }
        }

        flushBuffer(operandBuffer, tokens);

        return tokens;
    }

    private void flushBuffer(StringBuffer operandBuffer, List<Token> tokens) {
        if (operandBuffer.length() <= 0) {
            return;
        }

        tokens.add(new ValueToken(operandBuffer.toString()));
        operandBuffer.delete(0, operandBuffer.length());
    }
}
