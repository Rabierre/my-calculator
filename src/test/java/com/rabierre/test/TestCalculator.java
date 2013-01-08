package com.rabierre.test;

import com.rabierre.calculator.Calculator;
import com.rabierre.calculator.ReversePolishNotation;
import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.TokenUtil;
import com.rabierre.calculator.core.ValueToken;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testCalculate() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken("+"));

        Token actual = new Calculator().run(tokens);

        TokenUtil.print(tokens);
        System.out.println("result : " + actual.getValue());

        Token expect = new ValueToken("3.0");
        assertThat(actual, is(expect));
    }

    @Test
    public void testCalculate2() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new ValueToken("2"));
        tokens.add(new ValueToken("3"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new OperatorToken("+"));

        Token actual = new Calculator().run(tokens);

        TokenUtil.print(tokens);
        System.out.println("result : " + actual.getValue());

        Token expect = new ValueToken("6.0");
        assertThat(actual, is(expect));
    }

    @Test
    public void testCalculate3() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new ValueToken("1"));
        tokens.add(new ValueToken("2"));
        tokens.add(new OperatorToken("+"));
        tokens.add(new ValueToken("3"));
        tokens.add(new OperatorToken("/"));

        Token actual = new Calculator().run(tokens);

        TokenUtil.print(tokens);
        System.out.println("result : " + actual.getValue());

        Token expect = new ValueToken("1.0");
        assertThat(actual, is(expect));
    }

    @Test
    public void testCalculate4() {
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
}
