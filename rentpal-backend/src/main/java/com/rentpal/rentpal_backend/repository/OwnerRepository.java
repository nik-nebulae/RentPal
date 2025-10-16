package com.rentpal.rentpal_backend.repository;

import com.rentpal.rentpal_backend.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
