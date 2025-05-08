package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

private static final double DELTA = 1e-8;

    @Test
    public void testAverage_PositiveNumbers() {
        Sqrt s = new Sqrt(0);
        assertEquals(4.5, s.average(4.0, 5.0), DELTA);
    }

    @Test
    public void testAverage_NegativeNumbers() {
        Sqrt s = new Sqrt(0);
        assertEquals(-4.5, s.average(-4.0, -5.0), DELTA);
    }

    @Test
    public void testGood_WhenCloseEnough() {
        Sqrt s = new Sqrt(2.0);
        double guess = Math.sqrt(2.0);
        assertTrue(s.good(guess, 2.0));
    }

    @Test
    public void testGood_WhenNotClose() {
        Sqrt s = new Sqrt(2.0);
        assertFalse(s.good(1.0, 2.0));
    }

    @Test
    public void testImprove_ImprovesGuess() {
        Sqrt s = new Sqrt(2.0);
        double improved = s.improve(1.0, 2.0);
        // improve(1,2) = (1 + 2/1)/2 = 1.5
        assertEquals(1.5, improved, DELTA);
    }

    @Test
    public void testIter_SimpleCase() {
        Sqrt s = new Sqrt(4.0);
        double result = s.iter(1.0, 4.0);
        assertEquals(2.0, result, DELTA);
    }

    @Test
    public void testCalc_PerfectSquare() {
        Sqrt s = new Sqrt(9.0);
        assertEquals(3.0, s.calc(), DELTA);
    }

    @Test
    public void testCalc_NonPerfectSquare() {
        Sqrt s = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), s.calc(), DELTA);
    }

    @Test
    public void testCalc_Zero() {
        Sqrt s = new Sqrt(0.0);
        assertEquals(0.0, s.calc(), DELTA);
    }

    @Test
    public void testCalc_One() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(1.0, s.calc(), DELTA);
    }

    @Test
    public void testCalc_LargeValue() {
        double val = 1e6;
        Sqrt s = new Sqrt(val);
        assertEquals(Math.sqrt(val), s.calc(), 1e-4);
    }

    @Test
    public void testIter_Convergence() {
        Sqrt s = new Sqrt(12345.678);
        double guess = s.iter(1.0, 12345.678);
        assertTrue(s.good(guess, 12345.678));
    }
}
