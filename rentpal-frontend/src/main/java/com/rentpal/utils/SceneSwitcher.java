package com.rentpal.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {

    public static void switchScene(Stage stage, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(fxmlPath));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
