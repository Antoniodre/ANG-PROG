package htw.berlin.wi.prog2.domain;

import java.util.ArrayList;
import java.util.List;

public class DynamicallyComputedPizza implements Pizza{

    List<Ingredient> Ingredients;

    @Override
    public double calculatePrice() {
        double price= 0 ;
        for(int i = 0; i < this.Ingredients.size(); i++){
            Ingredient ingredient = this.Ingredients.get(i);
            price = price + ingredient.getPrice();
        }
        return price;
    }

    @Override
    public int calculateCalories() {
        int calories= 0;
        for(int i = 0; i < this.Ingredients.size(); i++){
            Ingredient ingredient = this.Ingredients.get(i);
            calories = calories + ingredient.getCalories();
        }
        return calories;
    }

    @Override
    public List<String> getIngredientNames() {
        List<String> IngredientsNames = new ArrayList<String>();
        for(int i = 0; i < this.Ingredients.size(); i++){
            Ingredient ingredient = this.Ingredients.get(i);
            IngredientsNames.add(ingredient.getName());
        }
        return IngredientsNames;
    }

    public DynamicallyComputedPizza(List<Ingredient> Ingredients) {
        this.Ingredients = Ingredients;
    }

}
