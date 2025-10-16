package com.rentpal.controllers.payments;

import javafx.beans.property.*;

public class Payment {

    private final StringProperty date;
    private final StringProperty tenant;
    private final DoubleProperty amount;
    private final StringProperty status;
    private final StringProperty method;

    public Payment(String date, String tenant, double amount, String status, String method) {
        this.date = new SimpleStringProperty(date);
        this.tenant = new SimpleStringProperty(tenant);
        this.amount = new SimpleDoubleProperty(amount);
        this.status = new SimpleStringProperty(status);
        this.method = new SimpleStringProperty(method);
    }

    public StringProperty dateProperty() { return date; }
    public StringProperty tenantProperty() { return tenant; }
    public DoubleProperty amountProperty() { return amount; }
    public StringProperty statusProperty() { return status; }
    public StringProperty methodProperty() { return method; }

    public double getAmount() { return amount.get(); }
    public String getStatus() { return status.get(); }
}
