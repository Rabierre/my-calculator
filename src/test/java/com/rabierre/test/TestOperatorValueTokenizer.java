package com.rabierre.test;

import com.rabierre.calculator.ValueOperatorTokenizer;
import com.rabierre.calculator.core.*;
import junit.framework.Assert;
import org.junit.Test;

import static com.rabierre.util.TokenUtil.createTokens;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
public class TestOperatorValueTokenizer {
    @Test
    public void testSimpleValueParse() {
        List<Token> expect = createTokens("123");

        List<Token> actual = new ValueOperatorTokenizer().tokenize("123");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse2() {
        List<Token> actual = new ValueOperatorTokenizer().tokenize("1+2");

        List<Token> expect = createTokens("1 + 2");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse3() {
        List<Token> actual = new ValueOperatorTokenizer().tokenize("(1+2)");

        List<Token> expect = createTokens("( 1 + 2 )");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse4() {
        List<Token> actual = new ValueOperatorTokenizer().tokenize("(1+2)/3");

        List<Token> expect = createTokens("( 1 + 2 ) / 3");

        Assert.assertEquals(expect, actual);
    }
}
