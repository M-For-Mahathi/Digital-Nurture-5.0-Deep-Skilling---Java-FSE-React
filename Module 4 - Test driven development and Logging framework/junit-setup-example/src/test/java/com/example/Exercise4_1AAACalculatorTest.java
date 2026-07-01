package com.example;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class Exercise4_1AAACalculatorTest {

    private Calculator calc;

    @Before
    public void setUp(){
        calc = new Calculator();
        System.out.println("Setting up calculator");
    }

    @After
    public void tearDown(){
        calc = null;
        System.out.println("Tearing down calculator");
    }
    @Test
    public void addTest(){
        int result = calc.add(2, 4);
        assertEquals(6, result);
    }

    @Test
    public void subtractTest(){
        int res = calc.subtract(4, 5);
        assertEquals(-1, res);
    }
}
