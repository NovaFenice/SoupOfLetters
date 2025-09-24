package com.nova.soupofletters;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ButtonDerived extends Button {
    
    public ButtonDerived(String text, String color, int w, int h) {
        super(text);

        setPrefSize(w, h);

        setFont(Font.font("Arial", 20));
        setTextFill(Color.WHITE);

        setStyle("-fx-background-color: " + color + "; -fx-background-radius: 15px;");

        DropShadow shadow = new DropShadow();
        shadow.setRadius(5);
        shadow.setOffsetX(3);
        shadow.setOffsetY(3);
        shadow.setColor(Color.BLACK);
        setEffect(shadow);

        setOnMouseEntered(e ->
            setStyle("-fx-background-color: derive(" + color + ", 20%); -fx-background-radius: 15;")
        );
        setOnMouseExited(e ->
            setStyle("-fx-background-color: " + color + "; -fx-background-radius: 15;")
        );

    }

}