package com.rentpal.rentpal_backend.repository;

import com.rentpal.rentpal_backend.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
