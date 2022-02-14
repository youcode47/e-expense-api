package io.yourcode47.eexpenseapi.mapper;

import io.yourcode47.eexpenseapi.dto.CategoryRequestDTO;
import io.yourcode47.eexpenseapi.dto.CategoryResponseDTO;
import io.yourcode47.eexpenseapi.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryRequestDTO categoryToRequestDto(Category category);
    Category requestDtoToCategory(CategoryRequestDTO categoryRequestDTO);

    List<CategoryResponseDTO> categoriesToResponseDtos(List<Category> categories);

    CategoryResponseDTO categoryToResponseDto(Category category);
}
