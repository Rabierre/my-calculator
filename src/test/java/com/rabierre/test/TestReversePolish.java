package com.rabierre.test;

import com.rabierre.calculator.ReversePolishNotation;
import org.junit.Before;
import org.junit.Test;

import static com.rabierre.util.TokenUtil.createMockTokens;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author rabierre
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

    @Test
    public void reverseBracketInfluencePriority() {
        assertThat(reverser.reverse(createMockTokens("( 1 + 2 ) / 3")), is(createMockTokens("1 2 + 3 /")));
    }

    @Test
    public void reverseBracketDoNotInfluencePriority() {
        assertThat(reverser.reverse(createMockTokens("( 1 * 2 ) / 3")), is(createMockTokens("1 2 * 3 /")));
    }

    @Test
    public void testSimpleReverse6() {
        assertThat(reverser.reverse(createMockTokens("1 * ( 2 + 3 ) / 4")), is(createMockTokens("1 2 3 + 4 / *")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCloseBracketMissing() {
        assertThat(reverser.reverse(createMockTokens("( 1 + 2")), is(createMockTokens("BROKEN")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenOpenBracketMissing() {
        assertThat(reverser.reverse(createMockTokens("1 + 2 )")), is(createMockTokens("BROKEN")));
    }

    @Test
    public void gotPostfixEq() {
        assertThat("only support infixEq", reverser.reverse(createMockTokens("1 2 + 3 *")), not(createMockTokens("1 2 + 3 *")));
    }

    @Test
    public void gotPrefixEq() {
        assertThat("only support infixEq", reverser.reverse(createMockTokens("+ * 2 1 2")), not(createMockTokens("2 1 * 2 +")));
    }
}
