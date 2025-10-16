package com.rentpal.controllers.payments;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class AddPaymentController {

    @FXML private TextField tenantField;
    @FXML private TextField amountField;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> methodComboBox;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;

    private Payment newPayment;

    @FXML
    public void initialize() {
        // Populate dropdowns
        methodComboBox.getItems().addAll("Cash", "Online", "Bank Transfer");
        statusComboBox.getItems().addAll("Paid", "Pending", "Overdue");
    }

    @FXML
    private void handleCancel() {
        // Close dialog without saving
        ((Stage) cancelButton.getScene().getWindow()).close();
    }

    @FXML
    private void handleSave() {
        boolean valid = true;

        resetFieldStyles();

        // Validate Tenant Name
        if (tenantField.getText().trim().isEmpty()) {
            markInvalid(tenantField);
            valid = false;
        }

        // Validate Amount
        try {
            if (amountField.getText().trim().isEmpty() || Double.parseDouble(amountField.getText()) <= 0) {
                markInvalid(amountField);
                valid = false;
            }
        } catch (NumberFormatException e) {
            markInvalid(amountField);
            valid = false;
        }

        // Validate Date
        if (datePicker.getValue() == null) {
            markInvalid(datePicker);
            valid = false;
        }

        // Validate Dropdowns
        if (methodComboBox.getValue() == null) {
            markInvalid(methodComboBox);
            valid = false;
        }

        if (statusComboBox.getValue() == null) {
            markInvalid(statusComboBox);
            valid = false;
        }

        // Stop here if validation fails
        if (!valid) {
            showInlineError("⚠️ Please fill in all fields correctly.");
            return;
        }

        // If everything is valid → create Payment object
        newPayment = new Payment(
                datePicker.getValue().toString(),
                tenantField.getText().trim(),
                Double.parseDouble(amountField.getText().trim()),
                statusComboBox.getValue(),
                methodComboBox.getValue()
        );

        // Close dialog
        ((Stage) saveButton.getScene().getWindow()).close();
    }

    private void resetFieldStyles() {
        tenantField.setStyle(null);
        amountField.setStyle(null);
        datePicker.setStyle(null);
        methodComboBox.setStyle(null);
        statusComboBox.setStyle(null);
    }

    private void markInvalid(Control control) {
        control.setStyle("-fx-border-color: #e74c3c; -fx-border-width: 2; -fx-background-color: rgba(255,240,240,0.9);");
        shakeField(control);
    }

    private void showInlineError(String message) {
        Label errorLabel = new Label(message);
        errorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 12px; -fx-padding: 5;");
        VBox parent = (VBox) saveButton.getParent().getParent();
        if (!parent.getChildren().contains(errorLabel)) {
            parent.getChildren().add(1, errorLabel);
        }
    }

    private void shakeField(Control control) {
        javafx.animation.TranslateTransition tt = new javafx.animation.TranslateTransition(javafx.util.Duration.millis(80), control);
        tt.setFromX(0);
        tt.setByX(8);
        tt.setCycleCount(6);
        tt.setAutoReverse(true);
        tt.play();
    }


    public Payment getNewPayment() {
        return newPayment;
    }
}
