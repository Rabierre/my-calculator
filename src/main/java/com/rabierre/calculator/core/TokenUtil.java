package com.rabierre.calculator.core;

import com.rabierre.calculator.core.Token;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 7.
 * Time: 오후 2:12
 * To change this template use File | Settings | File Templates.
 */
public class TokenUtil {
    // todo move TokenFactory

    public static void print(List<Token> tokens) {
        for (Token token : tokens) {
            System.out.print(token.toString());
        }
        System.out.println("");
    }

    public static boolean isOperator(String arg) {
        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/|\\(|\\)");   // todo
        Matcher match = pattern.matcher(arg);

        return match.matches();
    }

    public static boolean isOpenBracket(OperatorToken token) {
        return token != null && Operator.OPEN_BRACKET == token.getOperator();
    }

    public static boolean isCloseBracket(OperatorToken token) {
        return token != null && Operator.CLOSE_BRACKET == token.getOperator();
    }
}
