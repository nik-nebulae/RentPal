package com.rentpal.controllers.payments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import com.rentpal.controllers.payments.AddPaymentController;


public class PaymentsController {

    @FXML private Label totalCollected;
    @FXML private Label pendingPayments;
    @FXML private Label overduePayments;
    @FXML private Label refundedPayments;

    @FXML private TextField searchField;
    @FXML private ComboBox<String> filterComboBox;
    @FXML private TableView<Payment> paymentsTable;

    @FXML private TableColumn<Payment, String> colDate;
    @FXML private TableColumn<Payment, String> colTenant;
    @FXML private TableColumn<Payment, Number> colAmount;
    @FXML private TableColumn<Payment, String> colStatus;
    @FXML private TableColumn<Payment, String> colMethod;

    @FXML private Button addPaymentButton;

    private ObservableList<Payment> paymentData;

    @FXML
    public void initialize() {
        // Dropdown filter
        filterComboBox.setItems(FXCollections.observableArrayList("All", "Paid", "Pending", "Overdue"));

        // Table column mappings
        colDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        colTenant.setCellValueFactory(cellData -> cellData.getValue().tenantProperty());
        colAmount.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
        colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        colMethod.setCellValueFactory(cellData -> cellData.getValue().methodProperty());

        // Mock data
        paymentData = FXCollections.observableArrayList(
                new Payment("2025-10-01", "John Doe", 1200, "Paid", "Online"),
                new Payment("2025-10-02", "Sarah Lee", 800, "Pending", "Cash"),
                new Payment("2025-09-30", "Michael Chen", 900, "Paid", "Bank Transfer"),
                new Payment("2025-09-28", "Priya Singh", 700, "Overdue", "Cash")
        );


        paymentsTable.setItems(paymentData);

        // Initialize quick stats
        updateStats();
    }

    // ✅ Add Payment Popup
    @FXML
    private void handleAddPayment() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/rentpal/fxml/add_payment_dialog.fxml"));

            DialogPane dialogPane = loader.load();

            // ✅ Load dialog CSS for styling
            dialogPane.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());

            AddPaymentController controller = loader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle("Add New Payment");

            // Show the dialog and wait for user to close
            dialog.showAndWait();

            // Retrieve new payment (if user pressed Save)
            Payment newPayment = controller.getNewPayment();
            if (newPayment != null) {
                paymentsTable.getItems().add(newPayment);
                updateStats();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load Add Payment dialog.");
            alert.showAndWait();
        }
    }


    private void updateStats() {
        totalCollected.setText("$" + paymentsTable.getItems().stream()
                .filter(p -> p.getStatus().equals("Paid"))
                .mapToDouble(Payment::getAmount)
                .sum());

        pendingPayments.setText(String.valueOf(
                paymentsTable.getItems().stream().filter(p -> p.getStatus().equals("Pending")).count()
        ));

        overduePayments.setText(String.valueOf(
                paymentsTable.getItems().stream().filter(p -> p.getStatus().equals("Overdue")).count()
        ));
    }

}
