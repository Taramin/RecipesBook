package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductGroup;
import com.example.demo.view.products.MainProductWindow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public record ProductController(Statement statement) {

    public ProductController(Statement statement) {
        this.statement = statement;
        MainProductWindow mainProductWindow = new MainProductWindow(this);
        mainProductWindow.showWindow();
    }

    public List<Product> viewProductsList() throws SQLException {
        List<Product> resultList = new ArrayList<>();
        String request = "SELECT products.name, product_groups.name FROM products" +
                " JOIN product_groups ON products.product_group_id = product_groups.id;";
        ResultSet resultSet = statement.executeQuery(request);

        while (resultSet.next()) {
            String name = resultSet.getString(1);
            String prodGroupName = resultSet.getString(2);

            Product product = new Product(name, new ProductGroup(prodGroupName));
            resultList.add(product);
        }

        return resultList;
    }

    public void deleteProduct(Product product) throws SQLException {
        String name = product.getName();
        String request = "DELETE FROM products WHERE products.name = '" + name + "';";
        statement.executeUpdate(request);
    }

    public void addProduct(Product product) throws SQLException {
        String name = product.getName();
        int id = '0';
        ProductGroup productGroup = product.getGroup();
        String pgIdRequest = "SELECT id FROM product_groups WHERE product_groups.name = '"
                + productGroup.getName() + "';";
        ResultSet pgIdSet = statement.executeQuery(pgIdRequest);

        if (pgIdSet.next()) {
            id = pgIdSet.getInt(1);
        }
        String request = "  INSERT INTO products(name, product_group_id)" +
                "VALUES ('" + name + "', '" + id + "');";

        statement.executeUpdate(request);

    }
}
