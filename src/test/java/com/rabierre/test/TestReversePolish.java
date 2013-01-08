package com.rabierre.test;

import com.rabierre.calculator.ReversePolishNotation;
import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.TokenUtil;
import com.rabierre.calculator.core.ValueToken;
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
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("1"));
        expect.add(new ValueToken("2"));
        expect.add(new OperatorToken("+"));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("2"));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse2() {
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("1"));
        expect.add(new ValueToken("2"));
        expect.add(new ValueToken("3"));
        expect.add(new OperatorToken("+"));
        expect.add(new OperatorToken("+"));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("3"));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse3() {
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("1"));
        expect.add(new ValueToken("2"));
        expect.add(new ValueToken("3"));
        expect.add(new OperatorToken("/"));
        expect.add(new OperatorToken("+"));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken("/"));
        tokens.add(new ValueToken("3"));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse4() {
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("1"));
        expect.add(new ValueToken("2"));
        expect.add(new OperatorToken("+"));
        expect.add(new ValueToken("3"));
        expect.add(new OperatorToken("/"));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new OperatorToken("("));
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken(")"));
        tokens.add(new OperatorToken("/"));
        tokens.add(new ValueToken("3"));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse5() {
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("1"));
        expect.add(new ValueToken("2"));
        expect.add(new OperatorToken("*"));
        expect.add(new ValueToken("3"));
        expect.add(new OperatorToken("/"));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new OperatorToken("("));
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("*"));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken(")"));
        tokens.add(new OperatorToken("/"));
        tokens.add(new ValueToken("3"));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse6() {
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("1"));
        expect.add(new ValueToken("2"));
        expect.add(new ValueToken("3"));
        expect.add(new OperatorToken("+"));
        expect.add(new ValueToken("4"));
        expect.add(new OperatorToken("/"));
        expect.add(new OperatorToken("*"));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("*"));
        tokens.add(new OperatorToken("("));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("3"));
        tokens.add(new OperatorToken(")"));
        tokens.add(new OperatorToken("/"));
        tokens.add(new ValueToken("4"));

        List<Token> actual = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSimpleReverseException() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new OperatorToken("("));
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("2"));

        List<Token> actual = new ReversePolishNotation().process(tokens);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSimpleReverseException2() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken(")"));

        List<Token> actual = new ReversePolishNotation().process(tokens);
    }
}
