package com.rabierre.test;

import com.rabierre.calculator.ReversePolishNotation;
import com.rabierre.calculator.core.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.rabierre.util.TokenUtil.createMockTokens;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
public class TestReversePolish {
    private ReversePolishNotation reverser;

    @Before
    public void setup() {
        reverser = new ReversePolishNotation();
    }

    @Test
    public void normalCaseWithSingleOperatorEq() {
        assertThat(reverser.reverse(createMockTokens("1 + 2")), is(createMockTokens("1 2 +")));
    }

    @Test
    public void normalCaseWithSameLevelPriorities() {
        assertThat(reverser.reverse(createMockTokens("1 + 2 + 3")), is(createMockTokens("1 2 3 + +")));
    }

    @Test
    public void normalCaseWithDifferentLevelPriorities() {
        assertThat(reverser.reverse(createMockTokens("1 + 2 / 3")), is(createMockTokens("1 2 3 / +")));
    }

    // todo refactor tests
    @Test
    public void reverseBracketInfluencePriority() {
        // (1+2)/3
        List<Token> actual =
                reverser.reverse(createMockTokens("( 1 + 2 ) / 3"));

        // 12+3/
        List<Token> expect = createMockTokens("1 2 + 3 /");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void reverseBracketDoNotInfluencePriority() {
        // (1*2)/3
        List<Token> actual =
                reverser.reverse(createMockTokens("( 1 * 2 ) / 3"));

        // 12*3/
        List<Token> expect = createMockTokens("1 2 * 3 /");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse6() {
        // 1*(2+3)/4
        List<Token> actual =
                reverser.reverse(createMockTokens("1 * ( 2 + 3 ) / 4"));

        // 123+4/*
        List<Token> expect = createMockTokens("1 2 3 + 4 / *");

        TokenUtil.print(actual);
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCloseBracketMissing() {
        // (1+2
        List<Token> tokens = createMockTokens("( 1 + 2");

        reverser.reverse(tokens);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenOpenBracketMissing() {
        // 1+2)
        List<Token> tokens = createMockTokens("1 + 2 )");

        reverser.reverse(tokens);
    }
}
