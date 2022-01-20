package com.example.demo.model;

public class Author {
    private String name;
    private String surname;
    private String country;
    private int year;

    public Author(String name, String surname, String country, int year) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.year = year;
    }

    public Author() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
