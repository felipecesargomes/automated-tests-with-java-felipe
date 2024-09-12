package br.com.felipe.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleMathTest {

    @Test
    void test() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double actual = math.sum(firstNumber, secondNumber);
        double expected = 8.2D;

        assertEquals(expected, actual, () -> firstNumber + "+" + secondNumber + " did not produce expected result!");
        assertEquals(8.2, actual, "The testSum() did not produce expected result!");
        assertNotNull(actual);
    }

}
