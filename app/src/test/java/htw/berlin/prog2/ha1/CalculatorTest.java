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
//    TODO 1x green test
    @Test
    @DisplayName("Should display the product as a result of two positive numbers")
    void testMultiplication(){
        Calculator calculator = new Calculator();
        calculator.pressDigitKey(8);
        calculator.pressBinaryOperationKey("x");
        calculator.pressDigitKey(5);
        calculator.pressEqualsKey();

        String expected = "40";
        String actual = calculator.readScreen();
        assertEquals(expected, actual);
    }
//    TODO 1st RED test
//    ideas: adding 1 or 2 negative numbers, changing number sign with +/- button,
//    adding, sub., etc. decimal numbers, dividing by a sq.rt number 18/ ^4, etc.
    @Test
    @DisplayName("should display result of the multiplication of two negative numbers")
    void testNegativeMultiplication(){
        Calculator calc = new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressNegativeKey();
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "15";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display quotient of number and percent")
    void testDivisionByPercent(){
        Calculator c = new Calculator();
        c.pressDigitKey(4);
        c.pressBinaryOperationKey("/");
        c.pressDigitKey(5);
        c.pressDigitKey(0);
        c.pressUnaryOperationKey("%");
        c.pressEqualsKey();

        String expected = "2";
        String actual = c.readScreen();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display negative number after pressing digit key")
    void testPressNegativeFirst(){
        Calculator calc = new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(5);

        String expected = "-5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

//    TODO 2nd RED test
//    TODO 2x bugfixes for each red test

}

