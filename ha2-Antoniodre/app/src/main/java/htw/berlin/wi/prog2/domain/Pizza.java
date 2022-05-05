package htw.berlin.wi.prog2.domain;

import java.util.List;

public interface Pizza {
    double calculatePrice();
    int calculateCalories();
    List<String> getIngredientNames();
}
