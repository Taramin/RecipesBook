package com.example.demo.view.recipes;

import com.example.demo.controller.RecipesController;
import com.example.demo.model.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddRecipeWindow {
    private GridPane addPane;
    private List <Ingredient> ingredientList;
    private final RecipesController recipesController;
    private Alert window;
    private int ingListId = 4;

    public AddRecipeWindow(RecipesController recipesController) {
        this.recipesController = recipesController;
    }

    public void showWindow() {
        initialPane();

        try {
            ingListId = recipesController.getStartId();
        } catch (SQLException ignored) {
        }

        ButtonType closeButton = new ButtonType("Close");

        window = new Alert(Alert.AlertType.NONE);
        window.getDialogPane().setContent(addPane);
        window.getButtonTypes().addAll(closeButton);
        window.show();
    }

    private void initialPane() {
        ingredientList = new ArrayList<>();

        addPane = new GridPane();
        TextField nameTextField = new TextField();
        TextField descriptionTextField = new TextField();
        TextField authorNameTextField = new TextField();
        TextField authorSurnameTextField = new TextField();
        TextField authorCountryTextField = new TextField();
        TextField authorYearTextField = new TextField();
        TextField countIngredientsTextField = new TextField();
        TextField authorTextField = new TextField();

        Button addButton = new Button("Add recipe");
        addButton.setOnAction(ae-> {
            try {
                ingListId = recipesController.getStartId();
            } catch (SQLException ignored) {
            }

            Recipe newRecipe = new Recipe(nameTextField.getText(), descriptionTextField.getText(),
                    new Author(authorTextField.getText(), "", "", 0),
                    new IngredientList(ingredientList, ingListId));
            try {
                addRecipe(newRecipe);
                window.close();
            } catch (SQLException e) {
                Alert warnWind = new Alert(Alert.AlertType.WARNING);
                warnWind.setContentText("incorrect input!");
                warnWind.show();
            }
        });

        Button confirmIngredients = new Button("Add ingredients");
        confirmIngredients.setOnAction(ae -> {
            int countOfIngredients = Integer.parseInt(countIngredientsTextField.getText());
            for (int i = 0; i < countOfIngredients; i++) {
                GridPane addIngredientPane = new GridPane();

                TextField nameIngredientTextField = new TextField();
                TextField weightIngredientTextField = new TextField();
                TextField caloriesNumberIngredientTextField = new TextField();
                TextField cookingWayIngredientTextField = new TextField();
                TextField productNameIngredientTextField = new TextField();
                Button closeButton = new Button("Confirm");

                addIngredientPane.addRow (0, new Label("name:"), nameIngredientTextField);
               addIngredientPane.addRow (1, new Label("weight:"), weightIngredientTextField);
               addIngredientPane.addRow (2, new Label("calories number:"), caloriesNumberIngredientTextField);
               addIngredientPane.addRow (3, new Label("COOKING WAY:"));
                addIngredientPane.addRow (4, new Label("name:"), cookingWayIngredientTextField);
                addIngredientPane.addRow (5, new Label("PRODUCT:"));
                addIngredientPane.addRow (6, new Label("name:"), productNameIngredientTextField);
               addIngredientPane.addRow (7, closeButton);


                ButtonType closeIngButton = new ButtonType("Close");

                Alert window = new Alert(Alert.AlertType.NONE);
                window.getDialogPane().setContent(addIngredientPane);
                window.getButtonTypes().addAll(closeIngButton);
                window.show();

                closeButton.setOnAction(ace-> {
                    try {
                        Ingredient ingredient = new Ingredient(nameIngredientTextField.getText(),
                                Integer.parseInt(weightIngredientTextField.getText()),
                                Double.parseDouble(caloriesNumberIngredientTextField.getText()),
                                new CookingWay(cookingWayIngredientTextField.getText()),
                                new Product(productNameIngredientTextField.getText(),
                                        new ProductGroup("")));
                        ingredientList.add(ingredient);
                        recipesController.createIngredient(ingredient, ingListId);
                    } catch (SQLException e) {
                        Alert warnWind = new Alert(Alert.AlertType.WARNING);
                        warnWind.setContentText("incorrect input!");
                        warnWind.show();
                    } finally {
                        window.close();
                    }
                });
            }
        });

        Button cleanIngredients = new Button("Clean ingredients");
        cleanIngredients.setOnAction(ae -> ingredientList.clear());

        Button addAuthorButton = new Button("Add author");
        addAuthorButton.setOnAction(ae-> {
            ButtonType closeButton = new ButtonType("Close");

            Button addAuthorConfirmButton = new Button("Confirm");
            addAuthorConfirmButton.setOnAction(actionEvent -> {
                Author author = new Author(authorNameTextField.getText(),
                        authorSurnameTextField.getText(),
                        authorCountryTextField.getText(),
                        Integer.parseInt(authorYearTextField.getText()));
                try {
                    recipesController.addAuthor(author);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            GridPane addAuthorPane = new GridPane();
            addAuthorPane.addRow(0, new Label("AUTHOR:"));
            addAuthorPane.addRow(1, new Label("name:"), authorNameTextField);
            addAuthorPane.addRow(2, new Label("surname:"), authorSurnameTextField);
            addAuthorPane.addRow(3, new Label("country:"), authorCountryTextField);
            addAuthorPane.addRow(4, new Label("year:"), authorYearTextField);
            addAuthorPane.addRow(5, addAuthorConfirmButton);


            Alert addAuthorWindow = new Alert(Alert.AlertType.NONE);
            addAuthorWindow.getDialogPane().setContent(addAuthorPane);
            addAuthorWindow.getButtonTypes().addAll(closeButton);
            addAuthorWindow.show();
        });

        addPane.addRow(0, new Label("name:"), nameTextField);
        addPane.addRow(1, new Label("description:"), descriptionTextField);
        addPane.addRow(2, new Label("AUTHOR:"));
        addPane.addRow(3, new Label("name:"), authorTextField);
        addPane.addRow(4, addAuthorButton);
        addPane.addRow(5, new Label("count of ingredients:"), countIngredientsTextField);
        addPane.addRow(6, confirmIngredients, cleanIngredients);
        addPane.addRow(7, addButton);


    }
    private void addRecipe(Recipe recipe) throws SQLException {
        recipesController.addRecipe(recipe);
    }
}
