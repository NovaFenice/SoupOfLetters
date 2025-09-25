package com.nova.soupofletters;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;

public class Selector extends HBox {
    
    private int index = 0;
    private final List<String> options;
    private final Label optionsLabel;
    private final ButtonSelector leftButton;
    private final ButtonSelector rightButton;

    public Selector(List<String> options, Label optionsLabel) {
        super(10);
        this.optionsLabel = optionsLabel;
        this.options = options;

        setAlignment(Pos.CENTER);

        leftButton = new ButtonSelector(30, 60);
        rightButton = new ButtonSelector(30, 60);
        leftButton.setText("<");
        rightButton.setText(">");

        this.optionsLabel.setText(options.get(index));
        this.optionsLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        leftButton.setOnAction(e -> {
            if (index > 0) index--;
            update();
        });

        rightButton.setOnAction(e -> {
            if (index < options.size() - 1) index++;
            update();
        });

        this.getChildren().addAll(leftButton, optionsLabel, rightButton);
        update();

    }

    public ButtonSelector getLeftButton() {
        return leftButton;
    }

    public ButtonSelector getRightButton() {
        return rightButton;
    }

    private void update() {
        optionsLabel.setText(options.get(index));
        leftButton.setDisable(index == 0);
        rightButton.setDisable(index == options.size() - 1);
    }

    public String getValue() {
        return options.get(index);
    }

    public int getIndex() {
        return index;
    }

    public void setValue(String value) {
        int i = options.indexOf(value);
        if (i >= 0) {
            index = i;
            update();
        }
    }

}

