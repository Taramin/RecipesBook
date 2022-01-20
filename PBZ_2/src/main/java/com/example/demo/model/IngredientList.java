package com.example.demo.model;

import java.util.List;

public class IngredientList {
    private int id;
    private List<Ingredient> ingredients;

    public int getId() {
        return id;
    }

    public IngredientList(List<Ingredient> ingredients, int id) {
        this.ingredients = ingredients;
        this.id = id;
    }

    public IngredientList() {}

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}
