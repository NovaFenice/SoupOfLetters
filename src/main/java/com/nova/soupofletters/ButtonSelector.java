package com.nova.soupofletters;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class ButtonSelector extends Button {

    public ButtonSelector(int w, int h) {
        super();

        setMinSize(w, h);
        setPrefSize(w, h);
        setMaxSize(w, h);

        setFont(Font.font("Arial", 12));
        setTextFill(Color.WHITE);

        setStyle(
            "-fx-background-color: #333333; -fx-background-radius: 6; -fx-font-smoothing-type: lcd;"
        );

        DropShadow shadow = new DropShadow();
        shadow.setRadius(3);
        shadow.setOffsetX(0);
        shadow.setOffsetY(1);
        shadow.setColor(Color.rgb(0, 0, 0, 0.3));
        setEffect(shadow);

        addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            setStyle("-fx-background-color: #555555; -fx-background-radius: 6;");
            setScaleX(1.05);
            setScaleY(1.05);
        });

        addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            setStyle("-fx-background-color: #333333; -fx-background-radius: 6;");
            setScaleX(1);
            setScaleY(1);
        });
    }

}
