package com.rabierre.calculator;

import com.rabierre.calculator.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rabierre
 */
public class ValueOperatorTokenizer implements Tokenizer {

    @Override
    public List<Token> tokenize(String args) {
        List<Token> tokens = new ArrayList<>();
        StringBuffer operandBuffer = new StringBuffer();

        for (char arg : args.toCharArray()) {
            String value = String.valueOf(arg);

            if (TokenUtil.isOperator(value)) {         // todo guard clause
                addValueToken(operandBuffer, tokens);
                tokens.add(OperatorTokenFactory.getOperator(Operator.getOperator(value)));
            } else {    // operand
                operandBuffer.append(value);
            }
        }

        // last token always has to be a ValueToken.
        addValueToken(operandBuffer, tokens);

        return tokens;
    }

    private void addValueToken(StringBuffer operandBuffer, List<Token> tokens) {
        if (operandBuffer.length() <= 0) {
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
