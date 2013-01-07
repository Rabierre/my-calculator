package com.rabierre.test;

import com.rabierre.calculator.ReversePolish;
import com.rabierre.calculator.core.Token;
import com.rabierre.calculator.core.TokenUtil;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
public class TestReversePolish {
    @Test
    public void testSimpleReverse() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("2", false));
        expect.add(new Token("+", true));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("2", false));

        List<Token> actual  = new ReversePolish().doSomething(tokens);

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse2() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("2", false));
        expect.add(new Token("+", true));
        expect.add(new Token("3", false));
        expect.add(new Token("+", true));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("2", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("3", false));

        List<Token> actual = new ReversePolish().doSomething(tokens);

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse3() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("2", false));
        expect.add(new Token("3", false));
        expect.add(new Token("/", true));
        expect.add(new Token("+", true));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("2", false));
        tokens.add(new Token("/", true));
        tokens.add(new Token("3", false));

        List<Token> actual = new ReversePolish().doSomething(tokens);

        Assert.assertEquals(expect, actual);

        TokenUtil.print(actual);
    }
}
