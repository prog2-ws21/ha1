package htw.berlin.prog2.ha1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
public class CalculatorTest {

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
    @DisplayName("should calculate the percentage of two number")
    void testPercentage(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("1/x");

        String expected = "0.5";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("the division on zero")

    void testDivisionZero(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("two dot in the number")
    void testNumberOfDot(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(3);


        String expected = "2.13";
        String actual = calc.readScreen();

        assertEquals(expected,actual);



    }

}
