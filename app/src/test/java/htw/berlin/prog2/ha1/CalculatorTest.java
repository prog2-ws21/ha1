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
        calc.pressEqualsKey(); // equalskey methode hätte ich eher erwartet dass calc.DigitKey(=) stehen würde

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

        String expected = "1.41421356";   // zeigt direkt das ergebnis an
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen


    /**
     * Teilaufgabe 1
     * subtrahieren von 6 und 5 das erwartete Ergebnis ist 1
     */

    @Test
    @DisplayName("should display result after subtracting two positive digit numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /**
     * Teilaufgabe 2
     * neuer roter test in testF1PositiveSubtraction()
     * Fehlergrund Zahlen vertauscht in calc.pressDigitKey Methoden in Zeilen 79 und 81, statt 6-5, 5-6 wodurch das Ergebnis -1 wird
     */

    /**
    @Test
    @DisplayName("should display result after subtracting two positive digit numbers")
    void testF1PositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    */

    /**
     *
     * Fix zu diesem Test
     * alter falscher Testcode wurde auskommentiert und neu gefixter Code wird darunter eingefügt
     * Zeile 102 und 104(ursprünglich Zeile 79 und 81 beim auskommentierten code werden vertauscht
     */
    @Test
    @DisplayName("should display result after subtracting two positive digit numbers")
    void testF1PositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


}