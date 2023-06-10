package com.example.sweater;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleTest {
    @Test
    public void test() {
        int x = 2;
        int y = 23;

        Assert.assertEquals(46, x * y);
        Assert.assertEquals(25, x + y);
    }

    @Test(expected = ArithmeticException.class) // предупредили тест что будет исключение
    public void error() {
        int i = 0;
        int i1 = 1 / i;
    }
}
