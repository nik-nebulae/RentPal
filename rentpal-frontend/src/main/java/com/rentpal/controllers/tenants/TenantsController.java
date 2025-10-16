package com.rentpal.controllers.tenants;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TenantsController {

    @FXML private Label totalTenants;
    @FXML private Label activeTenants;
    @FXML private Label pendingPayments;
    @FXML private Label vacantUnits;

    @FXML private TextField searchField;
    @FXML private ComboBox<String> filterComboBox;
    @FXML private TableView<Tenant> tenantsTable;

    // ✅ Declare each column with proper type
    @FXML private TableColumn<Tenant, String> colName;
    @FXML private TableColumn<Tenant, String> colUnit;
    @FXML private TableColumn<Tenant, String> colContact;
    @FXML private TableColumn<Tenant, Number> colRentDue;
    @FXML private TableColumn<Tenant, String> colStatus;

    private ObservableList<Tenant> tenantsData;

    @FXML
    public void initialize() {
        // Fill filter options
        filterComboBox.setItems(FXCollections.observableArrayList("All", "Active", "Pending"));

        // ✅ Correctly bind columns
        colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colUnit.setCellValueFactory(cellData -> cellData.getValue().unitProperty());
        colContact.setCellValueFactory(cellData -> cellData.getValue().contactProperty());
        colRentDue.setCellValueFactory(cellData -> cellData.getValue().rentDueProperty());
        colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Mock data
        tenantsData = FXCollections.observableArrayList(
                new Tenant("John Doe", "A-101", "9876543210", 1200, "Paid"),
                new Tenant("Sarah Lee", "B-204", "9876500000", 800, "Pending"),
                new Tenant("Michael Chen", "C-310", "9876533333", 900, "Paid"),
                new Tenant("Priya Singh", "D-120", "9876511111", 700, "Pending")
        );

        tenantsTable.setItems(tenantsData);

        // Quick stats
        totalTenants.setText(String.valueOf(tenantsData.size()));
        activeTenants.setText(String.valueOf(
                (int) tenantsData.stream().filter(t -> t.getStatus().equals("Paid")).count()
        ));
        pendingPayments.setText(String.valueOf(
                (int) tenantsData.stream().filter(t -> t.getStatus().equals("Pending")).count()
        ));
        vacantUnits.setText("4"); // mock value
    }

    @FXML
    private void handleAddTenant() {
        System.out.println("Add Tenant button clicked!");
        // Later: open add tenant dialog or integrate backend POST call
    }
}
