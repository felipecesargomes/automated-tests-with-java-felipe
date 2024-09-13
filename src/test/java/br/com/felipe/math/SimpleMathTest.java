package br.com.felipe.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {
    
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum() {
        //Given or Arrange
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        double expected = 8.2D;

        //When or Act
        Double actual = math.sum(firstNumber, secondNumber);

        //Then or Assert
        assertEquals(expected, actual, () -> firstNumber + "+" + secondNumber + " did not produce expected result!");
        assertEquals(8.2, actual, "The testSum() did not produce expected result!");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double actual = math.subtraction(firstNumber, secondNumber);
        double expected = 4.2D;

        assertEquals(expected, actual, () -> firstNumber + "-" + secondNumber + " did not produce expected result!");
        assertEquals(4.2D, actual, "The testSubtraction() did not produce expected result!");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testMultiplication() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double actual = math.multiplication(firstNumber, secondNumber);
        double expected = 12.4D;

        assertEquals(expected, actual, () -> firstNumber + "*" + secondNumber + " did not produce expected result!");
        assertEquals(12.4D, actual, "The testMultiplication() did not produce expected result!");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testDivision() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3.1D;

        assertEquals(expected, actual, () -> firstNumber + "/" + secondNumber + " did not produce expected result!");
        assertEquals(3.1D, actual, "The testDivision() did not produce expected result!");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test (6.2 + 2)/2 = 4.1")
    void testMean() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4.1D;

        assertEquals(expected, actual, () -> "(" + firstNumber + "/" + secondNumber + ")/2" + " did not produce expected result!");
        assertEquals(4.1D, actual, "The testMean() did not produce expected result!");
        assertNotNull(actual);
    }


}
