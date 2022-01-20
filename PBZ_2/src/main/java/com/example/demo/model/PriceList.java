package com.example.demo.model;

import java.util.Objects;

public final class PriceList {
    private final String date;
    private final double price;
    private final Provider provider;
    private final Ingredient ingredient;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public PriceList(String date, double price, Provider provider, Ingredient ingredient) {
        this.date = date;
        this.price = price;
        this.provider = provider;
        this.ingredient = ingredient;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Provider getProvider() {
        return provider;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PriceList) obj;
        return Objects.equals(this.date, that.date) &&
                Double.doubleToLongBits(this.price) == Double.doubleToLongBits(that.price) &&
                Objects.equals(this.provider, that.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, price, provider);
    }

    @Override
    public String toString() {
        return "PriceList[" +
                "date=" + date + ", " +
                "price=" + price + ", " +
                "provider=" + provider + ']';
    }

}
