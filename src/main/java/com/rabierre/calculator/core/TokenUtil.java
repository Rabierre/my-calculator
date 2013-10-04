package com.rabierre.calculator.core;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rabierre
 */
public class TokenUtil {
    // todo move TokenFactory

    public static void print(List<Token> tokens) {
        // todo move list of tokens to equation class
        for (Token token : tokens) {
            System.out.print(token.toString());
        }
        System.out.println("");
    }

    public static boolean isOperator(String arg) {
        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/|\\%|\\^|\\(|\\)");   // todo move to OperatorTokenFactory
        Matcher match = pattern.matcher(arg);

        return match.matches();
    }

    public static boolean isOpenBracket(OperatorToken token) {
        return token != null && Operator.OPEN_PARENTHESIS == token.getOperator();
    }

    public static boolean isCloseBracket(OperatorToken token) {
        return token != null && Operator.CLOSE_PARENTHESIS == token.getOperator();
    }
}
