package com.example.demo.model;

public class Product {
    private String name;
    private final ProductGroup group;

    public Product(String name, ProductGroup group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductGroup getGroup() {
        return group;
    }

}
