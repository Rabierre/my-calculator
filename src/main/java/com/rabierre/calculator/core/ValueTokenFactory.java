package com.rabierre.calculator.core;

import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rabierre
 */
public class ValueTokenFactory {
    public static ValueToken getValueToken(String value) {
        value = value.trim();

        if (isDouble(value))
            return new DoubleValueToken(Double.parseDouble(value));
        else
            return new IntValueToken(Integer.parseInt(value));
    }

    private static boolean isDouble(String value) {
        Pattern pattern = Pattern.compile("[0-9]+\\.[0-9]+");   // todo
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}