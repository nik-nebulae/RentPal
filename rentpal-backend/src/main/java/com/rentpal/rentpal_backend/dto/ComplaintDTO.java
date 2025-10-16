package com.rentpal.rentpal_backend.dto;

import java.time.LocalDate;

public class ComplaintDTO {
    private Long complaintId;
    private String title;
    private String description;
    private String status;
    private LocalDate dateSubmitted;
    private String tenantName;
    private String ownerName;

    public ComplaintDTO(Long complaintId, String title, String description,
                        String status, LocalDate dateSubmitted,
                        String tenantName, String ownerName) {
        this.complaintId = complaintId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateSubmitted = dateSubmitted;
        this.tenantName = tenantName;
        this.ownerName = ownerName;
    }

    // Getters
    public Long getComplaintId() { return complaintId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public LocalDate getDateSubmitted() { return dateSubmitted; }
    public String getTenantName() { return tenantName; }
    public String getOwnerName() { return ownerName; }
}
