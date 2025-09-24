package com.nova.soupofletters;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Arrays;

public class OptionsView extends VBox {

    public OptionsView(SoupOfLetters app) {
        super(30);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(40));
        this.setStyle("-fx-background-color: linear-gradient(to bottom, #1a1a2e, #162447);");

        // --- Titolo ---
        Text title = new Text("Impostazioni");
        title.setStyle("-fx-font-size: 32px; -fx-fill: white; -fx-font-weight: bold;");

        // --- Sezione Aspetto Grafico ---
        VBox graphicsSection = new VBox(15);
        graphicsSection.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-background-radius: 15px;");
        graphicsSection.setPadding(new Insets(20));

        Text graphicsTitle = new Text("Aspetto Grafico");
        graphicsTitle.setStyle("-fx-font-size: 20px; -fx-fill: white;");

        // Tema
        HBox themeBox = new HBox(10);
        themeBox.setAlignment(Pos.CENTER_LEFT);
        Label themeLabel = new Label("Tema:");
        themeLabel.setStyle("-fx-text-fill: white;");

        OptionSelector themeSelector = new OptionSelector(Arrays.asList("Scuro", "Chiaro", "Colorato"));
        themeSelector.setValue(SettingsManager.getTheme());
        themeSelector.getLeftButton().setOnAction(e -> SettingsManager.setTheme(themeSelector.getValue()));
        themeSelector.getRightButton().setOnAction(e -> SettingsManager.setTheme(themeSelector.getValue()));

        themeBox.getChildren().addAll(themeLabel, themeSelector);

        // Colore evidenziazione
        HBox highlightBox = new HBox(10);
        highlightBox.setAlignment(Pos.CENTER_LEFT);
        Label highlightLabel = new Label("Colore evidenziazione:");
        highlightLabel.setStyle("-fx-text-fill: white;");

        OptionSelector highlightSelector = new OptionSelector(Arrays.asList("Verde", "Blu", "Rosso", "Giallo"));
        highlightSelector.setValue(SettingsManager.getHighlightColor());
        highlightSelector.getLeftButton().setOnAction(e -> SettingsManager.setHighlightColor(highlightSelector.getValue()));
        highlightSelector.getRightButton().setOnAction(e -> SettingsManager.setHighlightColor(highlightSelector.getValue()));

        highlightBox.getChildren().addAll(highlightLabel, highlightSelector);

        // Animazioni
        CheckBox animationsCheck = new CheckBox("Attiva animazioni");
        animationsCheck.setSelected(SettingsManager.isAnimations());
        animationsCheck.setStyle("-fx-text-fill: white;");
        animationsCheck.selectedProperty().addListener((obs, oldVal, newVal) -> SettingsManager.setAnimations(newVal));

        graphicsSection.getChildren().addAll(graphicsTitle, themeBox, highlightBox, animationsCheck);

        // --- Sezione Audio ---
        VBox audioSection = new VBox(15);
        audioSection.setStyle("-fx-background-color: rgba(255,255,255,0.05); -fx-background-radius: 15px;");
        audioSection.setPadding(new Insets(20));

        Text audioTitle = new Text("Audio");
        audioTitle.setStyle("-fx-font-size: 20px; -fx-fill: white;");

        // Volume musica
        HBox musicBox = new HBox(10);
        musicBox.setAlignment(Pos.CENTER_LEFT);
        Label musicLabel = new Label("Volume musica:");
        musicLabel.setStyle("-fx-text-fill: white;");
        Slider musicSlider = new Slider(0, 100, SettingsManager.getMusicVolume());
        musicSlider.setShowTickLabels(true);
        musicSlider.setShowTickMarks(true);
        musicSlider.valueProperty().addListener((obs, oldVal, newVal) -> SettingsManager.setMusicVolume(newVal.doubleValue()));
        musicBox.getChildren().addAll(musicLabel, musicSlider);

        // Volume effetti
        HBox sfxBox = new HBox(10);
        sfxBox.setAlignment(Pos.CENTER_LEFT);
        Label sfxLabel = new Label("Volume effetti:");
        sfxLabel.setStyle("-fx-text-fill: white;");
        Slider sfxSlider = new Slider(0, 100, SettingsManager.getSfxVolume());
        sfxSlider.setShowTickLabels(true);
        sfxSlider.setShowTickMarks(true);
        sfxSlider.valueProperty().addListener((obs, oldVal, newVal) -> SettingsManager.setSfxVolume(newVal.doubleValue()));
        sfxBox.getChildren().addAll(sfxLabel, sfxSlider);

        // Muta audio
        CheckBox muteCheck = new CheckBox("Muta audio");
        muteCheck.setStyle("-fx-text-fill: white;");
        muteCheck.setSelected(SettingsManager.getMusicVolume() == 0 && SettingsManager.getSfxVolume() == 0);
        muteCheck.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                musicSlider.setValue(0);
                sfxSlider.setValue(0);
            }
        });

        audioSection.getChildren().addAll(audioTitle, musicBox, sfxBox, muteCheck);

        // --- Pulsante Indietro ---
        ButtonDerived backButton = new ButtonDerived("Indietro", "#e67e22", 200, 50);
        backButton.setOnAction(e -> app.showMainMenu());

        this.getChildren().addAll(title, graphicsSection, audioSection, backButton);
    }
}