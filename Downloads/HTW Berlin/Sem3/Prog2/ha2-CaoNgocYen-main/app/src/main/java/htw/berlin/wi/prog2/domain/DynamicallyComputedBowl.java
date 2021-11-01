package htw.berlin.wi.prog2.domain;

import java.util.Collections;
import java.util.List;

public class DynamicallyComputedBowl {
    private final List<Ingredient> ingredients;

    public DynamicallyComputedBowl(List<Ingredient> ingredients){
        this.ingredients = Collections.unmodifiableList(ingredients);
    }

}
