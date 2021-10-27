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
     * <p>
     * testPostiveDivision: Ist für die richtige postive Division zuständig.
     * testPostiveProzent: Ist für die richtige postive Prozent berechnung zuständig.
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

    @Test
    @DisplayName("should display result after calculating the percentage of a postive multi-digit number")
    void testPostiveProzent() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("%");

        String expected = "0.12";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /**
     * Teilaufgabe 2-3:
     * Es handelt sich hier um test welche nicht direkt funktionieren sollten, weil die
     * basis Implementierungen diese funktionalität nicht enthält oder ein Bug vorliegt.
     * <p>
     * Diese werden durch die Aufgabe korrigiert und Implementiert um einen Grünen Test zu erhalten.
     * <p>
     * testDividingByZero: Ist für die richtige Division mit null zuständig.
     * testNegativKeyFirst: Negative Zeichen am anfang klicken.
     */

    @Test
    @DisplayName("should display result Error after dividing a positive number with zero")
    void testDividingByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result when NegativeKey ist pressed first, before adding a negative multi-digit number with a positive multi-digit number")
    void testNegativKeyFirst() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(7);
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "-70";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}
