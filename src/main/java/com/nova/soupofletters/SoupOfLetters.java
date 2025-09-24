package com.nova.soupofletters;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SoupOfLetters extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text title = new Text("Zuppa di Lettere");
        title.setFont(Font.font("Verdana", 30));
        title.setFill(Color.WHITE);
        title.setEffect(new DropShadow(5, Color.BLACK));

        ButtonDerived startButton = new ButtonDerived("Gioca", "#2ecc71", 200, 60);
        ButtonDerived optionButton = new ButtonDerived("Opzioni", "#3498db", 200, 60);
        ButtonDerived exitButton = new ButtonDerived("Esci", "#e74c3c", 200, 60);
        
        startButton.setOnAction(e -> System.out.println("Avvio gioco..."));
        optionButton.setOnAction(e -> System.out.println("Apertura opzioni..."));
        exitButton.setOnAction(e -> System.exit(0));

        VBox menu = new VBox(20, startButton, optionButton, exitButton);
        menu.setAlignment(Pos.CENTER);

        VBox rootLayout = new VBox(50, title, menu);
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setStyle("-fx-background-color: linear-gradient(to bottom, #1a1a2e, #162447); -fx-padding: 50;");

        Scene scene = new Scene(rootLayout, 1024, 720);

        primaryStage.setTitle("Zuppa di Lettere");
        primaryStage.setScene(scene);

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Logo.png")));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
