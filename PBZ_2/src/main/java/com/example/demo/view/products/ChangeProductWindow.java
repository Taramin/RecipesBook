package com.example.demo.view.products;

import com.example.demo.controller.ProductController;

public record ChangeProductWindow(ProductController productController) {

    public void showWindow() {
        AddProductWindow changeAddOperation = new AddProductWindow(productController);
        changeAddOperation.showWindow();

        DeleteProductWindow changeDelOperation = new DeleteProductWindow(productController);
        changeDelOperation.showWindow();

    }

}
