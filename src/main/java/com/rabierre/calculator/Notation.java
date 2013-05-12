package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 13. 1. 7.
 * Time: 오후 10:38
 * To change this template use File | Settings | File Templates.
 */
public interface Notation {
    List<Token> reverse(List<Token> tokens);
}
