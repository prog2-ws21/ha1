package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {
    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should display ERROR after dividing by 0")
        //RedResult
        //Solution to 1st red test
        //if (screen.contains("Infinity")) screen = "Error";
    void testDivisionNull() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);

        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

