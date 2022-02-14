package io.yourcode47.eexpenseapi.mapper;

import io.yourcode47.eexpenseapi.dto.PurchaseRequestDTO;
import io.yourcode47.eexpenseapi.dto.PurchaseResponseDTO;
import io.yourcode47.eexpenseapi.model.Purchase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    PurchaseRequestDTO purchaseToPurchaseRequestDTO(Purchase purchase);
    Purchase purchaseRequestDtoToPurchase(PurchaseRequestDTO categoryRequestDTO);

    PurchaseResponseDTO purchaseToResponseDto(Purchase purchase);
    List<PurchaseResponseDTO> purchasesToResponseDtos(List<Purchase> purchases);
}
