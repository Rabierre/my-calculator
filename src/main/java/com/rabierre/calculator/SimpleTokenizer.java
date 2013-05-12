package com.rabierre.calculator;

import com.rabierre.calculator.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 5. 13.
 * Time: 오전 12:27
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTokenizer implements Tokenizer {
    public List<Token> tokenize(String equation) {
        String[] split = equation.split("\\s");
        List<Token> tokens = new ArrayList<>();

        for (String value : split) {
            if(TokenUtil.isOperator(value))
                tokens.add(OperatorTokenFactory.getOperator(Operator.getOperator(value)));
            else
                tokens.add(ValueTokenFactory.getValueToken(value));
        }

        return tokens;
    }
}
