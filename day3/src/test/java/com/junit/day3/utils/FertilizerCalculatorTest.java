package test.java.com.junit.day3.utils;

import main.java.com.junit.day3.utils.FertilizerCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FertilizerCalculatorTest {


    @Test
    void testLowNutrient() {
        String result = FertilizerCalculator.getNpkRecommendation(10, 25, 30);
        assertEquals("Low nutrients, apply fertilizer", result);
    }

    @Test
    void testBalancedNutrient() {
        String result = FertilizerCalculator.getNpkRecommendation(50, 60, 70);
        assertEquals("Balanced nutrients", result);
    }

    @Test
    void testExcessNutrient() {
        String result = FertilizerCalculator.getNpkRecommendation(90, 95, 85);
        assertEquals("Excess nutrients, reduce fertilizer", result);
    }
    
}