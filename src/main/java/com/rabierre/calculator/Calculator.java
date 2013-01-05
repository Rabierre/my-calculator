package com.rabierre.calculator;

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
    private static ValueCollector valueCollector = new ValueCollector();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            input = scanner.next();

            if (exit(input)) break;

            List<String> values = valueCollector.parse(input);
            printList(values);
        } while (true);
    }

    private static void printList(List<String> values) {
        for (String value : values) {
            System.out.println(value + "\n");
        }
    }

    private static boolean exit(String arg) {
        if (arg == null) return false;

        if ("EXIT".equals(arg.toUpperCase())) {
            return true;
        }

        return false;
    }
}
