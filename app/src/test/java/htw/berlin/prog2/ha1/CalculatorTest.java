package htw.berlin.prog2.ha1;

import org.checkerframework.framework.qual.IgnoreInWholeProgramInference;
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
    @DisplayName("Test #3 - should display zero after pressing the clear button")
    void testClearFunction() {
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(2);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(2);
        calculator.pressEqualsKey();
        calculator.pressClearKey();

        var expected = "0";
        var actual = calculator.readScreen();
        assertEquals(expected , actual);
    }


    @Test
    @DisplayName("Test #4 - can handle floating-point numbers")
    void testFloatingPointNumbers() {

        Calculator calculator = new Calculator();
        calculator.pressDigitKey(3);
        calculator.pressDigitKey(3);
        calculator.pressDotKey();
        calculator.pressDigitKey(5);
        calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(1);
        calculator.pressDigitKey(1);
        calculator.pressDotKey();
        calculator.pressDigitKey(3);
        calculator.pressDigitKey(3);
        calculator.pressEqualsKey();

        var expected = "44.88";
        var actual = calculator.readScreen();
        assertEquals(expected, actual);

    }

  






}

