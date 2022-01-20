package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.view.recipes.MainRecipesWindow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipesController {
    private final Statement statement;
    public RecipesController(Statement statement) {
        this.statement = statement;
        MainRecipesWindow mainRecipesWindow = new MainRecipesWindow(this);
        mainRecipesWindow.showWindow();
    }

    public void deleteRecipe(Recipe recipe) throws SQLException {
        String name = recipe.getName();
        String request = "DELETE FROM recipies WHERE recipies.name = '"+name+"';";
        statement.executeUpdate(request);
    }

    public void addRecipe(Recipe recipe) throws SQLException {
        String name = recipe.getName();
        String description = recipe.getDescription();
        int authorId = 0;
        int ingListId = recipe.getIngredientList().getId();

        Author author = recipe.getAuthor();
        String authorRequest = "SELECT id FROM authors WHERE authors.name = '"
                +author.getName()+"';";
        ResultSet authorSet = statement.executeQuery(authorRequest);

        if (authorSet.next()) {
            authorId = authorSet.getInt(1);
        }

        String request = "INSERT INTO recipies (name, description, author_id, ingredients_list_id) " +
                "VALUES ('"+name+"', '"+description+"', '"+authorId+"', '"+ingListId+"');";

        statement.executeUpdate(request);
    }

    public void createIngredient (Ingredient ingredient, int ingListId) throws SQLException {
        String name = ingredient.getName();
        int weight = ingredient.getWeight();
        double caloriesNumb = ingredient.getCaloriesNumber();

        String isIngExistRequest = "SELECT id FROM ingredients WHERE " +
                "ingredients.name = '" + name + "';";
        ResultSet  isIngExistSet = statement.executeQuery( isIngExistRequest);

        if (!isIngExistSet.next()) {
            CookingWay cookingWay = ingredient.getCookingWay();
            int cookingWayId = '0';
            String cookWayRequest = "SELECT id FROM cooking_ways WHERE cooking_ways.name = '"
                    +cookingWay.getName()+"';";
            ResultSet cWSet = statement.executeQuery(cookWayRequest);

            if (cWSet.next()) {
                cookingWayId = cWSet.getInt(1);
            }

            Product product = ingredient.getProduct();
            int productId = '0';
            String productRequest = "SELECT id FROM products WHERE products.name = '"
                    +product.getName()+"';";
            ResultSet prodSet = statement.executeQuery(productRequest);

            if (prodSet.next()) {
                productId = prodSet.getInt(1);
            }

            String request = "INSERT INTO ingredients(name, weight, calories_number, " +
                    "ingredients_list_id, cooking_way_id, product_id) VALUES (" +
                    "'" + name + "', '"+weight + "', '" + caloriesNumb + "', '" + ingListId
                    + "', '"+ cookingWayId+"', '" + productId + "');";

            statement.executeUpdate(request);
        }
    }

    public int getStartId() throws SQLException {
        String request = "INSERT INTO ingredients_lists() VALUES ();";
        statement.executeUpdate(request);

        String maxIdRequest = "SELECT MAX(ingredients_lists.id) FROM ingredients_lists;";
        ResultSet maxIdSet = statement.executeQuery(maxIdRequest);

        int maxId = 0;
        if (maxIdSet.next()) {
           maxId = maxIdSet.getInt(1);
        }

        return maxId;
    }

    public void addAuthor(Author author) throws SQLException {
        String name = author.getName();
        String surname = author.getSurname();
        String country = author.getCountry();
        int year = author.getYear();

        String isAuthExistRequest = "SELECT id FROM authors WHERE " +
                "authors.name = '" + name + "';";
        ResultSet isAuthExistSet = statement.executeQuery(isAuthExistRequest);

        if (!isAuthExistSet.next()) {
            String request = "INSERT INTO authors(name, surname, country, year) " +
                    "VALUES ('" + name + "', '" + surname + "', '" + country + "', '" + year + "');";

            statement.executeUpdate(request);
        }
    }

    public List<Recipe> viewRecipesLists() throws SQLException {
        List<Recipe> resultList = new ArrayList<>();
        String request = "SELECT recipies.name, recipies.description, authors.name, authors.surname FROM recipies\n" +
                "  JOIN authors ON recipies.author_id = authors.id;";
        ResultSet resultSet = statement.executeQuery(request);

        while (resultSet.next()) {
            String name = resultSet.getString(1);
            String description = resultSet.getString(2);
            String authorName = resultSet.getString(3);
            String authorSurname = resultSet.getString(4);


            Recipe recipe = new Recipe(name, description, new Author(authorName, authorSurname, "", 0), new IngredientList());
            resultList.add(recipe);
        }

        return resultList;
    }
}
