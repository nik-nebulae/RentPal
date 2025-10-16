package com.rentpal.rentpal_backend.service;

import com.rentpal.rentpal_backend.exception.ResourceNotFoundException;
import com.rentpal.rentpal_backend.model.Payment;
import com.rentpal.rentpal_backend.model.Tenant;
import com.rentpal.rentpal_backend.repository.PaymentRepository;
import com.rentpal.rentpal_backend.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TenantRepository tenantRepository;

    public Payment createPayment(Long tenantId, Payment payment) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + tenantId));

        payment.setTenant(tenant);
        payment.setPaymentDate(LocalDate.now());

        Payment savedPayment = paymentRepository.save(payment);

        // Update tenant’s remaining rent
        double totalPaid = tenant.getPayments().stream()
                .mapToDouble(Payment::getAmount)
                .sum();

        double remaining = tenant.getRentAmount() - totalPaid;
        tenant.setRemainingRent(Math.max(remaining, 0)); // never go below 0

        // Update payment status
        if (remaining <= 0)
            tenant.setPaymentStatus("Paid");
        else if (remaining < tenant.getRentAmount())
            tenant.setPaymentStatus("Partial");
        else
            tenant.setPaymentStatus("Unpaid");

        tenantRepository.save(tenant);

        return savedPayment;
    }


    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public List<Payment> getPaymentsByTenant(Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + tenantId));
        return tenant.getPayments();
    }
}
