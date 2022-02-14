package io.yourcode47.eexpenseapi.service;

import io.yourcode47.eexpenseapi.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {

    List<Purchase> findAll();

    Optional<Purchase> findById(Long id);

    Purchase save(Purchase entity);

    void delete(Long id);

    Purchase update(Purchase entityToUpdate, Purchase entityToSaved);
}
