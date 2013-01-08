package com.rabierre.test;

import com.rabierre.calculator.SimpleTokenizer;
import com.rabierre.calculator.core.OperatorToken;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.ValueToken;
import junit.framework.Assert;
import org.junit.Test;

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
public class TestSimpleTokenizer {
    @Test
    public void testSimpleValueParse() {
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("123"));

        List<Token> actual = new SimpleTokenizer().tokenize("123");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse2() {
        List<Token> expect = new ArrayList<>();
        expect.add(new ValueToken("1"));
        expect.add(new OperatorToken("+"));
        expect.add(new ValueToken("2"));

        List<Token> actual = new SimpleTokenizer().tokenize("1+2");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse3() {
        List<Token> actual = new SimpleTokenizer().tokenize("(1+2)");

        List<Token> expect = new ArrayList<>();
        expect.add(new OperatorToken("("));
        expect.add(new ValueToken("1"));
        expect.add(new OperatorToken("+"));
        expect.add(new ValueToken("2"));
        expect.add(new OperatorToken(")"));

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse4() {
        List<Token> actual = new SimpleTokenizer().tokenize("(1+2)/3");

        List<Token> expect = new ArrayList<>();
        expect.add(new OperatorToken("("));
        expect.add(new ValueToken("1"));
        expect.add(new OperatorToken("+"));
        expect.add(new ValueToken("2"));
        expect.add(new OperatorToken(")"));
        expect.add(new OperatorToken("/"));
        expect.add(new ValueToken("3"));

        Assert.assertEquals(expect, actual);
    }
}
