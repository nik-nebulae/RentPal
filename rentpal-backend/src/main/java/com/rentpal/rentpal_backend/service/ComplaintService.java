package com.rentpal.rentpal_backend.service;

import com.rentpal.rentpal_backend.dto.ComplaintDTO;
import com.rentpal.rentpal_backend.model.Complaint;
import com.rentpal.rentpal_backend.model.Owner;
import com.rentpal.rentpal_backend.model.Tenant;
import com.rentpal.rentpal_backend.repository.ComplaintRepository;
import com.rentpal.rentpal_backend.repository.OwnerRepository;
import com.rentpal.rentpal_backend.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    // Add new complaint
    public Complaint addComplaint(Long tenantId, Complaint complaint) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
        Owner owner = tenant.getOwner();

        complaint.setTenant(tenant);
        complaint.setOwner(owner);
        complaint.setStatus("Pending");
        complaint.setDateSubmitted(LocalDate.now());

        return complaintRepository.save(complaint);
    }

    // Get complaints by Owner (returns clean DTO)
    public List<ComplaintDTO> getComplaintsByOwner(Long ownerId) {
        List<Complaint> complaints = complaintRepository.findByOwnerOwnerId(ownerId);
        return complaints.stream()
                .map(c -> new ComplaintDTO(
                        c.getComplaintId(),
                        c.getTitle(),
                        c.getDescription(),
                        c.getStatus(),
                        c.getDateSubmitted(),
                        c.getTenant().getName(),
                        c.getOwner().getName()
                ))
                .toList();
    }

    // Get complaints by Tenant (returns clean DTO)
    public List<ComplaintDTO> getComplaintsByTenant(Long tenantId) {
        List<Complaint> complaints = complaintRepository.findByTenantTenantId(tenantId);
        return complaints.stream()
                .map(c -> new ComplaintDTO(
                        c.getComplaintId(),
                        c.getTitle(),
                        c.getDescription(),
                        c.getStatus(),
                        c.getDateSubmitted(),
                        c.getTenant().getName(),
                        c.getOwner().getName()
                ))
                .toList();
    }

    // Update complaint status (Pending → Resolved)
    public Complaint updateComplaintStatus(Long complaintId, String status) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
}
