package com.rabierre.test;

import com.rabierre.calculator.Calculator;
import com.rabierre.calculator.ReversePolishNotation;
import com.rabierre.calculator.core.*;
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
        // 12+
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(new IntValueToken(2));
        tokens.add(new Plus());

        Token actual = new Calculator().run(tokens);

        TokenUtil.print(tokens);
        System.out.println("result : " + actual.toString());

        Token expect = new IntValueToken(3);
        assertThat(actual, is(expect));
    }

    @Test
    public void testCalculate2() {
        // 123++
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(new IntValueToken(2));
        tokens.add(new IntValueToken(3));
        tokens.add(new Plus());
        tokens.add(new Plus());

        Token actual = new Calculator().run(tokens);

        TokenUtil.print(tokens);
        System.out.println("result : " + actual.toString());

        Token expect = new IntValueToken(6);
        assertThat(actual, is(expect));
    }

    @Test
    public void testCalculate3() {
        // 12+3/
        List<Token> tokens = new ArrayList<>();
        tokens.add(new IntValueToken(1));
        tokens.add(new IntValueToken(2));
        tokens.add(OperatorSet.getOperator(Operator.PLUS));
        tokens.add(new IntValueToken(3));
        tokens.add(OperatorSet.getOperator(Operator.DIVIDE));

        Token actual = new Calculator().run(tokens);

        TokenUtil.print(tokens);
        System.out.println("result : " + actual.toString());

        Token expect = new IntValueToken(1);
        assertThat(actual, is(expect));
    }

    @Test
    public void testCalculate4() {
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

        List<Token> reversed = new ReversePolishNotation().process(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(reversed);
        System.out.println("");

        Assert.assertEquals(expect.size(), reversed.size());
        assertThat(expect, is(reversed));

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());

        assertThat((IntValueToken) result, is(new IntValueToken(0)));
    }

    @Test
    public void testCalculate5() {
        // 12*3/
        List<Token> reversed = new ArrayList<>();
        reversed.add(new IntValueToken(1));
        reversed.add(new IntValueToken(2));
        reversed.add(OperatorSet.getOperator(Operator.PLUS));
        reversed.add(new DoubleValueToken(2.0));
        reversed.add(OperatorSet.getOperator(Operator.DIVIDE));

        TokenUtil.print(reversed);

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());

        assertThat((DoubleValueToken) result, is(new DoubleValueToken(1.5)));
    }

    @Test
    public void testCalculate6() {
        // 2^2
        List<Token> reversed = new ArrayList<>();
        reversed.add(new IntValueToken(2));
        reversed.add(new IntValueToken(2));
        reversed.add(OperatorSet.getOperator(Operator.POWER));

        TokenUtil.print(reversed);

        Token result = new Calculator().run(reversed);

        System.out.println("result : " + result.toString());

        assertThat((DoubleValueToken) result, is(new DoubleValueToken(4.0)));
    }
}
