package com.leonovalexprog.mapper;

import com.leonovalexprog.dto.PriceResponseDto;
import com.leonovalexprog.model.Price;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PriceMapper {
    public static PriceResponseDto toDto(Price price) {
        return PriceResponseDto.builder()
                .id(price.getId())
                .chainName(price.getChainName())
                .product(ProductMapper.toShortDto(price.getProduct()))
                .price(price.getPrice())
                .build();
    }
}
