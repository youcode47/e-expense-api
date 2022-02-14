package io.yourcode47.eexpenseapi.service;

import io.yourcode47.eexpenseapi.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category entity);

    void delete(Long id);

    Category update(Category entityToUpdate, Category entityToSaved);
}
