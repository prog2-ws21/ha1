package htw.berlin.wi.prog2.domain;

import java.util.List;

public class PrecomputedBowl {
    private final double totalPrice;
    private final int totalCalories;
    private final List<String> ingredientNames;

    public PrecomputedBowl(double totalPrice, int totalCalories, List<String> ingredientName){
        this.totalPrice = totalPrice;
        this.totalCalories = totalCalories;
        this.ingredientNames = ingredientName;
    }

}
