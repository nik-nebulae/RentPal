package com.rentpal.controllers.dashboard;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DashboardHomeController {

    @FXML
    private BarChart<String, Number> paymentChart;

    @FXML
    public void initialize() {
        // ===== Create sample chart data =====
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("2025");

        series.getData().add(new XYChart.Data<>("Jan", 1200));
        series.getData().add(new XYChart.Data<>("Feb", 950));
        series.getData().add(new XYChart.Data<>("Mar", 1350));
        series.getData().add(new XYChart.Data<>("Apr", 800));
        series.getData().add(new XYChart.Data<>("May", 1600));

        // Add data to chart
        paymentChart.getData().add(series);

        // ===== Style the bars after nodes are created =====
        // (We need to wait until JavaFX actually renders them)
        paymentChart.applyCss();
        paymentChart.layout();

        for (XYChart.Data<String, Number> data : series.getData()) {
            // Set bar color to blue
            data.getNode().setStyle("-fx-bar-fill: #1e88e5;");

            // Optional: smooth rounded look
            data.getNode().setStyle(
                    "-fx-bar-fill: linear-gradient(to top, #1565c0, #42a5f5);" +
                            "-fx-background-radius: 8;"
            );
        }

        // Optional: Adjust chart spacing and gridline colors
        paymentChart.setCategoryGap(25);
        paymentChart.setBarGap(5);
        paymentChart.setLegendVisible(true);
    }

}
