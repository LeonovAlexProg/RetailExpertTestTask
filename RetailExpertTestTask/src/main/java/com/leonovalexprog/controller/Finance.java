package com.leonovalexprog.controller;

import com.leonovalexprog.dto.PriceRequestDto;
import com.leonovalexprog.dto.PriceResponseDto;
import com.leonovalexprog.service.PriceService;
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

    @GetMapping("/price/{priceId}")
    public PriceResponseDto getPrice(@PathVariable long priceId) {
        log.info("Get price info (priceId = {})", priceId);

        return priceService.readPrice(priceId);
    }

    @PatchMapping("/price/{priceId}")
    public PriceResponseDto patchPrice(@PathVariable long priceId, @RequestBody PriceRequestDto newPrice) {
        log.info("Add new price (priceId = {}, chainName = {}, price = {}", priceId, newPrice.getChainName(), newPrice.getPrice());

        return priceService.updatePrice(priceId, newPrice);
    }

    @DeleteMapping("/price/{priceId}")
    public void deletePrice(@PathVariable long priceId) {
        log.info("Delete price (priceId = {})", priceId);

        priceService.deletePrice(priceId);
    }
}
