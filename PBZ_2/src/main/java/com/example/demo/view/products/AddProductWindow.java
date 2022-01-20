package com.example.demo.view.products;

import com.example.demo.controller.ProductController;
import com.example.demo.model.Product;
import com.example.demo.model.ProductGroup;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;

public class AddProductWindow {
    private GridPane addPane;
    private final ProductController productController;
    private Alert window;

    public AddProductWindow(ProductController productController) {
        this.productController = productController;
    }

    public void showWindow() {
        initialPane();

        ButtonType closeButton = new ButtonType("Close");

        window = new Alert(Alert.AlertType.NONE);
        window.getDialogPane().setContent(addPane);
        window.getButtonTypes().addAll(closeButton);
        window.show();
    }

    private void initialPane() {
        addPane = new GridPane();
        TextField nameTextField = new TextField();
        TextField groupTextField = new TextField();
        Button addButton = new Button("Create");
        addButton.setOnAction(ae-> {
            Product newProduct = new Product(nameTextField.getText(), new ProductGroup(groupTextField.getText()));
            try {
                addProduct(newProduct);
                window.close();
            } catch (SQLException e) {
                Alert warnWind = new Alert(Alert.AlertType.WARNING);
                warnWind.setContentText("incorrect input!");
                warnWind.show();
            }
        });

        addPane.addRow(0, new Label("name:"), nameTextField);
        addPane.addRow(1, new Label("group(name):"), groupTextField);
        addPane.addRow(2, addButton);
    }
    private void addProduct (Product product) throws SQLException {
        productController.addProduct(product);
    }
}
