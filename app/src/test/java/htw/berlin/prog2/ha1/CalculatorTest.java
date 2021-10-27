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

    public void pressDotKey(String s) {
        if (!screen.endsWith(".")) screen = screen + ".";
         //Solution to second red test DotKey
        if (!screen.contains(".")) screen = screen + ".";
        }

}

