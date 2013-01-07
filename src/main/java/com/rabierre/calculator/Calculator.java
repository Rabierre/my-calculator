package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.TokenUtil;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 8. 23.
 * Time: 오전 3:24
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    private static SimpleTokenizer tokenizer = new SimpleTokenizer();
    private static ReversePolish reverser = new ReversePolish();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            input = scanner.next();

            if (exit(input)) break;

            List<Token> tokens = tokenizer.tokenize(input);
            TokenUtil.print(tokens);

            List<Token> reversePolishedTokens = reverser.doSomething(tokens);
            TokenUtil.print(reversePolishedTokens);
        } while (true);
    }


    private static boolean exit(String arg) {
        if (arg == null) return false;

        if ("EXIT".equals(arg.toUpperCase())) {
            return true;
        }

        return false;
    }
}
