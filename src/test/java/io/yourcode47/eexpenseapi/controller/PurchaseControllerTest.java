package io.yourcode47.eexpenseapi.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.yourcode47.eexpenseapi.dto.PurchaseRequestDTO;
import io.yourcode47.eexpenseapi.dto.PurchaseResponseDTO;
import io.yourcode47.eexpenseapi.mapper.PurchaseMapper;
import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.model.Purchase;
import io.yourcode47.eexpenseapi.service.CategoryService;
import io.yourcode47.eexpenseapi.service.PurchaseService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PurchaseController.class})
@ExtendWith(SpringExtension.class)
class PurchaseControllerTest {
    @MockBean
    private CategoryService categoryService;

    @Autowired
    private PurchaseController purchaseController;

    @MockBean
    private PurchaseMapper purchaseMapper;

    @MockBean
    private PurchaseService purchaseService;

    @Test
    void testCreateCategory() throws Exception {
        when(this.purchaseService.findAll()).thenReturn(new ArrayList<>());

        ArrayList<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseResponseDTOList.add(new PurchaseResponseDTO());
        when(this.purchaseMapper.purchasesToResponseDtos((java.util.List<Purchase>) any()))
                .thenReturn(purchaseResponseDTOList);

        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setCategoryId(123L);
        purchaseRequestDTO.setDescription("The characteristics of someone or something");
        purchaseRequestDTO.setId(123L);
        purchaseRequestDTO.setName("Name");
        purchaseRequestDTO.setPrice(BigDecimal.valueOf(42L));
        purchaseRequestDTO.setQuantity(1);
        purchaseRequestDTO.setTotal(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(purchaseRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}]"));
    }

    @Test
    void testCreateCategory2() throws Exception {
        when(this.purchaseService.findAll()).thenReturn(new ArrayList<>());

        ArrayList<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseResponseDTOList.add(new PurchaseResponseDTO());
        when(this.purchaseMapper.purchasesToResponseDtos((java.util.List<Purchase>) any()))
                .thenReturn(purchaseResponseDTOList);

        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setCategoryId(123L);
        purchaseRequestDTO.setDescription("The characteristics of someone or something");
        purchaseRequestDTO.setId(123L);
        purchaseRequestDTO.setName("Name");
        purchaseRequestDTO.setPrice(BigDecimal.valueOf(42L));
        purchaseRequestDTO.setQuantity(1);
        purchaseRequestDTO.setTotal(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(purchaseRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}]"));
    }

    @Test
    void testDelete() throws Exception {
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
        when(this.purchaseService.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/purchases/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Purchase with the id 123 was deleted."));
    }

    @Test
    void testDelete2() throws Exception {
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
        when(this.purchaseService.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/purchases/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Purchase with the id 123 was deleted."));
    }

    @Test
    void testGetAllPurchases() throws Exception {
        when(this.purchaseService.findAll()).thenReturn(new ArrayList<>());

        ArrayList<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseResponseDTOList.add(new PurchaseResponseDTO());
        when(this.purchaseMapper.purchasesToResponseDtos((java.util.List<Purchase>) any()))
                .thenReturn(purchaseResponseDTOList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases");
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}]"));
    }

    @Test
    void testGetAllPurchases2() throws Exception {
        when(this.purchaseService.findAll()).thenReturn(new ArrayList<>());

        ArrayList<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseResponseDTOList.add(new PurchaseResponseDTO());
        when(this.purchaseMapper.purchasesToResponseDtos((java.util.List<Purchase>) any()))
                .thenReturn(purchaseResponseDTOList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases");
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}]"));
    }

    @Test
    void testGetPurchaseById() throws Exception {
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
        when(this.purchaseService.findById((Long) any())).thenReturn(ofResult);
        when(this.purchaseMapper.purchaseToResponseDto((Purchase) any())).thenReturn(new PurchaseResponseDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}"));
    }

    @Test
    void testGetPurchaseById2() throws Exception {
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
        when(this.purchaseService.findById((Long) any())).thenReturn(ofResult);
        when(this.purchaseMapper.purchaseToResponseDto((Purchase) any())).thenReturn(new PurchaseResponseDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}"));
    }

    @Test
    void testUpdate() throws Exception {
        when(this.purchaseService.findAll()).thenReturn(new ArrayList<>());

        ArrayList<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseResponseDTOList.add(new PurchaseResponseDTO());
        when(this.purchaseMapper.purchasesToResponseDtos((java.util.List<Purchase>) any()))
                .thenReturn(purchaseResponseDTOList);

        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setCategoryId(123L);
        purchaseRequestDTO.setDescription("The characteristics of someone or something");
        purchaseRequestDTO.setId(123L);
        purchaseRequestDTO.setName("Name");
        purchaseRequestDTO.setPrice(BigDecimal.valueOf(42L));
        purchaseRequestDTO.setQuantity(1);
        purchaseRequestDTO.setTotal(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(purchaseRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}]"));
    }

    @Test
    void testUpdate2() throws Exception {
        when(this.purchaseService.findAll()).thenReturn(new ArrayList<>());

        ArrayList<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseResponseDTOList.add(new PurchaseResponseDTO());
        when(this.purchaseMapper.purchasesToResponseDtos((java.util.List<Purchase>) any()))
                .thenReturn(purchaseResponseDTOList);

        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setCategoryId(123L);
        purchaseRequestDTO.setDescription("The characteristics of someone or something");
        purchaseRequestDTO.setId(123L);
        purchaseRequestDTO.setName("Name");
        purchaseRequestDTO.setPrice(BigDecimal.valueOf(42L));
        purchaseRequestDTO.setQuantity(1);
        purchaseRequestDTO.setTotal(BigDecimal.valueOf(42L));
        String content = (new ObjectMapper()).writeValueAsString(purchaseRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/purchases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.purchaseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"name\":null,\"description\":null,\"price\":null,\"quantity\":0,\"total\":null,\"categoryResponseDTO"
                                        + "\":null}]"));
    }
}

