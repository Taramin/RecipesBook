package com.example.demo.view.recipes;

import com.example.demo.controller.RecipesController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

public record MainRecipesWindow(RecipesController recipesController) {

    public void showWindow() {

        Button addButton = new Button("Add recipe");
        Button deleteButton = new Button("Delete recipe");
        Button changeButton = new Button("Change recipe");
        Button viewButton = new Button("View recipes");


        VBox pane = new VBox(addButton, deleteButton, changeButton, viewButton);

        ButtonType closeButton = new ButtonType("Close");

        Alert window = new Alert(Alert.AlertType.NONE);
        window.getDialogPane().setContent(pane);
        window.getButtonTypes().addAll(closeButton);
        window.show();

        addButton.setOnAction(ae -> {
            AddRecipeWindow addRecipeWindow = new AddRecipeWindow(recipesController);
            addRecipeWindow.showWindow();
        });

        deleteButton.setOnAction(ae -> {
            DeleteRecipeWindow deleteRecipeWindow = new DeleteRecipeWindow(recipesController);
            deleteRecipeWindow.showWindow();
        });

        changeButton.setOnAction(ae -> {
            ChangeRecipeWindow changeRecipeWindow = new ChangeRecipeWindow(recipesController);
            changeRecipeWindow.showWindow();
        });

        viewButton.setOnAction(ae-> {
            ViewRecipeWindow viewRecipeWindow = new ViewRecipeWindow(recipesController);
            viewRecipeWindow.showWindow();
        });

    }
}
