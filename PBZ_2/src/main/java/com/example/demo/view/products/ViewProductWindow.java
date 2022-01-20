package com.example.demo.view.products;

import com.example.demo.controller.ProductController;
import com.example.demo.model.Product;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.sql.SQLException;
import java.util.List;

public class ViewProductWindow {
    private GridPane viewPane;
    private List<Product> products;
    private final ProductController productController;

    public ViewProductWindow(ProductController productController) {
        this.productController = productController;
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
        viewPane.addRow(0, new Label("List of products:"));
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            viewPane.addRow(i+1, new Label((i+1)+")product name:"+product.getName()+", product group name:"+
                    product.getGroup().getName()));
        }

    }

    private void fillTable() throws SQLException {
        products = productController.viewProductsList();
    }

}
