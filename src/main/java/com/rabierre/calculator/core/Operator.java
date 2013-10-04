package com.rabierre.calculator.core;

import java.util.HashMap;

/**
 * @author rabierre
 */
public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTI("*"),
    DIVIDE("/"),
    POWER("^"),
    REMAINDER("%"),
    OPEN_PARENTHESIS("("),
    CLOSE_PARENTHESIS(")");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static HashMap mappingTable = new HashMap();

    static {
        mappingTable.put("+", PLUS);
        mappingTable.put("-", MINUS);
        mappingTable.put("*", MULTI);
        mappingTable.put("/", DIVIDE);
        mappingTable.put("^", POWER);
        mappingTable.put("%", REMAINDER);
        mappingTable.put("(", OPEN_PARENTHESIS);
        mappingTable.put(")", CLOSE_PARENTHESIS);
    }

    public static Operator getOperator(String value) {
        return (Operator) mappingTable.get(value);
    }
}
