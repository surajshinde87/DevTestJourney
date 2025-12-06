package com.junit.day1.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(7, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(4, calculator.subtract(9, 5));
    }

    @Test
    void testAddNotEquals() {
        assertNotEquals(8, calculator.add(3, 3));
    }
}
