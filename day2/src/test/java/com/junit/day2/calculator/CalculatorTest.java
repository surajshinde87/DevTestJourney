
package com.junit.day2.calculator;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;


public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("Starting Calculator Tests...");
    }

    @BeforeEach
    void setup() {
        calculator = new Calculator();
        System.out.println("New Calculator Instance Created");
    }

    @Test
    @DisplayName("Test Addition")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Test Subtraction")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    @DisplayName("Test Multiplication")
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    @DisplayName("Test Division")
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    @DisplayName("Test Division by Zero")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(6, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    @DisplayName("Test Multiple Operations")
    void testMultipleOperations() {
        assertAll(
            () -> assertEquals(5, calculator.add(2, 3)),
            () -> assertEquals(1, calculator.subtract(3, 2)),
            () -> assertEquals(6, calculator.multiply(2, 3)),
            () -> assertEquals(2, calculator.divide(6, 3))
        );
    }

    
  @AfterEach
    void tearDown() {
        System.out.println("Test Completed");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All Calculator Tests Completed");
    }    
}
