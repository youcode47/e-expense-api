package io.yourcode47.eexpenseapi.repository;

import io.yourcode47.eexpenseapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { }
