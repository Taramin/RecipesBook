package com.example.demo.view.providers;

import com.example.demo.controller.ProviderController;

public record ChangeProviderWindow(ProviderController providerController) {

    public void showWindow() {
        AddProviderWindow changeAddOperation = new AddProviderWindow(providerController);
        changeAddOperation.showWindow();

        DeleteProviderWindow changeDelOperation = new DeleteProviderWindow(providerController);
        changeDelOperation.showWindow();

    }

}
