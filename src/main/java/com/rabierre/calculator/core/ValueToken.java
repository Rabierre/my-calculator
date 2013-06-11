package com.rabierre.calculator.core;

/**
 * @author rabierre
 */
public abstract class ValueToken implements Token{
    // todo has type: int or double
    abstract public Number getValue();
}
