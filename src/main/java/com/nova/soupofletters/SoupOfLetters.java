package com.nova.soupofletters;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SoupOfLetters extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        showMainMenu();

        primaryStage.setTitle("Zuppa di Lettere");
        primaryStage.getIcons().add(
            new javafx.scene.image.Image(getClass().getResourceAsStream("/Logo.png"))
        );

        primaryStage.show();
    }

    public void showMainMenu() {
        MainMenuView mainMenu = new MainMenuView(this);
        Scene scene = new Scene(mainMenu, 1024, 768);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
