package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInputParserTest {

    @Test
    @DisplayName("can detect ingredients in text input")
    void ingredientsFromInput() {
        // System under test (SUT)
        SimpleInputParser parser = new SimpleInputParser();

        // Test-Daten
        String input = "Ich hätte gerne eine Bowl mit Quinoa, Lachs, Tomate und Mayo.";
        Ingredient quinoa = Menu.base.get(2);
        Ingredient lachs = Menu.protein.get(3);
        Ingredient tomate = Menu.topping.get(5);
        Ingredient mayo = Menu.sauces.get(9);

        List<Ingredient> expected = List.of(quinoa, lachs, tomate, mayo);
        List<Ingredient> actual = parser.ingredientsFromInput(input);

        assertEquals(expected, actual);
    }
}
