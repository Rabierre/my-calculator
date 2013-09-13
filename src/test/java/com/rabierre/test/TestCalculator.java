package com.rabierre.test;

import com.rabierre.calculator.Calculator;
import com.rabierre.calculator.Tokenizer;
import com.rabierre.calculator.ValueOperatorTokenizer;
import com.rabierre.calculator.core.DoubleValueToken;
import com.rabierre.calculator.core.IntValueToken;
import com.rabierre.calculator.core.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author rabierre
 */
public class TestCalculator {
    private Calculator calculator;
    private Tokenizer tokenizer;

    @Before
    public void setup() {
        calculator = new Calculator();
        tokenizer = new ValueOperatorTokenizer();
    }

    // todo refactor here
    @Test
    public void testCalculate() {
        List<Token> tokens = tokenizer.tokenize("1+2");

        Token actual = calculator.run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat(actual, is((Token)new IntValueToken(3)));
    }

    @Test
    public void testCalculate2() {
        List<Token> tokens = tokenizer.tokenize("1+2+3");

        Token actual = calculator.run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat((IntValueToken) actual, is(new IntValueToken(6)));
    }

    @Test
    public void testCalculate3() {
        List<Token> tokens = tokenizer.tokenize("(1+2)/3");

        Token actual = calculator.run(tokens);

        System.out.println("result : " + actual.toString());
        assertThat(actual, is((Token)new IntValueToken(1)));
    }

    @Test
    public void testCalculate4() {
        List<Token> reversed = tokenizer.tokenize("1*2/3");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new IntValueToken(0)));
    }

    @Test
    public void testCalculate5() {
        List<Token> reversed = tokenizer.tokenize("(1+2)/2.0");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(1.5)));
    }

    @Test
    public void testCalculate6() {
        List<Token> reversed = tokenizer.tokenize("2^2");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(4.0)));
    }

    @Test
    public void testCalculate7() {
        List<Token> reversed = tokenizer.tokenize("7%3");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new IntValueToken(1)));
    }

    @Test
    public void testCalculate8() {
        List<Token> reversed = tokenizer.tokenize("7  % 3.0");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token)new DoubleValueToken(1.0)));
    }

    @Test
    public void testCalculate9() {
        List<Token> reversed = tokenizer.tokenize("(1+2+3)*2");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token) new IntValueToken(12)));
    }

    @Test
    public void testCalculate10() {
        List<Token> reversed = tokenizer.tokenize("2*3-1");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token) new IntValueToken(5)));
    }

    @Test
    public void testCalculate11() {
        List<Token> reversed = tokenizer.tokenize("1+(2+3)*(4*5.0)");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token) new DoubleValueToken(101.0)));
    }

    @Test
    public void testCalculate12() {
        List<Token> reversed = tokenizer.tokenize("1*(2+3)-(3-4)");

        Token result = calculator.run(reversed);

        System.out.println("result : " + result.toString());
        assertThat(result, is((Token) new IntValueToken(6)));
    }
}
