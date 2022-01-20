package com.example.demo.model;

public class Ingredient {
    private String name;
    private final int weight;
    private final double caloriesNumber;
    private final CookingWay cookingWay;
    private Product product;

    public Ingredient(String name, int weight, double caloriesNumber, CookingWay cookingWay, Product product) {
        this.name = name;
        this.weight = weight;
        this.caloriesNumber = caloriesNumber;
        this.cookingWay = cookingWay;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public double getCaloriesNumber() {
        return caloriesNumber;
    }

    public CookingWay getCookingWay() {
        return cookingWay;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
