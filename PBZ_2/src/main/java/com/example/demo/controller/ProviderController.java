package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.view.providers.MainProviderWindow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProviderController {
    private final Statement statement;

    public ProviderController(Statement statement) {
        this.statement = statement;
        MainProviderWindow mainProviderWindow = new MainProviderWindow(this);
        mainProviderWindow.showWindow();
    }
    public List<Provider> viewProvidersList() throws SQLException {
        List<Provider> resultList = new ArrayList<>();
        String request = "SELECT * FROM providers;";
        ResultSet resultSet = statement.executeQuery(request);

        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String phoneNumber = resultSet.getString(3);
            String address = resultSet.getString(4);

            Provider provider = new Provider(name, phoneNumber, address);
            resultList.add(provider);
        }

        return resultList;
    }
    public void deleteProvider(Provider provider) throws SQLException {
        String name = provider.getName();
        String request = "DELETE FROM providers WHERE providers.name = '"+name+"';";
        statement.executeUpdate(request);
    }

    public void addProvider(Provider provider) throws SQLException {
        String name = provider.getName();
        String phoneNumber = provider.getPhoneNumber();
        String address = provider.getAddress();

        String request = "INSERT INTO providers(name, phone_number, address)" +
                "VALUES ('"+name+"', '"+phoneNumber+"', '"+address+"');";

        statement.executeUpdate(request);

    }

    public List<PriceList> viewPriceLists() throws SQLException {
        List<PriceList> resultList = new ArrayList<>();
        String request = "SELECT price_lists.date, price_lists.price, providers.name, ingredients.name \n" +
                "  FROM price_lists JOIN providers ON price_lists.provider_id = providers.id\n" +
                "  JOIN ingredients ON price_lists.ingredient_id = ingredients.id;";
        ResultSet resultSet = statement.executeQuery(request);

        while (resultSet.next()) {
            String date = resultSet.getDate(1).toString();
            float price = resultSet.getFloat(2);
            String providerName = resultSet.getString(3);
            String ingName = resultSet.getString(4);

            PriceList priceList= new PriceList(date, price, new Provider(providerName,"", ""), new Ingredient(ingName,
                    0, 0, new CookingWay(""), new Product("", new ProductGroup(""))));
            resultList.add(priceList);
        }

        return resultList;
    }
}
