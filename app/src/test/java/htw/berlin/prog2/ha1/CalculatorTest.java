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


    // Regression Test
    @Test
    @DisplayName("multiply negative digits to get a positive result")
    void calculateWithNegativeDigits () {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        //calc.pressNegativeKey();
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(-4);
        //calc.pressNegativeKey();

        calc.pressEqualsKey();
        String expected = "-8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }


    // Test-driven Test 1
    @Test
    @DisplayName("calculate with more than two digits")
    void testCalculateWithMoreDigits () {
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(4);

        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);

        calc.pressEqualsKey();
        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    // Test-driven Test 2
    @Test
    @DisplayName("try to square the root of negative numbers")
    void testSquareTheRootNegativeNumbers () {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "ERROR";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

}

