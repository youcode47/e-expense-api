package io.yourcode47.eexpenseapi.mapper;

import io.yourcode47.eexpenseapi.dto.CategoryRequestDTO;
import io.yourcode47.eexpenseapi.dto.CategoryResponseDTO;
import io.yourcode47.eexpenseapi.dto.PurchaseRequestDTO;
import io.yourcode47.eexpenseapi.dto.PurchaseResponseDTO;
import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.model.Purchase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EexpenseMapper {

    CategoryRequestDTO categoryToRequestDto(Category category);
    Category requestDtoToCategory(CategoryRequestDTO categoryRequestDTO);

    List<CategoryResponseDTO> categoriesToResponseDtos(List<Category> categories);

    CategoryResponseDTO categoryToResponseDto(Category category);

    PurchaseRequestDTO purchaseToPurchaseRequestDTO(Purchase purchase);
    Purchase purchaseRequestDtoToPurchase(PurchaseRequestDTO categoryRequestDTO);

    PurchaseResponseDTO purchaseToResponseDto(Purchase purchase);
    List<PurchaseResponseDTO> purchasesToResponseDtos(List<Purchase> purchases);
}
