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

    //Teilaufgabe 1
    @Test
    @DisplayName("should turn a digit into a negative number")
    void testNegativeKey()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressNegativeKey();

        String expected = "-6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Teilaufgabe 2: Erster Bug
    @Test
    @DisplayName("should allow only one dot on the screen")
    void testDotKey()
    {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(6);

        String expected = "2.46";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Teilaufgabe 2: Zweiter Bug
    @Test
    @DisplayName("should convert a negative number into a positive when pressing the negative button")
    void testNegativeNumberConversion()
    {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressNegativeKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

