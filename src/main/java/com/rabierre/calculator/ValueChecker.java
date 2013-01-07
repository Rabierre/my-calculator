package com.rabierre.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueChecker {

    public static boolean isOperator(char arg) {
        return isOperator(String.valueOf(arg));
    }

    public static boolean isOperator(String arg) {
        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/|\\(|\\)");
        Matcher match = pattern.matcher(arg);

        return match.matches();
    }
}