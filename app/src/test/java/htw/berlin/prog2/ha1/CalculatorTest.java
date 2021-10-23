package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.Assertions;
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
    @DisplayName("should display result after subtracting two positive numbers")
    void testSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("nachdem man clear taste drückt, werden latestvalue und latestoperation in der online version nicht verändert, falls latest operation eingegeben wurde")
    void testClearKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressClearKey();
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        String expected = "6";
        String actual = calc.readScreen();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("wenn man pressDigit benutzt und dann pressEquals benutzt, ohne vorher noch einen operator zu benutzen, dann bekommt man einen fehler. In der online version wird einfach der latest value angezeigt")
    void testEqualsWithoutOperation() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        String expected = "3";
        String actual = calc.readScreen();
        Assertions.assertEquals(expected, actual);
    }
}

