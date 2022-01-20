package com.example.demo.view.recipes;

import com.example.demo.controller.RecipesController;
import com.example.demo.model.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.sql.SQLException;

public class DeleteRecipeWindow {
    private GridPane deletePane;
    private final RecipesController recipesController;
    private Alert window;

    public DeleteRecipeWindow(RecipesController recipesController) {
        this.recipesController = recipesController;
    }


    public void showWindow() {
        initialPane();

        ButtonType closeButton = new ButtonType("Close");

        window = new Alert(Alert.AlertType.NONE);
        window.getDialogPane().setContent(deletePane);
        window.getButtonTypes().addAll(closeButton);
        window.show();
    }

    private void initialPane() {
        deletePane = new GridPane();
        TextField nameTextField = new TextField();

        Button deleteButton = new Button("Delete recipe");
        deleteButton.setOnAction(ae-> {
            Recipe recipe = new Recipe(nameTextField.getText(), "",
                    new Author(), new IngredientList());
            try {
                deleteRecipe(recipe);
                window.close();
            } catch (SQLException e) {
                Alert warnWind = new Alert(Alert.AlertType.WARNING);
                warnWind.setContentText("incorrect input!");
                warnWind.show();
            }
        });

        deletePane.addRow(0, new Label("name:"), nameTextField);
        deletePane.addRow(1, deleteButton);


    }
    private void deleteRecipe(Recipe recipe) throws SQLException {
        recipesController.deleteRecipe(recipe);
    }
}
