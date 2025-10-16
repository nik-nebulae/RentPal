package com.rentpal.controllers.complaints;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ComplaintsController {

    @FXML private TextField searchField;
    @FXML private ComboBox<String> filterComboBox;
    @FXML private TableView<Complaint> complaintsTable;

    @FXML private TableColumn<Complaint, Number> colId;
    @FXML private TableColumn<Complaint, String> colTenant;
    @FXML private TableColumn<Complaint, String> colIssue;
    @FXML private TableColumn<Complaint, String> colStatus;
    @FXML private TableColumn<Complaint, String> colDate;

    private ObservableList<Complaint> complaintsData;

    @FXML
    public void initialize() {
        // Setup filters
        filterComboBox.setItems(FXCollections.observableArrayList("All", "Pending", "In Progress", "Resolved"));
        filterComboBox.getSelectionModel().select("All");

        // Map table columns
        colId.setCellValueFactory(cell -> cell.getValue().idProperty());
        colTenant.setCellValueFactory(cell -> cell.getValue().tenantProperty());
        colIssue.setCellValueFactory(cell -> cell.getValue().issueProperty());
        colStatus.setCellValueFactory(cell -> cell.getValue().statusProperty());
        colDate.setCellValueFactory(cell -> cell.getValue().dateProperty());

        // Mock data
        complaintsData = FXCollections.observableArrayList(
                new Complaint(1, "John Doe", "Water leakage in bathroom", "Pending", "2025-10-02"),
                new Complaint(2, "Sarah Lee", "Broken lift button", "In Progress", "2025-10-03"),
                new Complaint(3, "Michael Chen", "Electricity fluctuation", "Resolved", "2025-09-28"),
                new Complaint(4, "Priya Singh", "Noise issue from next flat", "Pending", "2025-10-04")
        );

        complaintsTable.setItems(complaintsData);
    }

    @FXML
    private void handleAddComplaint() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Complaint");
        alert.setHeaderText(null);
        alert.setContentText("Add Complaint button clicked! (will open form later)");
        alert.showAndWait();
    }
}
