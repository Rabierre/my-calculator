package com.rabierre.calculator.core;

import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 2. 12.
 * Time: 오전 6:03
 * To change this template use File | Settings | File Templates.
 */
public class ValueTokenFactory {
    public static ValueToken getValueToken(String value) {
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
