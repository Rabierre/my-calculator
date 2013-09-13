package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;

import java.util.List;
import java.util.Scanner;

/**
 * @author rabierre
 */
public class CliShell {
    private static ValueOperatorTokenizer tokenizer = new ValueOperatorTokenizer();
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            System.out.print("input here : ");
            input = scanner.nextLine();

            // todo input check
            if (exit(input)) break;

            // INFO 입력은 중위 표현식으로 한정
            List<Token> infixTokens = tokenizer.tokenize(input);

            // change into reverse notation for easy calculate in machine side
            //List<Token> reversePolishedTokens = reverseNotation.reverse(infixTokens);

            String result = calculator.run(infixTokens).toString();
            System.out.println("result is : " + result);
        } while (true);
    }

    private static boolean exit(String arg) {
        return arg != null ? "EXIT".equals(arg.toUpperCase()) : false;
    }
}
