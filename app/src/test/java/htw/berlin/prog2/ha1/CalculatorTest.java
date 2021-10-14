package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    @DisplayName("should reset all 3 instance fields of Calculator")
    void testPressClearKey() {
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(1);
        calculator.pressDotKey(".");
        calculator.pressDigitKey(2);
        calculator.pressDigitKey(3);
        assertEquals("1.23", calculator.readScreen());
        calculator.pressBinaryOperationKey("x");
        calculator.pressDigitKey(4);
        calculator.pressDigitKey(5);
        calculator.pressEqualsKey();
        assertEquals("55.35", calculator.readScreen());
        calculator.pressClearKey();
        assertNotEquals("55.35", calculator.readScreen());
        assertNotEquals(1.23, calculator.getLatestValue());
        assertNotEquals(45, calculator.getLatestValue());
        assertNotEquals(1, calculator.getLatestOperation().length());



    }

    @Test
    @DisplayName("should display the intermediate result of a binary operation upon pressing an operation key instead of '='")
    void testIntermediateResult(){
        Calculator calculator = new Calculator();
      //  System.out.println("hi");
        calculator.pressDigitKey(1);
        calculator.pressDigitKey(1);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(1);
        calculator.pressDigitKey(1);
        calculator.pressBinaryOperationKey("/");
       // System.out.println(calculator.readScreen());
        assertEquals("22", calculator.readScreen());
    }


}

