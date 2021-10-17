package htw.berlin.prog2.ha1;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("should display result after subtracting two decimal numbers")
    void testDecimalSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(0);
        calc.pressDotKey();
        calc.pressDigitKey(8);
        calc.pressEqualsKey();

        String expected = "1.7";
        String actual = calc.readScreen();

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("should display 'Error' if the number divided by is 0")
    void testErrorDividingZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("should delete screen output and cache")
    void deleteCache(){
        Calculator calculator = new Calculator();

  /*      calculator.pressDigitKey(5);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(4);

        System.out.println(calculator.readScreen());

        calculator.pressClearKey();
        calculator.pressDigitKey(9);
        calculator.pressEqualsKey();

        System.out.println(calculator.readScreen()); /*
   */

        calculator.pressDigitKey(3);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(9);
        calculator.pressEqualsKey();
        calculator.pressEqualsKey();
        calculator.pressEqualsKey();



        System.out.println(calculator.readScreen());

    }


    @Test
    @DisplayName("should repeat the operator-operand execution")
    void multipleEquals() {
        Calculator calculator = new Calculator();

        calculator.pressDigitKey(3);
        calculator.pressBinaryOperationKey("+");
        calculator.pressDigitKey(9);


        calculator.pressEqualsKey();
        calculator.pressEqualsKey();
        calculator.pressEqualsKey();
        calculator.pressEqualsKey();


        System.out.println(calculator.readScreen());


        String expected = "39";
        assertEquals(expected,calculator.readScreen());

    }



}

