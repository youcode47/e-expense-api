package io.yourcode47.eexpenseapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDTO extends BaseDTO {
    @ApiModelProperty(value = "The name of the category")
    private String name;
}
