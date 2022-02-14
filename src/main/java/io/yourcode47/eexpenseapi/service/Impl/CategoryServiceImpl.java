package io.yourcode47.eexpenseapi.service.Impl;

import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.repository.CategoryRepository;
import io.yourcode47.eexpenseapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) { return categoryRepository.findById(id); }

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void delete(Long id) { categoryRepository.deleteById(id); }

    @Override
    public Category update(Category entityToUpdate, Category entityToSaved) {
        entityToSaved.setName(entityToUpdate.getName());
        return categoryRepository.save(entityToSaved);
    }
}
