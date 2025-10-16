package com.rentpal.controllers.auth;

import com.rentpal.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SignupController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label messageLabel;

    // ✅ Called when "Sign Up" button is clicked
    @FXML
    private void handleSignup() {
        if (passwordField.getText().equals(confirmPasswordField.getText())) {
            messageLabel.setText("Signup successful! Please login.");
            Stage stage = (Stage) usernameField.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "/com/rentpal/fxml/login.fxml");
        } else {
            messageLabel.setText("Passwords do not match!");
        }
    }

    // ✅ Called when "Back to Login" hyperlink is clicked
    @FXML
    private void handleBackToLogin() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "/com/rentpal/fxml/login.fxml");
    }
}
