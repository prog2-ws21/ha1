package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    //REGRESSIONSTEST
    @Test
    @DisplayName("should display the result of multiplication with negative and decimal numbers ")
    void testNegativeMultiplication(){
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(6);
        calculator.pressNegativeKey();
        calculator.pressBinaryOperationKey("x");
        calculator.pressDigitKey(1);
        calculator.pressDotKey(".");
        calculator.pressDigitKey(2);
        calculator.pressDigitKey(3);
        calculator.pressEqualsKey();
        double expected = -6 * 1.23;
        assertEquals(Double.toString(expected), calculator.readScreen());
    }


    @Test
    @DisplayName("should display the intermediate result of a binary operation upon pressing a binary operation key and other erratic combinations with '='")
    void testIntermediateResult() {
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(3);
        calculator.pressDigitKey(3);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(9);
        calculator.pressBinaryOperationKey("+");
        assertEquals("42", calculator.readScreen());
        calculator.pressBinaryOperationKey("+");
        assertEquals("42", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals("84", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals("126", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals("168", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals("210", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals("252", calculator.readScreen());
        calculator.pressBinaryOperationKey("+");
        assertEquals("252", calculator.readScreen());
        calculator.pressDigitKey(7);
        assertEquals("7", calculator.readScreen());
        calculator.pressBinaryOperationKey("+");
        assertEquals("259", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals("518", calculator.readScreen());
    }

    @Test
    @DisplayName("Should display an error message when attempting to divide zero by zero yet still take additional input   ")
    void testDivisionByZero() {
        String expected = "Error";
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(8);
        calculator.pressBinaryOperationKey("/");
        calculator.pressDigitKey(0);
        calculator.pressBinaryOperationKey("-");
        assertEquals(expected, calculator.readScreen());
        calculator.pressBinaryOperationKey("x");
        assertEquals(expected, calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals(expected, calculator.readScreen());
        calculator.pressDigitKey(7);
        assertEquals("7", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals(expected, calculator.readScreen());
        calculator.pressBinaryOperationKey("x");
        assertEquals(expected, calculator.readScreen());
        calculator.pressDigitKey(3);
        assertEquals("3", calculator.readScreen());
        calculator.pressBinaryOperationKey("/");
        assertEquals(expected, calculator.readScreen());
        calculator.pressDigitKey(5);
        assertEquals("5", calculator.readScreen());
        calculator.pressEqualsKey();
        assertEquals(expected, calculator.readScreen());
    }


}

