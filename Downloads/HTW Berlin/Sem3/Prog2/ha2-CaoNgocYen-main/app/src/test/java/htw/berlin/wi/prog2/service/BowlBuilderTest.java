package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.Bowl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BowlBuilderTest {

    private final BowlBuilder builder  = new BowlBuilder();

    private final Ingredient lachs = new Ingredient("Lachs", 0.01, 2000);
    private final Ingredient reis = new Ingredient("Reis", 0.02, 1000);

    @Test
    @DisplayName("can build a precomputed bowl with two ingredients")
    void buildABowl() {
        Bowl bowl = builder.add(reis).add(lachs).buildPrecomputed();

        assertEquals(List.of("Reis", "Lachs"), bowl.getIngredientNames());
        assertEquals(0.03, bowl.calculatePrice());
        assertEquals(3000, bowl.calculateCalories());
    }

    @Test
    @DisplayName("can build two precomputed bowls after another without mixing things up")
    void buildTwoBowls() {
        Bowl bowl1 = builder.add(reis).add(lachs).buildPrecomputed();
        Bowl bowl2 = builder.add(reis).add(reis).buildPrecomputed();

        assertEquals(List.of("Reis", "Lachs"), bowl1.getIngredientNames());
        assertEquals(List.of("Reis", "Reis"), bowl2.getIngredientNames());
    }

    @Test
    @DisplayName("can build a dynamically computed bowl with two ingredients")
    void buildABowlDynamically() {
        Bowl bowl = builder.add(reis).add(lachs).buildDynamicallyComputed();

        assertEquals(List.of("Reis", "Lachs"), bowl.getIngredientNames());
        assertEquals(0.03, bowl.calculatePrice());
        assertEquals(3000, bowl.calculateCalories());
    }

    @Test
    @DisplayName("can build two dynamically computed bowles after another without mixing things up")
    void buildTwoBowlesDynamically() {
        Bowl bowl1 = builder.add(reis).add(lachs).buildDynamicallyComputed();
        Bowl bowl2 = builder.add(reis).add(reis).buildDynamicallyComputed();

        assertEquals(List.of("Reis", "Lachs"), bowl1.getIngredientNames());
        assertEquals(List.of("Reis", "Reis"), bowl2.getIngredientNames());
    }

    // Diese folgenden Tests sind keine typischen Tests, da sie testen, wie Sie etwas im Detail implementiert haben
    @Test
    @DisplayName("a dynamically computed bowl should have only one field, which is the list of ingredients")
    void buildDynamicallyComputed() {
        Bowl bowl = builder.add(reis).add(lachs).buildDynamicallyComputed();

        var clazz = bowl.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(1, fields.length);
        assertEquals("java.util.List<htw.berlin.wi.prog2.domain.Ingredient>", fields[0].getGenericType().getTypeName());
    }

    @Test
    @DisplayName("a precomputed bowl should have three field for the precomputed values")
    void buildPrecomputed() {
        Bowl bowl = builder.add(reis).add(lachs).buildPrecomputed();

        var clazz = bowl.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(3, fields.length);
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(int.class));
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(double.class));
    }

    // TODO hier mind. einen Test hinzufügen, der das korrekte Werfen der IllegalBowlException testet (assertThrows)
}
