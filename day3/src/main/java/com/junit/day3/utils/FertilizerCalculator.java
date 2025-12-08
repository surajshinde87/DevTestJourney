package main.java.com.junit.day3.utils;

public class FertilizerCalculator {

    public static String getNpkRecommendation(int n, int p, int k) {

        if (n < 20 || p < 20 || k < 20)
            return "Low nutrients, apply fertilizer";

        if (n > 80 && p > 80 && k > 80)
            return "Excess nutrients, reduce fertilizer";

        return "Balanced nutrients";
    }
    
}