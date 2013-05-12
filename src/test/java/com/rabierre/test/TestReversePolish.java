package com.rabierre.test;

import com.rabierre.calculator.ReversePolishNotation;
import com.rabierre.calculator.SimpleTokenizer;
import com.rabierre.calculator.core.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import static com.rabierre.util.TokenUtil.createTokens;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
public class TestReversePolish {
    private ReversePolishNotation reverser = new ReversePolishNotation();

    @Test
    public void reverseEquationWithTwoVariable() {
        // 1+2
        List<Token> actual =
                reverser.reverse(createTokens("1 + 2"));

        // 12+
        List<Token> expect = createTokens("1 2 +");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void reverseSamePriority() {
        // 1+2+3
        List<Token> actual =
                reverser.reverse(createTokens("1 + 2 + 3"));
        // 123++
        List<Token> expect = createTokens("1 2 3 + +");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void reverseDifferentPriority() {
        // 1+2/3
        List<Token> actual =
                reverser.reverse(createTokens("1 + 2 / 3"));

        // 123/+
        List<Token> expect = createTokens("1 2 3 / +");
        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void reverseBracketInfluencePriority() {
        // (1+2)/3
        List<Token> actual =
                reverser.reverse(createTokens("( 1 + 2 ) / 3"));

        // 12+3/
        List<Token> expect = createTokens("1 2 + 3 /");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void reverseBracketDoNotInfluencePriority() {
        // (1*2)/3
        List<Token> actual =
                reverser.reverse(createTokens("( 1 * 2 ) / 3"));

        // 12*3/
        List<Token> expect = createTokens("1 2 * 3 /");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse6() {
        // 1*(2+3)/4
        List<Token> actual =
                reverser.reverse(createTokens("1 * ( 2 + 3 ) / 4"));

        // 123+4/*
        List<Token> expect = createTokens("1 2 3 + 4 / *");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCloseBracketMissing() {
        // (1+2
        List<Token> tokens = createTokens("( 1 + 2");

        reverser.reverse(tokens);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenOpenBracketMissing() {
        // 1+2)
        List<Token> tokens = createTokens("1 + 2 )");

        reverser.reverse(tokens);
    }

}