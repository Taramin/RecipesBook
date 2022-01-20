package com.example.demo.view.providers;

import com.example.demo.controller.ProviderController;
import com.example.demo.model.Provider;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;

public class DeleteProviderWindow {
    private GridPane deletePane;
    private final ProviderController providerController;
    private Alert window;

    public DeleteProviderWindow(ProviderController providerController) {
        this.providerController = providerController;
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

        Button deleteButton = new Button("Delete provider");
        deleteButton.setOnAction(ae-> {
            Provider provider = new Provider(nameTextField.getText(), "", "");
            try {
                deleteProvider(provider);
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
    private void deleteProvider (Provider provider) throws SQLException {
        providerController.deleteProvider(provider);
    }
}
