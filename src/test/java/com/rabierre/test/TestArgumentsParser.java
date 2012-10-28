package com.rabierre.test;

import com.rabierre.calculator.Parser;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: seojihye
 * Date: 12. 10. 7.
 * Time: 오전 5:18
 * To change this template use File | Settings | File Templates.
 */
public class TestArgumentsParser {
    @Test
    public void testSimpleIntegerParse() {
        String[] args = new String[]{"1", "2", "3"};
        Parser.parse(args);
    }

    @Test
    public void testComplexIntegerParse() {
        String[] args = new String[]{"10", "212", "333"};
        Parser.parse(args);
    }

    @Test
    public void testOperatorParse() {
        String[] args = new String[]{"1", "+", "2"};
        Parser.parse(args);
    }

    @Test
    public void testOperatorParse2() {
        String[] args = new String[]{"1+2"};
        Parser.parse(args);

        /*     Pattern p = Pattern.compile("\\+");
     Matcher m = p.matcher("+");
     boolean result = m.find();*/
    }


}
