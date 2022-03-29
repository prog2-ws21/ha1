package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.*;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}

    public static Map<Integer, Ingredient> base = Map.of(
            1, new Ingredient("Reis", 0.6, 120),
            2, new Ingredient("Quinoa", 0.7, 100));
    public static Map<Integer, Ingredient> protein = Map.of(
            3, new Ingredient("Lachs", 0.9, 90),
            4, new Ingredient("Tofu", 0.9, 80));
    public static Map<Integer, Ingredient> topping = Map.of(
            5, new Ingredient("Tomate", 0.4, 20),
            6, new Ingredient("Edamame", 0.6, 30),
            7, new Ingredient("Avocado", 0.6, 40),
            8, new Ingredient("Zwiebeln", 0.3, 20));
    public static Map<Integer, Ingredient> sauces = Map.of(
            9, new Ingredient("Mayo", 0.3, 40),
            10, new Ingredient("Sesam", 0.3, 40));

    public static Map<Integer, Ingredient> getAllArticles() {
        Map<Integer, Ingredient> articles = new HashMap<>();
        articles.putAll(base);
        articles.putAll(protein);
        articles.putAll(topping);
        articles.putAll(sauces);
        return articles;
    }

    public static List<String> getAllArticleNames() {
        Collection<Ingredient> articles = getAllArticles().values();
        List<String> names = new ArrayList<>();
        for (Ingredient art : articles) names.add(art.getName());
        return names;
    }
}
