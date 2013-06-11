package com.rabierre.test;

import com.rabierre.calculator.Tokenizer;
import com.rabierre.calculator.ValueOperatorTokenizer;
import com.rabierre.calculator.core.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.rabierre.util.TokenUtil.createMockTokens;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

/**
 * @author rabierre
 */
public class TestOperatorValueTokenizer {
    private Tokenizer tokenizer;

    @Before
    public void setup() {
        tokenizer = new ValueOperatorTokenizer();
    }

    @Test
    public void testSimpleValueParse() {
        assertThat(tokenizer.tokenize("123").size(), is(1));
        assertThat(tokenizer.tokenize("123"), is(createMockTokens("123")));
    }

    @Test
    public void testSimpleValueParse2() {
        assertThat(tokenizer.tokenize("1+2").size(), is(3));
        assertThat(tokenizer.tokenize("1+2"), is(createMockTokens("1 + 2"))); // todo second assert is Tautology

    }

    @Test
    public void testSimpleValueParse3() {
        assertThat(tokenizer.tokenize("(1+2)").size(), is(5));
        assertThat(tokenizer.tokenize("(1+2)"), is(createMockTokens("( 1 + 2 )")));

    }

    @Test
    public void testSimpleValueParse4() {
        assertThat(tokenizer.tokenize("(1+2)/3").size(), is(7));
        assertThat(tokenizer.tokenize("(1+2)/3"), is(createMockTokens("( 1 + 2 ) / 3")));
    }
}
