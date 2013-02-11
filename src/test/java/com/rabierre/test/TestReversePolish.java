package com.rabierre.test;

import com.rabierre.calculator.ReversePolishNotation;
import com.rabierre.calculator.core.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
public class TestReversePolish {
    @Test
    public void testSimpleReverse() {
        // 12+
        List<Token> expect = new ArrayList<>();
        expect.add(new IntValueToken(1));
        expect.add(new IntValueToken(2));
        expect.add(OperatorSet.getOperator(Operator.PLUS));

        // 1+2
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(2));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println();
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse2() {
        // 123++
        List<Token> expect = new ArrayList<>();
        expect.add(new IntValueToken(1));
        expect.add(new IntValueToken(2));
        expect.add(new IntValueToken(3));
        expect.add(OperatorSet.getOperator(Operator.PLUS));
        expect.add(OperatorSet.getOperator(Operator.PLUS));

        // 1+2+3
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(2));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(3));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println();
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse3() {
        // 123/+
        List<Token> expect = new ArrayList<>();
        expect.add(new IntValueToken(1));
        expect.add(new IntValueToken(2));
        expect.add(new IntValueToken(3));
        expect.add(OperatorSet.getOperator(Operator.DIVIDE));
        expect.add(OperatorSet.getOperator(Operator.PLUS));

        // 1+2/3
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(2));
        tokens.add(OperatorSet.getOperator(Operator.DIVIDE));
        tokens.add(new IntValueToken(3));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println();
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse4() {
        // 12+3/
        List<Token> expect = new ArrayList<>();
        expect.add(new IntValueToken(1));
        expect.add(new IntValueToken(2));
        expect.add(OperatorSet.getOperator(Operator.PLUS));
        expect.add(new IntValueToken(3));
        expect.add(OperatorSet.getOperator(Operator.DIVIDE));

        // (1+2)/3
        List<Token> tokens = new ArrayList<>();
        tokens.add(OperatorSet.getOperator(Operator.OPEN_BRACKET));
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(2));
        tokens.add(OperatorSet.getOperator(Operator.CLOSE_BRACKET));
        tokens.add(OperatorSet.getOperator(Operator.DIVIDE));
        tokens.add(new IntValueToken(3));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println();
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse5() {
        // 12*3/
        List<Token> expect = new ArrayList<>();
        expect.add(new IntValueToken(1));
        expect.add(new IntValueToken(2));
        expect.add(OperatorSet.getOperator(Operator.MULTI));
        expect.add(new IntValueToken(3));
        expect.add(OperatorSet.getOperator(Operator.DIVIDE));

        // (1*2)/3
        List<Token> tokens = new ArrayList<>();
        tokens.add(OperatorSet.getOperator(Operator.OPEN_BRACKET));
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.MULTI));
        tokens.add(new IntValueToken(2));
        tokens.add(OperatorSet.getOperator(Operator.CLOSE_BRACKET));
        tokens.add(OperatorSet.getOperator(Operator.DIVIDE));
        tokens.add(new IntValueToken(3));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println();
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse6() {
        // 123+4/*
        List<Token> expect = new ArrayList<>();
        expect.add(new IntValueToken(1));
        expect.add(new IntValueToken(2));
        expect.add(new IntValueToken(3));
        expect.add(OperatorSet.getOperator(Operator.PLUS));
        expect.add(new IntValueToken(4));
        expect.add(OperatorSet.getOperator(Operator.DIVIDE));
        expect.add(OperatorSet.getOperator(Operator.MULTI));

        // 1*(2+3)/4
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.MULTI));
        tokens.add(OperatorSet.getOperator(Operator.OPEN_BRACKET));
        tokens.add(new IntValueToken(2));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(3));
        tokens.add(OperatorSet.getOperator(Operator.CLOSE_BRACKET));
        tokens.add(OperatorSet.getOperator(Operator.DIVIDE));
        tokens.add(new IntValueToken(4));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println();
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSimpleReverseException() {
        // (1+2
        List<Token> tokens = new ArrayList<>();
        tokens.add(OperatorSet.getOperator(Operator.OPEN_BRACKET));
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(2));

        List<Token> actual = new ReversePolishNotation().process(tokens);
    }

    @Test(expected = IllegalArgumentException.class)
    // 1+2)
    public void testSimpleReverseException2() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(2));
        tokens.add(OperatorSet.getOperator(Operator.CLOSE_BRACKET));

        List<Token> actual = new ReversePolishNotation().process(tokens);
    }
}
