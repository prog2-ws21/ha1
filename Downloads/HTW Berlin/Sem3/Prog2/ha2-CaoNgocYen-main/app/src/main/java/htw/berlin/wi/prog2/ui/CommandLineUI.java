package htw.berlin.wi.prog2.ui;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.Bowl;
import htw.berlin.wi.prog2.service.SimpleInputParser;
import htw.berlin.wi.prog2.service.BowlBuilder;

import java.util.*;

public class CommandLineUI {
    private final UserInputWrapper input;
    private final BowlBuilder builder;
    private final SimpleInputParser parser;

    public CommandLineUI(UserInputWrapper uiw, BowlBuilder sb, SimpleInputParser ip) {
        input = uiw;
        builder = sb;
        parser = ip;
    }

    public String launch() {
        String inputLine = input.ask("Willkommen beim Bowl-Bot! Was möchtest du gerne bestellen?");
        while (!(inputLine.equals("Bestellung abschliessen") || inputLine.equals("Auf Wiedersehen"))) {
            List<Ingredient> ingredients = parser.ingredientsFromInput(inputLine);
            if(ingredients.isEmpty()) {
                inputLine = input.ask("Entschuldigung, ich habe dich nicht verstanden. Wähle aus folgenden Zutaten: "
                        + Menu.getAllArticleNames());
            } else {
                for (Ingredient ing : ingredients) builder.add(ing);
                Bowl bowl = builder.buildPrecomputed();
                inputLine = input.ask("In Ordnung. Deine Bowl mit " + bowl.getIngredientNames() +
                        " kostet " + bowl.calculatePrice() + " Euro. Willst du die Bestellung abschliessen?");
            }
        }
        return inputLine;
    }
}
