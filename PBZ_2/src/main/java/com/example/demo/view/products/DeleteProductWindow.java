package com.example.demo.view.products;

import com.example.demo.controller.ProductController;
import com.example.demo.model.Product;
import com.example.demo.model.ProductGroup;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;

public class DeleteProductWindow {
    private GridPane deletePane;
    private final ProductController productController;
    private Alert window;

    public DeleteProductWindow(ProductController productController) {
        this.productController = productController;
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

        Button deleteButton = new Button("Delete product");
        deleteButton.setOnAction(ae-> {
            Product product = new Product(nameTextField.getText(), new ProductGroup());
            try {
                deleteProduct(product);
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
    private void deleteProduct (Product product) throws SQLException {
        productController.deleteProduct(product);
    }
}
