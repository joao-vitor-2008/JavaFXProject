package org.openjfx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

  @Override
  public void start(Stage stage) {
    // First and last name labels
    Label firstNameLabel = new Label();
    Label lastNameLabel = new Label();

    // Top HBox
    Label nameLabel = new Label("Type your complete name: ");
    TextField nameField = new TextField();
    Button btn = new Button("Send");

    // Result labels
    Label warningLabel = new Label("Type only your first and last name separated with a space");

    // Boxes
    HBox nameBox = new HBox(8, nameLabel, nameField, btn);
    nameBox.setPadding(new Insets(10, 10, 10, 10));
    VBox resBox = new VBox(8);

    // root VBox
    VBox root = new VBox(10, nameBox, resBox);
    root.setPadding(new Insets(10));

    // Scene declaration
    var scene = new Scene(root, 500, 100);
    stage.setScene(scene);
    stage.show();

    // btn action method
    btn.setOnAction(event -> {
      if (nameField.getText().contains(" ") && nameField.getText().isBlank() == false) {
        String completeNameStr = nameField.getText();

        int space = completeNameStr.indexOf(" ");

        firstNameLabel.setText("Your first name is: " + completeNameStr.substring(0, space));
        lastNameLabel.setText("Your last name is: " + completeNameStr.substring(space + 1));

        resBox.getChildren().addAll(firstNameLabel, lastNameLabel);
      } else {
        resBox.getChildren().add(warningLabel);
      }
    });

  }

  public static void main(String[] args) {
    launch();
  }

}
