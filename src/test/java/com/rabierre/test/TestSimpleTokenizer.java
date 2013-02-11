package com.rabierre.test;

import com.rabierre.calculator.SimpleTokenizer;
import com.rabierre.calculator.core.*;
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
        expect.add(new IntValueToken(123));

        List<Token> actual = new SimpleTokenizer().tokenize("123");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse2() {
        List<Token> expect = new ArrayList<>();
        expect.add(new IntValueToken(1));
        expect.add(OperatorSet.getOperator(Operator.PLUS));
        expect.add(new IntValueToken(2));

        List<Token> actual = new SimpleTokenizer().tokenize("1+2");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse3() {
        List<Token> actual = new SimpleTokenizer().tokenize("(1+2)");

        List<Token> expect = new ArrayList<>();
        expect.add(OperatorSet.getOperator(Operator.OPEN_BRACKET));
        expect.add(new IntValueToken(1));
        expect.add(OperatorSet.getOperator(Operator.PLUS));
        expect.add(new IntValueToken(2));
        expect.add(OperatorSet.getOperator(Operator.CLOSE_BRACKET));

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse4() {
        List<Token> actual = new SimpleTokenizer().tokenize("(1+2)/3");

        List<Token> expect = new ArrayList<>();
        expect.add(OperatorSet.getOperator(Operator.OPEN_BRACKET));
        expect.add(new IntValueToken(1));
        expect.add(OperatorSet.getOperator(Operator.PLUS));
        expect.add(new IntValueToken(2));
        expect.add(OperatorSet.getOperator(Operator.CLOSE_BRACKET));
        expect.add(OperatorSet.getOperator(Operator.DIVIDE));
        expect.add(new IntValueToken(3));

        Assert.assertEquals(expect, actual);
    }
}
