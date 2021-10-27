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

    /**
     * Teilaufgabe 1:
     * Es handelt sich hier um test welche direkt funktionieren sollten, weil die
     * basis Implementierungen schon korrekt sind.
     *
     * testPostiveDivision: Ist für die richtige postive Division zuständig.
     */

    @Test
    @DisplayName("should display result after dividing two positive multi-digit numbers")
    void testPostiveDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(5);
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "13";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

