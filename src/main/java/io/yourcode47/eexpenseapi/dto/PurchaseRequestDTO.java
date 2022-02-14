package io.yourcode47.eexpenseapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDTO extends BaseDTO {

    @ApiModelProperty(value = "The name of the purchase")
    private String name;

    @ApiModelProperty(value = "The description of the purchase")
    private String description;

    @ApiModelProperty(value = "The price of the purchase")
    private BigDecimal price;

    @ApiModelProperty(value = "The quantity of the purchase")
    private int quantity;

    @ApiModelProperty(value = "The total of the purchase")
    private BigDecimal total;

    @ApiModelProperty(value = "The id of the category")
    private Long categoryId;
}