package com.rabierre.test;

import com.rabierre.calculator.Calculator;
import com.rabierre.calculator.core.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.rabierre.util.TokenUtil.createMockTokens;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author rabierre
 */
// todo test case rename
public class TestCalculator {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    // todo refactor here
    @Test
    public void testCalculate() {
        // 1+2 -> 12+
        List<Token> tokens = createMockTokens("1 2 +");

        Token actual = calculator.run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat(actual, is((Token)new IntValueToken(3)));
    }

    @Test
    public void testCalculate2() {
        // 1+2+3 -> 123++
        List<Token> tokens = createMockTokens("1 2 3 + +");

        Token actual = calculator.run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat((IntValueToken) actual, is(new IntValueToken(6)));
    }

    @Test
    public void testCalculate3() {
        // (1+2)/3 -> 12+3/
        List<Token> tokens = createMockTokens("1 2 + 3 /");

        Token actual = calculator.run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat(actual, is((Token)new IntValueToken(1)));
    }

    @Test
    public void testCalculate4() {
        // 1*2/3 -> 12*3/
        List<Token> reversed = createMockTokens("1 2 * 3 /");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new IntValueToken(0)));
    }

    @Test
    public void testCalculate5() {
        // (1+2)/2.0 -> 12+2.0/
        List<Token> reversed = createMockTokens("1 2 + 2.0 /");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(1.5)));
    }

    @Test
    public void testCalculate6() {
        // 2^2 -> 2 2 ^
        List<Token> reversed = createMockTokens("2 2 ^");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(4.0)));
    }

    @Test
    public void testCalculate7() {
        // 7%3 -> 73%
        List<Token> reversed = createMockTokens("7 3 %");         // todo createReverseTokens

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new IntValueToken(1)));
    }

    @Test
    public void testCalculate8() {
        // 7%3.0 -> 7 3.0 %
        List<Token> reversed = createMockTokens("7 3.0 %");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(1.0)));
    }
}
