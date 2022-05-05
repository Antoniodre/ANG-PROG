package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.*;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}

    public static Map<Integer, Ingredient> base = Map.of(
            1, new Ingredient("American-style", 0.6, 120),
            2, new Ingredient("Italian-style", 0.7, 100));
    public static Map<Integer, Ingredient> protein = Map.of(
            3, new Ingredient("Schinken", 0.9, 90),
            4, new Ingredient("Seitan-Chicken", 0.9, 80));
    public static Map<Integer, Ingredient> topping = Map.of(
            5, new Ingredient("Kirschtomaten", 0.4, 20),
            6, new Ingredient("Champignons", 0.6, 30),
            7, new Ingredient("Mozzarella", 0.6, 40),
            8, new Ingredient("Basilikum", 0.3, 20));
    public static Map<Integer, Ingredient> sauces = Map.of(
            9, new Ingredient("Tomatensauce", 0.3, 40),
            10, new Ingredient("Olivenöl", 0.3, 40));

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
