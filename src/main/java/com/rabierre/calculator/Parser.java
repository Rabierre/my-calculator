package com.rabierre.calculator;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static void parse(String[] args) {
        for (String arg : args) {
            for (int i = 0; i < arg.length(); i++) {

                char charAt = arg.charAt(i);
                String single = String.valueOf(charAt);

                try {
                    int parsed = Integer.decode(single);
                    System.out.println("OPERAND : " + parsed);

                } catch (Exception e) {
                    Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/");
                    Matcher match = pattern.matcher(single);
                    boolean isMatch = match.find();
                    if (isMatch) {
                        System.out.println("OPERATOR : " + single);
                    } else {
                        throw new IllegalArgumentException("수식에 잘못된 파라미터가 있습니다. : " + single + " at " + arg);
                    }
                }
            }
        }
    }
}