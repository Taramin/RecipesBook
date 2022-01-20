package com.example.demo;

import com.example.demo.view.MainWindowUI;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.sql.*;

public class ApplicationStarter extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC подключен.");
            try{
                String userName = "d";
                String userPassword = "1";
                String databaseName = "PRODUCTS_DATABASE";

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName,userName, userPassword);
                Statement statement = connection.createStatement();

                FlowPane root = new FlowPane(10,15);
                root.setAlignment(Pos.CENTER);
                MainWindowUI mainWindow = new MainWindowUI(statement);
                root.getChildren().addAll(mainWindow.getResultPane());

                Scene scene = new Scene(root, 800, 800);
                primaryStage.setTitle("Recipes book");
                primaryStage.setScene(scene);
                primaryStage.show();

            }catch(SQLException ex){
                System.out.println("Ошибка подключения");
                ex.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }catch(ClassNotFoundException ex){
            System.out.println("Не нашёл драйвер.");
            ex.printStackTrace();
        }
    }
}