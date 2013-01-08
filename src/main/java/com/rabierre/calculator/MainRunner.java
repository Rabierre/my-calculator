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
public class MainRunner {
    private static SimpleTokenizer tokenizer = new SimpleTokenizer();
    private static ReversePolishNotation reverser = new ReversePolishNotation();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            input = scanner.nextLine();

            if (exit(input)) break;

            List<Token> tokens = tokenizer.tokenize(input);
            TokenUtil.print(tokens);

            List<Token> reversePolishedTokens = reverser.process(tokens);
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
