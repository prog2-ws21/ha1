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
    @DisplayName("Test für Teilaufgabe 1: checks the correct deletion of input numbers after pressing the C button")
    void testy() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressClearKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test für Teilaufgabe 2: Division by zero")
    void testDivideByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test für Teilaufgabe 3: Repetitive Equals Key")
    void testRepeatEqualKey() {
        Calculator calc = new Calculator();

//        calc.pressDigitKey(1);
//        calc.pressDigitKey(0);
//        calc.pressDigitKey(0);
//        calc.pressDigitKey(0);
//        calc.pressDigitKey(0);
//        calc.pressDigitKey(0);

        calc.setScreen("10000");
        calc.pressBinaryOperationKey("/");
//        calc.pressDigitKey(1);
//        calc.pressDigitKey(0);
        calc.setScreen("10");
        calc.pressEqualsKey(); //should be 10000
        calc.pressEqualsKey(); //should be 1000
        calc.pressEqualsKey(); //should be 100
        calc.pressEqualsKey(); //should be 10

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

