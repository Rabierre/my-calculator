package com.rabierre.calculator;

import com.rabierre.calculator.core.*;

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
                addValueToken(operandBuffer, tokens);
                tokens.add(OperatorSet.getOperator(Operator.getOperator(value)));
            } else {    // operand
                operandBuffer.append(value);
            }
        }

        // last token always has to be a ValueToken.
        addValueToken(operandBuffer, tokens);

        return tokens;
    }

    private void addValueToken(StringBuffer operandBuffer, List<Token> tokens) {
        if (operandBuffer.length() <= 0) {  // ignore
            return;
        }

        ValueToken token = ValueTokenFactory.getValueToken(operandBuffer.toString());
        tokens.add(token);

        clearBuffer(operandBuffer);
    }

    private void clearBuffer(StringBuffer operandBuffer) {
        operandBuffer.delete(0, operandBuffer.length());
    }
}
