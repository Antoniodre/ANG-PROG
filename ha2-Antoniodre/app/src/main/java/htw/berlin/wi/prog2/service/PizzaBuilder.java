package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {

    List<Ingredient> Ingredients = new ArrayList<Ingredient>();

    public PizzaBuilder add(Ingredient newingredient) {


            this.Ingredients.add(newingredient);

            return this; // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im PizzaBuilderTest)

    }

    public Pizza buildPrecomputed() throws IllegalPizzaException {
        System.out.println(this.Ingredients.size());
        System.out.println(this.Ingredients.size() < 2);
        if (this.Ingredients.size() < 2) {
            System.out.println("Throw");
            throw new IllegalPizzaException("cannot build pizza with less than two ingredients");
        }

        int calories= 0;
        double price = 0;
        List<String> IngredientsNames = new ArrayList<String>();
        for(int i = 0; i < this.Ingredients.size(); i++){
            Ingredient ingredient = this.Ingredients.get(i);
            IngredientsNames.add(ingredient.getName());
            price = price + ingredient.getPrice();
            calories = calories + ingredient.getCalories();
        }
        this.Ingredients.clear();
        return new PrecomputedPizza(price, calories,IngredientsNames);
    }

    public Pizza buildDynamicallyComputed() throws IllegalPizzaException {
        System.out.println(this.Ingredients.size());
        System.out.println(this.Ingredients.size() < 2);
        if (this.Ingredients.size() < 2) {
            System.out.println("Throw");
            throw new IllegalPizzaException("cannot build pizza with less than two ingredients");
        }

        List<Ingredient> IngredientsCopy = new ArrayList<Ingredient>(this.Ingredients);
        this.Ingredients.clear();
        return new DynamicallyComputedPizza(IngredientsCopy);
    }
}
