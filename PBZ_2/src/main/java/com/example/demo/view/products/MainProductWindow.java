package com.example.demo.view.products;

import com.example.demo.controller.ProductController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

public record MainProductWindow(ProductController productController) {

    public void showWindow() {

        Button addButton = new Button("Add product");
        Button deleteButton = new Button("Delete product");
        Button changeButton = new Button("Change product");
        Button viewButton = new Button("View products list");

        VBox pane = new VBox(addButton, deleteButton, changeButton, viewButton);

        ButtonType closeButton = new ButtonType("Close");

        Alert window = new Alert(Alert.AlertType.NONE);
        window.getDialogPane().setContent(pane);
        window.getButtonTypes().addAll(closeButton);
        window.show();

        addButton.setOnAction(ae -> {
            AddProductWindow addProductWindow = new AddProductWindow(productController);
            addProductWindow.showWindow();
        });

        deleteButton.setOnAction(ae -> {
            DeleteProductWindow deleteProductWindow = new DeleteProductWindow(productController);
            deleteProductWindow.showWindow();
        });

        changeButton.setOnAction(ae -> {
            ChangeProductWindow changeProductWindow = new ChangeProductWindow(productController);
            changeProductWindow.showWindow();
        });

        viewButton.setOnAction(ae -> {
            ViewProductWindow viewProductWindow = new ViewProductWindow(productController);
            viewProductWindow.showWindow();
        });

    }
}
