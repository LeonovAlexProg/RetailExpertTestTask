package com.leonovalexprog.controller;

import com.leonovalexprog.dto.PriceRequestDto;
import com.leonovalexprog.dto.PriceResponseDto;
import com.leonovalexprog.service.price.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Finance {
    private final PriceService priceService;

    @PostMapping("/product/{productId}/price")
    public PriceResponseDto postPrice(@PathVariable long productId, @RequestBody PriceRequestDto newPrice) {
        log.info("Add new price (productId = {}, chainName = {}, price = {}", productId, newPrice.getChainName(), newPrice.getPrice());

        return priceService.addPrice(productId, newPrice);
    }

    @GetMapping("/product/{productId}/price")
    public PriceResponseDto getPrice(@PathVariable long productId) {
        log.info("Get price info (productId = {})", productId);

        return priceService.readPrice(productId);
    }

    @PatchMapping("/product/{productId}/price")
    public PriceResponseDto patchPrice(@PathVariable long productId, @RequestBody PriceRequestDto newPrice) {
        log.info("Add new price (productId = {}, chainName = {}, price = {}", productId, newPrice.getChainName(), newPrice.getPrice());

        return priceService.updatePrice(productId, newPrice);
    }

    @DeleteMapping("/product/{productId}/price")
    public void deletePrice(@PathVariable long productId) {
        log.info("Delete price (productId = {})", productId);

        priceService.deletePrice(productId);
    }
}
