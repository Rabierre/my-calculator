package com.rabierre.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 5.
 * Time: 오전 11:15
 * To change this template use File | Settings | File Templates.
 */
public class ValueCollector {

    public List<String> parse(String args) {
        List<String> values = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        for (char arg : args.toCharArray()) {
            if (isOperator(arg)) {
                bufferFlush(buffer, values);
                values.add(String.valueOf(arg));
            } else {
                // operands
                buffer.append(arg);
            }
        }

        bufferFlush(buffer, values);

        return values;
    }

    private void bufferFlush(StringBuffer buffer, List<String> values) {
        if (buffer.length() > 0) {
            values.add(buffer.toString());
            buffer.delete(0, buffer.length());
        }
    }

    private boolean isOperator(char arg) {
        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/|\\(|\\)");
        Matcher match = pattern.matcher(String.valueOf(arg));

        return match.matches();
    }
}
