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

    // Neuer grüner Test
    // Teilaufgabe 1
    @Test
    @DisplayName("should dispaly result after subtracting a multi-digit number from a positive multi-digit number")
    void testSubstraction() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(7);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "50";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    // 1 Neuer roter Test
    // Teilaufgabe 2

    @Test
    @DisplayName("should display percentage")
    void testPercentage() {
        Calculator calc = new Calculator ();
        calc.pressDigitKey(7);
        calc.pressUnaryOperationKey("%");
        calc.pressEqualsKey();

        String expected = "0.07";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

}


