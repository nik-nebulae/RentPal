package com.rentpal.controllers.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class OwnerDashboardController {

    @FXML
    private VBox sidebar;

    @FXML
    private BorderPane rootPane;   // This is the whole BorderPane from FXML

    private boolean collapsed = false;

    @FXML
    private void initialize() {
        // Load the dashboard home page by default
        loadPage("/com/rentpal/fxml/dashboard_home.fxml");
    }

    @FXML
    private void toggleSidebar() {
        if (!collapsed) {
            sidebar.setPrefWidth(60);
            collapsed = true;
        } else {
            sidebar.setPrefWidth(220);
            collapsed = false;
        }
    }

    @FXML
    private void showDashboard() {
        loadPage("/com/rentpal/fxml/dashboard_home.fxml");
    }

    @FXML
    private void showTenants() {
        loadPage("/com/rentpal/fxml/tenants.fxml");
    }

    @FXML
    private void showPayments() {
        loadPage("/com/rentpal/fxml/payments.fxml");
    }

    @FXML
    private void showComplaints() {
        loadPage("/com/rentpal/fxml/complaints.fxml");
    }


    private void loadPage(String fxmlPath) {
        try {
            System.out.println("Loading page: " + fxmlPath);
            rootPane.setCenter(FXMLLoader.load(getClass().getResource(fxmlPath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
