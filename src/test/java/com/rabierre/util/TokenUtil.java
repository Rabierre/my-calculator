package com.rabierre.util;

import com.rabierre.calculator.SimpleTokenizer;
import com.rabierre.calculator.core.Token;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 5. 13.
 * Time: 오전 12:46
 * To change this template use File | Settings | File Templates.
 */
public class TokenUtil {

    public static List<Token> createMockTokens(String equation) {
        return new SimpleTokenizer().tokenize(equation);
    }
}
