package io.yourcode47.eexpenseapi.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.repository.CategoryRepository;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    void testFindAll() {
        ArrayList<Category> categoryList = new ArrayList<>();
        when(this.categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> actualFindAllResult = this.categoryServiceImpl.findAll();
        assertSame(categoryList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.categoryRepository).findAll();
    }

    @Test
    void testFindById() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Category> actualFindByIdResult = this.categoryServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.categoryRepository).findById((Long) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());
        when(this.categoryRepository.save((Category) any())).thenReturn(category);

        Category category1 = new Category();
        category1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setId(123L);
        category1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setName("Name");
        category1.setPurchaseList(new ArrayList<>());
        assertSame(category, this.categoryServiceImpl.save(category1));
        verify(this.categoryRepository).save((Category) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testDelete() {
        doNothing().when(this.categoryRepository).deleteById((Long) any());
        this.categoryServiceImpl.delete(123L);
        verify(this.categoryRepository).deleteById((Long) any());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }

    @Test
    void testUpdate() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());
        when(this.categoryRepository.save((Category) any())).thenReturn(category);

        Category category1 = new Category();
        category1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setId(123L);
        category1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setName("Name");
        category1.setPurchaseList(new ArrayList<>());

        Category category2 = new Category();
        category2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category2.setId(123L);
        category2.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category2.setName("Name");
        category2.setPurchaseList(new ArrayList<>());
        assertSame(category, this.categoryServiceImpl.update(category1, category2));
        verify(this.categoryRepository).save((Category) any());
        assertEquals("Name", category2.getName());
        assertTrue(this.categoryServiceImpl.findAll().isEmpty());
    }
}

