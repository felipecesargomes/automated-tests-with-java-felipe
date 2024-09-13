package br.com.felipe.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {

    SimpleMath math;

    @BeforeAll
    static void setup() {
        //Mais usados nos testes de integração (para carregar banco)
        System.out.println("Running @BeforeAll Method!");
    }

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach Method!");


    }

    @AfterEach
    void afterEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @AfterEach Method!");
    }

    @AfterAll
    static void cleanup() {
        //Limpa o banco, por exemplo!
        System.out.println("Running @AfterAll Method!");
    }

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum() {
        System.out.println("testSum");
        //Given or Arrange
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
        System.out.println("testSubtraction");
        
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
        System.out.println("testMultiplication");
        
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
        System.out.println("testDivision");

        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double actual = math.division(firstNumber, secondNumber);
        double expected = 3.1D;

        assertEquals(expected, actual, () -> firstNumber + "/" + secondNumber + " did not produce expected result!");
        assertEquals(3.1D, actual, "The testDivision() did not produce expected result!");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test Division by Zero")
    void testDivision_ShouldThrowArithmeticException() {
        System.out.println("testDivision_ShouldThrowArithmeticException");

        //Given
        double firstNumber = 6.2D;
        double secondNumber = 0D;


        var expectedMessage = "Impossible to divide by zero!";

        //When & Then
        ArithmeticException actual = assertThrows(
                ArithmeticException.class, () -> {
                    math.division(firstNumber, secondNumber);
                }, () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");

    }

    @Test
    @DisplayName("Test (6.2 + 2)/2 = 4.1")
    @Disabled
    void testMean() {
        
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double actual = math.mean(firstNumber, secondNumber);
        double expected = 4.1D;

        assertEquals(expected, actual, () -> "(" + firstNumber + "/" + secondNumber + ")/2" + " did not produce expected result!");
        assertEquals(4.1D, actual, "The testMean() did not produce expected result!");
        assertNotNull(actual);
    }


}
