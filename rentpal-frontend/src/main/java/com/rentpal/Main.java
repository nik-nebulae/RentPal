package com.rentpal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // ✅ Start the app with Login page
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/rentpal/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("RentPal - Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
