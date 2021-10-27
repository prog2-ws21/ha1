package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {
    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("no error should accure when pressing . twice")
        //RedResult

    void testDotKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(0);
        calc.pressDotKey(".");
        calc.pressDotKey(".");
        calc.pressDigitKey(5);


        String expected = "40.5";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }


}

