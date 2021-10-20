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
    @DisplayName("should display result after subtracting two positive multi-digit numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error after dividing with 0")
    void testZeroDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();


        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*@Test
        @DisplayName("should display negative number after pressing negativeKey")
        void testShowNegativeNumber() {
            Calculator calc = new Calculator();

            calc.pressNegativeKey();
            calc.pressDigitKey(2);

            String expected = "-2";
            String actual = calc.readScreen();

            assertEquals(expected, actual);
        }

*/
    @Test
    @DisplayName("should display a point number with one dot, when two periods are typed")
    void testPressDotKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(1);

        String expected = "4.21";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

