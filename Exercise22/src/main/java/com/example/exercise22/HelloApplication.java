package com.example.exercise22;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flag Display App");

        // Create buttons with country names
        Button usaButton = new Button("USA");
        usaButton.getStyleClass().add("usa-button");
        Button franceButton = new Button("France");
        franceButton.getStyleClass().add("france-button");
        Button japanButton = new Button("Japan");
        japanButton.getStyleClass().add("japan-button");

        // Create Panes for flag display
        Pane usaFlagPane = createFlagPane(Color.RED, Color.WHITE, Color.BLUE);
        Pane franceFlagPane = createFlagPane(Color.BLUE, Color.WHITE, Color.RED);
        Pane japanFlagPane = createFlagPane(Color.WHITE, Color.RED);

        // Set action handlers for button clicks
        usaButton.setOnAction(e -> displayCountryFlag(usaFlagPane, "USA"));
        franceButton.setOnAction(e -> displayCountryFlag(franceFlagPane, "France"));
        japanButton.setOnAction(e -> displayCountryFlag(japanFlagPane, "Japan"));

        // Arrange buttons and flag Panes horizontally
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(usaButton, franceButton, japanButton, usaFlagPane, franceFlagPane, japanFlagPane);

        Scene scene = new Scene(hbox, 1000, 450);
        scene.getStylesheets().add("stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane createFlagPane(Color... colors) {
        Pane flagPane = new Pane();
        flagPane.setPrefSize(200, 100);
        flagPane.setStyle("-fx-background-color: " + getCssColor(colors) + ";");
        return flagPane;
    }

    private void displayCountryFlag(Pane flagPane, String countryName) {
        System.out.println("Selected country: " + countryName);
    }

    private String getCssColor(Color... colors) {
        StringBuilder cssColor = new StringBuilder();
        for (Color color : colors) {
            cssColor.append(color.toString().replace("0x", "#"));
        }
        return cssColor.toString();
    }
}
