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
    @DisplayName("should display result after multiplying two positive numbers ")
    void  testMultiplying() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display ERROR after division with 0")
    void testDivisonZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "ERROR";
        String actual = calc.readScreen();
        assertEquals(expected, actual);


    }


    @Test
    @DisplayName("Should display the result after pressing clear key ")
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressClearKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "6";
        String actual =calc.readScreen();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Should display the result after pressing clear key twice ")
    void testClearKey2() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressClearKey();
        calc.pressClearKey();


        String expected = "0";
        String actual =calc.readScreen();
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("should display result after adding two positive point numbers")
    void testAdditionPointNumbers() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "5";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("should display a positive number after pressing the negative key twice")
    void testNegativeKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressNegativeKey();
        calc.pressNegativeKey();


        String expected = "2";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }


}

