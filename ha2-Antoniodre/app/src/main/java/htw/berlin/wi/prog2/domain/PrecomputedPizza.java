package htw.berlin.wi.prog2.domain;

import java.util.List;

public class PrecomputedPizza implements Pizza {

    double price;
    int calories;
    List<String> IngredientNames;

    @Override
    public double calculatePrice() { return this.price; }

    @Override
    public int calculateCalories() {
        return this.calories;
    }

    @Override
    public List<String> getIngredientNames() {
        return this.IngredientNames;
    }

    public PrecomputedPizza (double price, int calories,  List<String> IngredientNames){
        this.price = price;
        this.calories = calories;
        this.IngredientNames = IngredientNames;
    }
}
