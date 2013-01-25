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
public class CliShell {
    private static SimpleTokenizer tokenizer = new SimpleTokenizer();
    private static ReversePolishNotation reverser = new ReversePolishNotation();
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            System.out.print("input here : ");
            input = scanner.nextLine();

            if (exit(input)) break;

            // tokenize first
            List<Token> tokens = tokenizer.tokenize(input);
            TokenUtil.print(tokens);

            // preprocess execution before calculate
            List<Token> reversePolishedTokens = reverser.process(tokens);
            TokenUtil.print(reversePolishedTokens);

            // calculate
            String result = calculator.run(reversePolishedTokens).getValue();
            System.out.println("result is : " + result);
        } while (true);
    }

    private static boolean exit(String arg) {
        return arg != null ? "EXIT".equals(arg.toUpperCase()) : false;
    }
}
