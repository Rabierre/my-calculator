package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 5.
 * Time: 오전 11:15
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTokenizer {


    public List<Token> parse(String args) {
        List<Token> values = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        for (char arg : args.toCharArray()) {
            if (ValueChecker.isOperator(arg)) {
                flushBuffer(buffer, values);
                values.add(tokenize(String.valueOf(arg)));
            } else {
                // operands
                buffer.append(arg);
            }
        }

        flushBuffer(buffer, values);

        return values;
    }

    public Token tokenize(String value) {
        if (ValueChecker.isOperator(value)) {
            return new Token(value, true);
        } else {
            return new Token(value, false);
        }
    }

    private void flushBuffer(StringBuffer buffer, List<Token> values) {
        if (buffer.length() > 0) {
            Token token = tokenize(buffer.toString());
            values.add(token);
            buffer.delete(0, buffer.length());
        }
    }
}
