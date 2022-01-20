package com.example.demo.view.recipes;

import com.example.demo.controller.RecipesController;
import com.example.demo.model.Recipe;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.List;

public class ViewRecipeWindow {
    private GridPane viewPane;
    private List<Recipe> recipesLists;
    RecipesController recipesController;

    public ViewRecipeWindow(RecipesController recipesController) {
        this.recipesController = recipesController;
    }

    public void showWindow() {
        try {
            initialPane();
        } catch (SQLException ignored) {
        }

        ButtonType closeButton = new ButtonType("Close");

        Alert window = new Alert(Alert.AlertType.NONE);
        window.getDialogPane().setContent(viewPane);
        window.getButtonTypes().addAll(closeButton);
        window.show();
    }

    private void initialPane() throws SQLException {
        fillTable();

        viewPane = new GridPane();

        viewPane.addRow(0, new Label("List of recipes:"));

        for (int i = 0; i < recipesLists.size(); i++) {
            Recipe recipe = recipesLists.get(i);

            viewPane.addRow(i+1, new Label((i+1)+")name:"+recipe.getName()+", description:"+
                    recipe.getDescription()+ ", author name:"+recipe.getAuthor().getName()+" "+
                    recipe.getAuthor().getSurname()));
        }

    }

    private void fillTable() throws SQLException {
        recipesLists = recipesController.viewRecipesLists();
    }
}
