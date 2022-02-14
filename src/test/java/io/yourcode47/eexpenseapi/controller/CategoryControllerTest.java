package io.yourcode47.eexpenseapi.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.yourcode47.eexpenseapi.dto.CategoryRequestDTO;
import io.yourcode47.eexpenseapi.dto.CategoryResponseDTO;
import io.yourcode47.eexpenseapi.mapper.EexpenseMapper;
import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.service.CategoryService;

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

@ContextConfiguration(classes = {CategoryController.class})
@ExtendWith(SpringExtension.class)
class CategoryControllerTest {
    @Autowired
    private CategoryController categoryController;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private EexpenseMapper eexpenseMapper;

    @Test
    void testCreateCategory() throws Exception {
        ArrayList<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
        categoryResponseDTOList.add(new CategoryResponseDTO("?"));
        when(this.eexpenseMapper.categoriesToResponseDtos((java.util.List<Category>) any()))
                .thenReturn(categoryResponseDTOList);
        when(this.categoryService.findAll()).thenReturn(new ArrayList<>());

        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO();
        categoryRequestDTO.setId(123L);
        categoryRequestDTO.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(categoryRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":null,\"name\":\"?\"}]"));
    }

    @Test
    void testDelete() throws Exception {
        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryService.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/categories/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.categoryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Category with the id 123 was deleted."));
    }

    @Test
    void testGetAllCategories() throws Exception {
        ArrayList<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
        categoryResponseDTOList.add(new CategoryResponseDTO("?"));
        when(this.eexpenseMapper.categoriesToResponseDtos((java.util.List<Category>) any()))
                .thenReturn(categoryResponseDTOList);
        when(this.categoryService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories");
        MockMvcBuilders.standaloneSetup(this.categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":null,\"name\":\"?\"}]"));
    }

    @Test
    void testGetCategoryById() throws Exception {
        when(this.eexpenseMapper.categoryToResponseDto((Category) any())).thenReturn(new CategoryResponseDTO("Name"));

        Category category = new Category();
        category.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setId(123L);
        category.setLastModifiedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        category.setName("Name");
        category.setPurchaseList(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryService.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":null,\"name\":\"Name\"}"));
    }

    @Test
    void testUpdate() throws Exception {
        ArrayList<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
        categoryResponseDTOList.add(new CategoryResponseDTO("?"));
        when(this.eexpenseMapper.categoriesToResponseDtos((java.util.List<Category>) any()))
                .thenReturn(categoryResponseDTOList);
        when(this.categoryService.findAll()).thenReturn(new ArrayList<>());

        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO();
        categoryRequestDTO.setId(123L);
        categoryRequestDTO.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(categoryRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":null,\"name\":\"?\"}]"));
    }
}

