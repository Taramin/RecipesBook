package com.example.demo.model;

public class Recipe {
    private String name;
    private final String description;
    private final Author author;
    private final IngredientList ingredientList;

    public Recipe(String name, String description, Author author, IngredientList ingredientList) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.ingredientList = ingredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }

    public IngredientList getIngredientList() {
        return ingredientList;
    }

}
