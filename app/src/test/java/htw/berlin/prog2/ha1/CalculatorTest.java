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
    //Schreiben Sie einen neuen zusätzlichen Test, der eine bisher nicht getestete Funktionalität abdeckt, die bereits funktioniert und der daher direkt grün wird.
    @Test
    @DisplayName("should display result after division by 100")
    void testDivisionBy100() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("%");

        String expected = "0.02";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Schreiben Sie zwei weitere zusätzliche Tests, die zwei unterschiedliche Fehlerkategorien aufdecken (d.h. deren Fehlerursachen in unterschiedlichen Methoden liegen) und somit fehlschlagen.
    @Test
    @DisplayName("should display 'Error' after division by 0")
    void testDivisionBy0() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();


        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // 3. Test
    @Test
    @DisplayName("should display result after subtraction")
    void testSubtraction() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressUnaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();


        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

