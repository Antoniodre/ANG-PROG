package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.Pizza;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PizzaBuilderTest {

    private final PizzaBuilder builder  = new PizzaBuilder();

    private final Ingredient sauce = new Ingredient("Tomatensauce", 0.01, 2000);
    private final Ingredient teig = new Ingredient("Teig", 0.02, 1000);

    @Test
    @DisplayName("can build a precomputed pizza with two ingredients")
    void buildAPizza() {
        Pizza pizza = builder.add(teig).add(sauce).buildPrecomputed();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza.getIngredientNames());
        assertEquals(0.03, pizza.calculatePrice());
        assertEquals(3000, pizza.calculateCalories());
    }

    @Test
    @DisplayName("can build two precomputed pizzas after another without mixing things up")
    void buildTwoPizzas() {
        Pizza pizza1 = builder.add(teig).add(sauce).buildPrecomputed();
        Pizza pizza2 = builder.add(teig).add(teig).buildPrecomputed();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza1.getIngredientNames());
        assertEquals(List.of("Teig", "Teig"), pizza2.getIngredientNames());
    }

    @Test
    @DisplayName("can build a dynamically computed pizza with two ingredients")
    void buildAPizzaDynamically() {
        Pizza pizza = builder.add(teig).add(sauce).buildDynamicallyComputed();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza.getIngredientNames());
        assertEquals(0.03, pizza.calculatePrice());
        assertEquals(3000, pizza.calculateCalories());
    }

    @Test
    @DisplayName("can build two dynamically computed pizzaes after another without mixing things up")
    void buildTwoPizzaesDynamically() {
        Pizza pizza1 = builder.add(teig).add(sauce).buildDynamicallyComputed();
        Pizza pizza2 = builder.add(teig).add(teig).buildDynamicallyComputed();

        assertEquals(List.of("Teig", "Tomatensauce"), pizza1.getIngredientNames());
        assertEquals(List.of("Teig", "Teig"), pizza2.getIngredientNames());
    }

    // Diese folgenden Tests sind keine typischen Tests, da sie testen, wie Sie etwas im Detail implementiert haben
    @Test
    @DisplayName("a dynamically computed pizza should have only one field, which is the list of ingredients")
    void buildDynamicallyComputed() {
        Pizza pizza = builder.add(teig).add(sauce).buildDynamicallyComputed();

        var clazz = pizza.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(1, fields.length);
        assertEquals("java.util.List<htw.berlin.wi.prog2.domain.Ingredient>", fields[0].getGenericType().getTypeName());
    }

    @Test
    @DisplayName("a precomputed pizza should have three field for the precomputed values")
    void buildPrecomputed() {
        Pizza pizza = builder.add(teig).add(sauce).buildPrecomputed();

        var clazz = pizza.getClass();
        var fields = clazz.getDeclaredFields();
        assertEquals(3, fields.length);
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(int.class));
        assertTrue(Arrays.stream(fields).map(Field::getType).collect(Collectors.toList()).contains(double.class));
    }
    @Test
    @DisplayName("a pizza should have at least two Ingredients")
    void atleats2Ingredients(){

        assertThrows(IllegalPizzaException.class, () -> {
            Pizza pizza = builder.add(teig).buildPrecomputed();
        });

        assertThrows(IllegalPizzaException.class, () -> {
            Pizza pizza2 = builder.add(teig).buildDynamicallyComputed();
        });

        assertThrows(IllegalPizzaException.class, () -> {
            Pizza pizza3 = builder.buildPrecomputed();
        });

        assertThrows(IllegalPizzaException.class, () -> {
            Pizza pizza4 = builder.buildDynamicallyComputed();
        });
    }
}
