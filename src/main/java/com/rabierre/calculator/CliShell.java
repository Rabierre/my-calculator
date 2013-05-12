package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;

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
    private static ValueOperatorTokenizer tokenizer = new ValueOperatorTokenizer();
    private static ReversePolishNotation reverseNotation = new ReversePolishNotation();
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            System.out.print("input here : ");
            input = scanner.nextLine();

            if (exit(input)) break;

            // todo 입력은 중위 표현식으로 한정
            List<Token> infixedTokens = tokenizer.tokenize(input);
            //TokenUtil.print(infixedTokens);

            // preprocess execution before calculate
            List<Token> reversePolishedTokens = reverseNotation.reverse(infixedTokens);
            //TokenUtil.print(reversePolishedTokens);

            // calculate
            String result = calculator.run(reversePolishedTokens).toString();
            System.out.println("result is : " + result);
        } while (true);
    }

    private static boolean exit(String arg) {
        return arg != null ? "EXIT".equals(arg.toUpperCase()) : false;
    }
}
