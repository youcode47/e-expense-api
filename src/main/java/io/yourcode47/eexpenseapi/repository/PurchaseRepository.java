package io.yourcode47.eexpenseapi.repository;

import io.yourcode47.eexpenseapi.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> { }
