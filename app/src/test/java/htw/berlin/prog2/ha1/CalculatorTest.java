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
    @DisplayName("should display result after dividing two positive digit numbers")

    void testPositiveDivision()

    {
        Calculator calc = new Calculator();
        calc.pressDigitKey(7);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(7);
        calc.pressEqualsKey();

        String expected = "10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display Error after dividing through 0 ")
    void testPositiveDivitionThroughZero() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

//    @Test
//    @DisplayName("should reset screen to 0 and save the previous Number on the screen")
//    void testClearButton() {
//        Calculator calc = new Calculator();
//        calc.pressDigitKey(8);
//        calc.pressBinaryOperationKey("x");
//        calc.pressClearKey();
//        calc.pressDigitKey(2);
//        calc.pressEqualsKey();
//
//        String expected = "16";
//        String actual = calc.readScreen();
//
//        assertEquals(expected,actual);
//    }
}

