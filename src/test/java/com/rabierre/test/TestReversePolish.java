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

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse2() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("2", false));
        expect.add(new Token("3", false));
        expect.add(new Token("+", true));
        expect.add(new Token("+", true));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("2", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("3", false));

        List<Token> actual = new ReversePolish().doSomething(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
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

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse4() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("2", false));
        expect.add(new Token("+", true));
        expect.add(new Token("3", false));
        expect.add(new Token("/", true));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("(", true));
        tokens.add(new Token("1", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("2", false));
        tokens.add(new Token(")", true));
        tokens.add(new Token("/", true));
        tokens.add(new Token("3", false));

        List<Token> actual = new ReversePolish().doSomething(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(5, actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse5() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("2", false));
        expect.add(new Token("*", true));
        expect.add(new Token("3", false));
        expect.add(new Token("/", true));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("(", true));
        tokens.add(new Token("1", false));
        tokens.add(new Token("*", true));
        tokens.add(new Token("2", false));
        tokens.add(new Token(")", true));
        tokens.add(new Token("/", true));
        tokens.add(new Token("3", false));

        List<Token> actual = new ReversePolish().doSomething(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleReverse6() {
        List<Token> expect = new ArrayList<>();
        expect.add(new Token("1", false));
        expect.add(new Token("2", false));
        expect.add(new Token("3", false));
        expect.add(new Token("+", true));
        expect.add(new Token("4", false));
        expect.add(new Token("/", true));
        expect.add(new Token("*", true));

        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1", false));
        tokens.add(new Token("*", true));
        tokens.add(new Token("(", true));
        tokens.add(new Token("2", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("3", false));
        tokens.add(new Token(")", true));
        tokens.add(new Token("/", true));
        tokens.add(new Token("4", false));

        List<Token> actual = new ReversePolish().doSomething(tokens);

        TokenUtil.print(tokens);
        TokenUtil.print(actual);
        System.out.println("");
        Assert.assertEquals(expect.size(), actual.size());
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSimpleReverseException() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("(", true));
        tokens.add(new Token("1", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("2", false));

        List<Token> actual  = new ReversePolish().doSomething(tokens);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSimpleReverseException2() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1", false));
        tokens.add(new Token("+", true));
        tokens.add(new Token("2", false));
        tokens.add(new Token(")", true));

        List<Token> actual = new ReversePolish().doSomething(tokens);
    }
}
