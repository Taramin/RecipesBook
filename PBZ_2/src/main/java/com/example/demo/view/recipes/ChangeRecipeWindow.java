package com.example.demo.view.recipes;

import com.example.demo.controller.RecipesController;

public record ChangeRecipeWindow(RecipesController recipesController) {

    public void showWindow() {
        AddRecipeWindow changeAddOperation = new AddRecipeWindow(recipesController);
        changeAddOperation.showWindow();

        DeleteRecipeWindow changeDelOperation = new DeleteRecipeWindow(recipesController);
        changeDelOperation.showWindow();

    }

}
