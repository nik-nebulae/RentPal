package com.rentpal.controllers.auth;

import com.rentpal.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    // ✅ Called when Login button is clicked
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("owner") && password.equals("1234")) {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "/com/rentpal/fxml/owner_dashboard.fxml");
        } else {
            errorLabel.setText("Invalid username or password!");
        }
    }

    // ✅ Called when "Forgot Password?" hyperlink is clicked
    @FXML
    private void handleForgotPassword() {
        // For now, just print — you can later open a dialog or email screen
        System.out.println("Forgot Password clicked!");
        errorLabel.setText("Password recovery is not implemented yet.");
    }

    // ✅ Called when "Sign Up" hyperlink is clicked
    @FXML
    private void handleSignUp() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "/com/rentpal/fxml/signup.fxml");
    }
}
