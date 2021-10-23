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
    @Test
    @DisplayName("should display result after multiply a positive digit number and percent number")

    void testPercentNumber() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("%");
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "11.25";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("should do the last binary operation")

    void testDoLastBinaryOperationAgain() {
        Calculator calc = new Calculator ();

        calc.pressDigitKey(2);
        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(1);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        calc.pressEqualsKey();


        String expected = "-12";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should do multiple binary operations")

    void testMultipleBinaryOperations() {
        Calculator calc = new Calculator ();

        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();



        String expected = "190";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}