package com.rabierre.calculator.core;

import com.rabierre.calculator.core.Token;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 7.
 * Time: 오후 2:12
 * To change this template use File | Settings | File Templates.
 */
public class TokenUtil {
    public static void print(List<Token> tokens) {
        for(Token token : tokens) {
            System.out.print(token.getValue());
        }
        System.out.println("");
    }
}
