package com.leonovalexprog.service.price;

import com.leonovalexprog.dto.PriceRequestDto;
import com.leonovalexprog.dto.PriceResponseDto;

public interface PriceService {
    PriceResponseDto addPrice(long productId, PriceRequestDto priceRequestDto);

    PriceResponseDto readPrice(long productId);

    PriceResponseDto updatePrice(long productId, PriceRequestDto newPrice);

    void deletePrice(long productId);
}
