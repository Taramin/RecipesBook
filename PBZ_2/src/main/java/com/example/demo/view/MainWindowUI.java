package com.example.demo.view;

import com.example.demo.controller.ProductController;
import com.example.demo.controller.ProviderController;
import com.example.demo.controller.RecipesController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Statement;

public class MainWindowUI {

    private final Pane resultPane;
    private final Statement statement;

    public Pane getResultPane() {
        return resultPane;
    }

    public MainWindowUI(Statement statement) throws FileNotFoundException {
        resultPane = new FlowPane();
        this.statement = statement;
        entryWindow();
    }

    private void entryWindow() throws FileNotFoundException {
        Button productsButton = new Button("show products actions");
        Button providersButton = new Button("show providers actions");
        Button recipesButton = new Button("show recipes action");

        Image image = new Image(new FileInputStream("/home/d/IdeaProjects/demo/src/main/java/com/example/demo/resources/1.jpg"));
        ImageView imageView = new ImageView(image);

        VBox pane = new VBox(productsButton, providersButton, recipesButton);
        HBox imgPane = new HBox(pane, imageView);

        productsButton.setOnMouseClicked((e) -> {
            ProductController productController = new ProductController(statement);
        });

        providersButton.setOnMouseClicked((e) -> {
            ProviderController providerController = new ProviderController(statement);
        });

        recipesButton.setOnMouseClicked((e) -> {
            RecipesController recipesController = new RecipesController(statement);
        });

        resultPane.getChildren().add(imgPane);
    }
}
