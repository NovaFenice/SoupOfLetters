package com.nova.soupofletters;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.effect.DropShadow;
import java.util.List;
import javafx.scene.control.Label;

public class MainMenuView extends VBox {

    public MainMenuView(SoupOfLetters app) {
        super(50);

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

        this.getChildren().addAll(title, menu);
        this.setAlignment(Pos.CENTER);
        this.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #1a1a2e, #162447); -fx-padding: 50;"
        );
    }

}