package com.rabierre.calculator;

import com.rabierre.calculator.core.Token;

import java.util.List;

/**
 * @author rabierre
 */
public interface Notation {
    List<Token> reverse(List<Token> tokens);
}
