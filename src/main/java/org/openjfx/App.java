package org.openjfx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    root.setAlignment(Pos.BASELINE_CENTER);
    root.setPadding(new Insets(10));

    // Scene declaration
    var scene = new Scene(root, 500, 100);
    stage.setScene(scene);
    stage.show();

    // Patterns to validate
    Pattern p = Pattern.compile("^([A-Z][a-z]+)(\\s[A-Z][a-z]+)+$");

    // btn action method
    btn.setOnAction(event -> {
      resBox.getChildren().clear();

      String completeNameStr = nameField.getText().trim();

      if (p.matcher(completeNameStr).matches()) {
        String[] parts = completeNameStr.split("\\s+");

        for (int i = 0; i < parts.length; i++) {
          Label name = new Label("Your " + (i + 1) + "° name is: " + parts[i]);
          resBox.getChildren().add(name);
        }
      } else {
        resBox.getChildren().add(warningLabel);
      }
    });

  }

  public static void main(String[] args) {
    launch();
  }

}
