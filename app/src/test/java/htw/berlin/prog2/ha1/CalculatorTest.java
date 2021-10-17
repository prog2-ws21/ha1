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
    @Test
    @DisplayName("should display the result after multiplying two negative numbers")
    void testNegativeMultiplication(){

      Calculator calc = new Calculator();

      calc.pressDigitKey(3);
      calc.pressNegativeKey();
      calc.pressBinaryOperationKey("x");
      calc.pressDigitKey(3);
      calc.pressNegativeKey();

      calc.pressEqualsKey();

      String expected = "9";
      String actual = calc.readScreen();

      assertEquals(expected,actual);

    }

    @Test
    @DisplayName("first bug- only one dot can be written")
    void testDotKey(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(1);

        String expected = "1.111";
        String actual = calc.readScreen();

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("second bug - operation 1/x with x = 0 -> \"Error\" must be written ")
    void testInversion(){

        Calculator calculator = new Calculator();
        calculator.pressDigitKey(0);
        calculator.pressUnaryOperationKey("1/x");

        String expected = "Error";
        String actual = calculator.readScreen();

        assertEquals(expected,actual);
    }


}

