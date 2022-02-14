package io.yourcode47.eexpenseapi.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.model.Purchase;
import io.yourcode47.eexpenseapi.repository.PurchaseRepository;

import java.math.BigDecimal;
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

@ContextConfiguration(classes = {PurchaseServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PurchaseServiceImplTest {
    @MockBean
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseServiceImpl purchaseServiceImpl;

    @Test
    void testFindAll() {
        ArrayList<Purchase> purchaseList = new ArrayList<>();
        when(this.purchaseRepository.findAll()).thenReturn(purchaseList);
        List<Purchase> actualFindAllResult = this.purchaseServiceImpl.findAll();
        assertSame(purchaseList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.purchaseRepository).findAll();
    }

    @Test
    void testFindById() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());

        Purchase purchase = new Purchase();
        purchase.setCategory(category);
        purchase.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setDescription("The characteristics of someone or something");
        purchase.setId(123L);
        purchase.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setName("Name");
        purchase.setPrice(BigDecimal.valueOf(42L));
        purchase.setQuantity(1);
        purchase.setTotal(BigDecimal.valueOf(42L));
        Optional<Purchase> ofResult = Optional.of(purchase);
        when(this.purchaseRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Purchase> actualFindByIdResult = this.purchaseServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        Purchase getResult = actualFindByIdResult.get();
        assertEquals("42", getResult.getPrice().toString());
        assertEquals("42", getResult.getTotal().toString());
        verify(this.purchaseRepository).findById((Long) any());
        assertTrue(this.purchaseServiceImpl.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());

        Purchase purchase = new Purchase();
        purchase.setCategory(category);
        purchase.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setDescription("The characteristics of someone or something");
        purchase.setId(123L);
        purchase.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setName("Name");
        purchase.setPrice(BigDecimal.valueOf(42L));
        purchase.setQuantity(1);
        purchase.setTotal(BigDecimal.valueOf(42L));
        when(this.purchaseRepository.save((Purchase) any())).thenReturn(purchase);

        Category category1 = new Category();
        category1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setId(123L);
        category1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setName("Name");
        category1.setPurchaseList(new ArrayList<>());

        Purchase purchase1 = new Purchase();
        purchase1.setCategory(category1);
        purchase1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase1.setDescription("The characteristics of someone or something");
        purchase1.setId(123L);
        purchase1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase1.setName("Name");
        purchase1.setPrice(BigDecimal.valueOf(42L));
        purchase1.setQuantity(1);
        purchase1.setTotal(BigDecimal.valueOf(42L));
        Purchase actualSaveResult = this.purchaseServiceImpl.save(purchase1);
        assertSame(purchase, actualSaveResult);
        assertEquals("42", actualSaveResult.getPrice().toString());
        assertEquals("42", actualSaveResult.getTotal().toString());
        verify(this.purchaseRepository).save((Purchase) any());
        assertTrue(this.purchaseServiceImpl.findAll().isEmpty());
    }

    @Test
    void testDelete() {
        doNothing().when(this.purchaseRepository).deleteById((Long) any());
        this.purchaseServiceImpl.delete(123L);
        verify(this.purchaseRepository).deleteById((Long) any());
        assertTrue(this.purchaseServiceImpl.findAll().isEmpty());
    }

    @Test
    void testUpdate() {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());

        Purchase purchase = new Purchase();
        purchase.setCategory(category);
        purchase.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setDescription("The characteristics of someone or something");
        purchase.setId(123L);
        purchase.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase.setName("Name");
        purchase.setPrice(BigDecimal.valueOf(42L));
        purchase.setQuantity(1);
        purchase.setTotal(BigDecimal.valueOf(42L));
        when(this.purchaseRepository.save((Purchase) any())).thenReturn(purchase);

        Category category1 = new Category();
        category1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setId(123L);
        category1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category1.setName("Name");
        category1.setPurchaseList(new ArrayList<>());

        Purchase purchase1 = new Purchase();
        purchase1.setCategory(category1);
        purchase1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase1.setDescription("The characteristics of someone or something");
        purchase1.setId(123L);
        purchase1.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase1.setName("Name");
        purchase1.setPrice(BigDecimal.valueOf(42L));
        purchase1.setQuantity(1);
        purchase1.setTotal(BigDecimal.valueOf(42L));

        Category category2 = new Category();
        category2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category2.setId(123L);
        category2.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category2.setName("Name");
        category2.setPurchaseList(new ArrayList<>());

        Purchase purchase2 = new Purchase();
        purchase2.setCategory(category2);
        purchase2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase2.setDescription("The characteristics of someone or something");
        purchase2.setId(123L);
        purchase2.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        purchase2.setName("Name");
        purchase2.setPrice(BigDecimal.valueOf(42L));
        purchase2.setQuantity(1);
        purchase2.setTotal(BigDecimal.valueOf(42L));
        Purchase actualUpdateResult = this.purchaseServiceImpl.update(purchase1, purchase2);
        assertSame(purchase, actualUpdateResult);
        assertEquals("42", actualUpdateResult.getPrice().toString());
        assertEquals("42", actualUpdateResult.getTotal().toString());
        verify(this.purchaseRepository).save((Purchase) any());
        BigDecimal expectedPrice = purchase1.getPrice();
        assertSame(expectedPrice, purchase2.getPrice());
        assertEquals("Name", purchase2.getName());
        assertEquals("The characteristics of someone or something", purchase2.getDescription());
    }
}

