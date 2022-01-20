package com.example.demo.view.providers;

import com.example.demo.controller.ProviderController;
import com.example.demo.model.Provider;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.List;

public class ViewProvidersWindow {
    private GridPane viewPane;
    private List<Provider> providers;
    private final ProviderController providerController;

    public ViewProvidersWindow(ProviderController providerController) {
        this.providerController = providerController;
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

        Button priceListButton = new Button("Show price lists");
        priceListButton.setOnAction(ae-> {
            ViewPriceListWindow viewPriceListWindow = new ViewPriceListWindow(providerController);
            viewPriceListWindow.showWindow();
        });

        viewPane.addRow(0, priceListButton);
        viewPane.addRow(1, new Label("List of providers:"));

        for (int i = 0; i < providers.size(); i++) {
            Provider provider = providers.get(i);

            viewPane.addRow(i+2, new Label((i+1)+")provider name:"+provider.getName()+", phone number:"+
                    provider.getPhoneNumber()+", address:"+provider.getAddress()));
        }

    }

    private void fillTable() throws SQLException {
        providers = providerController.viewProvidersList();
    }
}
