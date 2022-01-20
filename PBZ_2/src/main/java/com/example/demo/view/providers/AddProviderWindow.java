package com.example.demo.view.providers;

import com.example.demo.controller.ProviderController;
import com.example.demo.model.Provider;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;

public class AddProviderWindow {
    private GridPane addPane;
    private final ProviderController providerController;
    private Alert window;

    public AddProviderWindow(ProviderController providerController) {
        this.providerController = providerController;
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
        TextField phoneNumberTextField = new TextField();
        TextField addressTextField = new TextField();

        Button addButton = new Button("Create");
        addButton.setOnAction(ae-> {
            Provider newProvider = new Provider(nameTextField.getText(), phoneNumberTextField.getText(), addressTextField.getText());
            try {
                addProvider(newProvider);
                window.close();
            } catch (SQLException e) {
                Alert warnWind = new Alert(Alert.AlertType.WARNING);
                warnWind.setContentText("incorrect input!");
                warnWind.show();
            }
        });

        addPane.addRow(0, new Label("name:"), nameTextField);
        addPane.addRow(1, new Label("phone number:"), phoneNumberTextField);
        addPane.addRow(2, new Label("address:"), addressTextField);
        addPane.addRow(3, addButton);
    }
    private void addProvider (Provider provider) throws SQLException {
        providerController.addProvider(provider);
    }
}
