package org.datagrokr.assignment.SpringCalculator.SharedFunctions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class CalculationMethodsTest {

    CalculationMethods calculationMethods;

    @BeforeEach
    void setUp() {
        calculationMethods = new CalculationMethods();
    }

    @Test
    @DisplayName("Test for Add")
    void addTest() {
        String expected = "1 + 1 = 2";
        String actual = calculationMethods.add(1,1);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test for Subtract")
    void subtractTest() {
        String expected = "4 - 2 = 2";
        String actual = calculationMethods.subtract(4,2);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test for Multiply")
    void multiplyTest() {
        String expected = "5 * 2 = 10";
        String actual = calculationMethods.multiply(5,2);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test for Divide")
    void divideTest() {
        String expected = "20 / 10 = 2";
        String actual = calculationMethods.divide(20,10);
        assertEquals(expected,actual);
    }
}