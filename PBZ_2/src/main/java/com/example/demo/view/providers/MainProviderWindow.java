package com.example.demo.view.providers;
import com.example.demo.controller.ProviderController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

public record MainProviderWindow(ProviderController providerController) {

    public void showWindow() {

        Button addButton = new Button("Add provider");
        Button deleteButton = new Button("Delete provider");
        Button changeButton = new Button("Change provider");
        Button viewButton = new Button("View providers list");

        VBox pane = new VBox(addButton, deleteButton, changeButton, viewButton);

        ButtonType closeButton = new ButtonType("Close");

        Alert window = new Alert(Alert.AlertType.NONE);
        window.getDialogPane().setContent(pane);
        window.getButtonTypes().addAll(closeButton);
        window.show();

        addButton.setOnAction(ae -> {
            AddProviderWindow addProviderWindow = new AddProviderWindow(providerController);
            addProviderWindow.showWindow();
        });

        deleteButton.setOnAction(ae -> {
            DeleteProviderWindow deleteProviderWindow = new DeleteProviderWindow(providerController);
            deleteProviderWindow.showWindow();
        });

        changeButton.setOnAction(ae -> {
            ChangeProviderWindow changeProviderWindow = new ChangeProviderWindow(providerController);
            changeProviderWindow.showWindow();
        });

        viewButton.setOnAction(ae -> {
            ViewProvidersWindow viewProvidersWindow = new ViewProvidersWindow(providerController);
            viewProvidersWindow.showWindow();
        });
    }

}
