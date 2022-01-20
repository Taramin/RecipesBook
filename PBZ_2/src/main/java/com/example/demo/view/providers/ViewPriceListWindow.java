package com.example.demo.view.providers;

import com.example.demo.controller.ProviderController;
import com.example.demo.model.PriceList;
import com.example.demo.model.Provider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.sql.SQLException;
import java.util.List;

public class ViewPriceListWindow {
    private GridPane viewPane;
    private List<PriceList> priceLists;
    ProviderController providerController;

    public ViewPriceListWindow(ProviderController providerController) {
        this.providerController = providerController;
    }

    public void showWindow() {
        try {
            initialPane();
        } catch (SQLException e) {
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

        viewPane.addRow(0, new Label("List of price lists:"));

        for (int i = 0; i < priceLists.size(); i++) {
            PriceList priceList = priceLists.get(i);

            viewPane.addRow(i+1, new Label((i+1)+")date:"+priceList.getDate()+", price:"+
                    priceList.getPrice()+ ", provider name:"+priceList.getProvider().getName()+
                    ", ingredient name:"+priceList.getIngredient().getName()));
        }

    }

    private void fillTable() throws SQLException {
        priceLists = providerController.viewPriceLists();
    }
}
