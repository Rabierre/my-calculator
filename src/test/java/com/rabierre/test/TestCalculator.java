package com.rabierre.test;

import com.rabierre.calculator.Calculator;
import com.rabierre.calculator.ReversePolishNotation;
import com.rabierre.calculator.core.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.rabierre.util.TokenUtil.createTokens;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
// todo test case rename
public class TestCalculator {
    @Test
    public void testCalculate() {
        // 1+2 -> 12+
        List<Token> tokens = createTokens("1 2 +");

        Token actual = new Calculator().run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat(actual, is((Token)new IntValueToken(3)));
    }

    @Test
    public void testCalculate2() {
        // 1+2+3 -> 123++
        List<Token> tokens = createTokens("1 2 3 + +");

        Token actual = new Calculator().run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat(actual, is((Token)new IntValueToken(6)));
    }

    @Test
    public void testCalculate3() {
        // (1+2)/3 -> 12+3/
        List<Token> tokens = createTokens("1 2 + 3 /");

        Token actual = new Calculator().run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat(actual, is((Token)new IntValueToken(1)));
    }

    @Test
    public void testCalculate4() {
        // 1*2/3 -> 12*3/
        List<Token> reversed = createTokens("1 2 * 3 /");

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new IntValueToken(0)));
    }

    @Test
    public void testCalculate5() {
        // (1+2)/2.0 -> 12+2.0/
        List<Token> reversed = createTokens("1 2 + 2.0 /");

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(1.5)));
    }

    @Test
    public void testCalculate6() {
        // 2^2 -> 2 2 ^
        List<Token> reversed = createTokens("2 2 ^");

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(4.0)));
    }

    @Test
    public void testCalculate7() {
        // 7%3 -> 73%
        List<Token> reversed = createTokens("7 3 %");         // todo createReverseTokens

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new IntValueToken(1)));
    }

    @Test
    public void testCalculate8() {
        // 7%3.0 -> 7 3.0 %
        List<Token> reversed = createTokens("7 3.0 %");

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(1.0)));
    }
}
