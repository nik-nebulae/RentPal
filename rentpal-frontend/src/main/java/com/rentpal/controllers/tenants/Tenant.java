package com.rentpal.controllers.tenants;

import javafx.beans.property.*;

public class Tenant {
    private final StringProperty name;
    private final StringProperty unit;
    private final StringProperty contact;
    private final DoubleProperty rentDue;
    private final StringProperty status;

    public Tenant(String name, String unit, String contact, double rentDue, String status) {
        this.name = new SimpleStringProperty(name);
        this.unit = new SimpleStringProperty(unit);
        this.contact = new SimpleStringProperty(contact);
        this.rentDue = new SimpleDoubleProperty(rentDue);
        this.status = new SimpleStringProperty(status);
    }

    // Getters
    public String getName() { return name.get(); }
    public String getUnit() { return unit.get(); }
    public String getContact() { return contact.get(); }
    public double getRentDue() { return rentDue.get(); }
    public String getStatus() { return status.get(); }

    // Property methods for TableView bindings
    public StringProperty nameProperty() { return name; }
    public StringProperty unitProperty() { return unit; }
    public StringProperty contactProperty() { return contact; }
    public DoubleProperty rentDueProperty() { return rentDue; }
    public StringProperty statusProperty() { return status; }
}
