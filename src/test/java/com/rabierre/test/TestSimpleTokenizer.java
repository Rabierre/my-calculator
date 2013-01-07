package com.rabierre.test;

import com.rabierre.calculator.SimpleTokenizer;
import com.rabierre.calculator.core.Token;
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
        expect.add(new Token("123", false));

        List<Token> actual = new SimpleTokenizer().tokenize("123");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse2() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("+", true));
        expect.add(new Token("2", false));

        List<Token> actual = new SimpleTokenizer().tokenize("1+2");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse3() {
        List<Token> actual = new SimpleTokenizer().tokenize("(1+2)");

        List<Token> expect = new ArrayList<>();
        expect.add(new Token("(", true));
        expect.add(new Token("1", false));
        expect.add(new Token("+", true));
        expect.add(new Token("2", false));
        expect.add(new Token(")", true));

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse4() {
        List<Token> actual = new SimpleTokenizer().tokenize("(1+2)/3");

        List<Token> expect = new ArrayList<>();
        expect.add(new Token("(", true));
        expect.add(new Token("1", false));
        expect.add(new Token("+", true));
        expect.add(new Token("2", false));
        expect.add(new Token(")", true));
        expect.add(new Token("/", true));
        expect.add(new Token("3", false));

        Assert.assertEquals(expect, actual);
    }
}
