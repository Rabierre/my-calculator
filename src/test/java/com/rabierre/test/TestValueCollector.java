package com.rabierre.test;

import com.rabierre.calculator.ValueCollector;
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
public class TestValueCollector {
    @Test
    public void testSimpleValueParse() {
        List<String> expect = new ArrayList<>();
        expect.add("123");

        List<String> actual = new ValueCollector().parse("123");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse2() {
        List<String> expect = new ArrayList<>();
        expect.add("1");
        expect.add("+");
        expect.add("2");

        List<String> actual = new ValueCollector().parse("1+2");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse3() {
        List<String> actual = new ValueCollector().parse("(1+2)");

        List<String> expect = new ArrayList<>();
        expect.add("(");
        expect.add("1");
        expect.add("+");
        expect.add("2");
        expect.add(")");

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSimpleValueParse4() {
        List<String> actual = new ValueCollector().parse("(1+2)/3");

        List<String> expect = new ArrayList<>();
        expect.add("(");
        expect.add("1");
        expect.add("+");
        expect.add("2");
        expect.add(")");
        expect.add("/");
        expect.add("3");

        Assert.assertEquals(expect, actual);
    }
}
