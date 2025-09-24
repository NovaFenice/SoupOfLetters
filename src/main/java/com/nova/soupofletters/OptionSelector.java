package com.nova.soupofletters;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;

public class OptionSelector extends HBox {
    
    private int index = 0;
    private final List<String> options;
    private final Label display;
    private final Button leftButton;
    private final Button rightButton;

    public OptionSelector(List<String> options) {
        super(10);
        this.options = options;

        this.setAlignment(Pos.CENTER);

        leftButton = new Button("<");
        rightButton = new Button(">");

        display = new Label(options.get(index));
        display.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        leftButton.setOnAction(e -> {
            if (index > 0) index--;
            update();
        });

        rightButton.setOnAction(e -> {
            if (index < options.size() - 1) index++;
            update();
        });

        this.getChildren().addAll(leftButton, display, rightButton);
        update();
    }

    public Button getLeftButton() {
        return leftButton;
    }

    public Button getRightButton() {
        return rightButton;
    }

    private void update() {
        display.setText(options.get(index));
        leftButton.setDisable(index == 0);
        rightButton.setDisable(index == options.size() - 1);
    }

    public String getValue() {
        return options.get(index);
    }

    public void setValue(String value) {
        int i = options.indexOf(value);
        if (i >= 0) {
            index = i;
            update();
        }
    }
}