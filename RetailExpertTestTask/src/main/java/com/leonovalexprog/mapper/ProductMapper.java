package com.leonovalexprog.mapper;

import com.leonovalexprog.dto.ProductShortDto;
import com.leonovalexprog.model.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {
    public static ProductShortDto toShortDto(Product product) {
        return ProductShortDto.builder()
                .brand(product.getBrand())
                .name(product.getName())
                .build();
    }
}
