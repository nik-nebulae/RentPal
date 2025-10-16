package com.rentpal.rentpal_backend.service;

import com.rentpal.rentpal_backend.dto.TenantSummaryDTO;
import com.rentpal.rentpal_backend.exception.ResourceNotFoundException;
import com.rentpal.rentpal_backend.model.Owner;
import com.rentpal.rentpal_backend.model.Tenant;
import com.rentpal.rentpal_backend.repository.OwnerRepository;
import com.rentpal.rentpal_backend.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    // ✅ CREATE
    public Tenant createTenant(Tenant tenant) {
        if (tenant.getOwner() == null || tenant.getOwner().getOwnerId() == null) {
            throw new ResourceNotFoundException("Owner information missing in request");
        }

        Owner owner = ownerRepository.findById(tenant.getOwner().getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Owner not found with ID: " + tenant.getOwner().getOwnerId()));

        tenant.setOwner(owner);
        return tenantRepository.save(tenant);
    }

    public List<TenantSummaryDTO> getAllTenants() {
        List<Tenant> tenants = tenantRepository.findAll();
        return tenants.stream()
                .map(t -> new TenantSummaryDTO(
                        t.getTenantId(),
                        t.getName(),
                        t.getRoomNumber(),
                        t.getRemainingRent(),
                        t.getPaymentStatus()
                ))
                .toList();
    }


    // ✅ UPDATE
    public Tenant updateTenant(Long id, Tenant tenantDetails) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + id));

        tenant.setName(tenantDetails.getName());
        tenant.setEmail(tenantDetails.getEmail());
        tenant.setPhone(tenantDetails.getPhone());
        tenant.setRoomNumber(tenantDetails.getRoomNumber());
        tenant.setRentAmount(tenantDetails.getRentAmount());
        tenant.setStatus(tenantDetails.getStatus());

        if (tenantDetails.getOwner() != null) {
            Owner owner = ownerRepository.findById(tenantDetails.getOwner().getOwnerId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Owner not found with ID: " + tenantDetails.getOwner().getOwnerId()));
            tenant.setOwner(owner);
        }

        return tenantRepository.save(tenant);
    }

    // ✅ DELETE
    public void deleteTenant(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + id));
        tenantRepository.delete(tenant);
    }
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + id));
    }

}
