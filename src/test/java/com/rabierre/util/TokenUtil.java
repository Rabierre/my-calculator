package com.rabierre.util;

import com.rabierre.calculator.SimpleTokenizer;
import com.rabierre.calculator.core.Token;

import java.util.List;

/**
 * @author rabierre
 */
public class TokenUtil {

    public static List<Token> createMockTokens(String equation) {
        return new SimpleTokenizer().tokenize(equation);
    }
}
