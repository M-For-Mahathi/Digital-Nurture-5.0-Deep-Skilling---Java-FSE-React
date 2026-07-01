package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise3_1AssertionsTest {
    @Test
    public void testAssertions(){

        //AssertEquals
        assertEquals(5, 2+3);

        //AssertTrue
        assertTrue(5 > 3);

        //AssertFalse
        assertFalse(5 < 3);

        //AssertNull
        assertNull(null);

        //AssertNotNUll
        assertNotNull(new Object());
    }
}
