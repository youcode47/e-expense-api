package io.yourcode47.eexpenseapi.controller;


import io.swagger.annotations.ApiOperation;
import io.yourcode47.eexpenseapi.config.ControllerAPIPath;
import io.yourcode47.eexpenseapi.dto.CategoryRequestDTO;
import io.yourcode47.eexpenseapi.dto.CategoryResponseDTO;
import io.yourcode47.eexpenseapi.exceptions.ResourceNotFoundException;
import io.yourcode47.eexpenseapi.mapper.EexpenseMapper;
import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static  io.yourcode47.eexpenseapi.config.ControllerAPIPath.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ControllerAPIPath.CATEGORY_BASE_URL)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final EexpenseMapper eexpenseMapper;

    @GetMapping
    @ApiOperation(value = "List all Categories")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<CategoryResponseDTO> categoryResponseDTOS = eexpenseMapper.categoriesToResponseDtos(categoryService.findAll());
        if (!categoryResponseDTOS.isEmpty()) {
            return new ResponseEntity<List<CategoryResponseDTO>>(categoryResponseDTOS, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @GetMapping(GET_BY_ID)
    @ApiOperation(value = "Get category by id")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryService.findById(id);
        return optionalCategory.map(t ->
                        new ResponseEntity<>(eexpenseMapper.categoryToResponseDto(t), HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PostMapping
    @ApiOperation(value = "Create category")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.save(categoryService.save(eexpenseMapper.requestDtoToCategory(categoryRequestDTO)));
        return new ResponseEntity<>(eexpenseMapper.categoryToResponseDto(category), HttpStatus.CREATED);
    }

    @DeleteMapping(DELETE_BY_ID)
    @ApiOperation(value = "Delete category by Id")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Category> optional = categoryService.findById(id);

        return optional.map(t ->
                        new ResponseEntity<>("Category with the id " + id + " was deleted.", HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PutMapping
    @ApiOperation(value = "Update category")
    public ResponseEntity<String> update(@RequestBody CategoryRequestDTO categoryRequestDTOToUpdate){
        Optional<Category> categoryToSaveOptional = categoryService.findById(categoryRequestDTOToUpdate.getId());
        categoryToSaveOptional.ifPresent(n -> categoryService.update(eexpenseMapper.requestDtoToCategory(categoryRequestDTOToUpdate), n));

        return categoryToSaveOptional.map(n ->
                        new ResponseEntity<>("Category with id " + categoryRequestDTOToUpdate.getId() + " was updated.", HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException(categoryRequestDTOToUpdate.getId()));
    }
}
