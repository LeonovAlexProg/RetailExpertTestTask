package com.leonovalexprog.service;

import com.leonovalexprog.dto.PriceRequestDto;
import com.leonovalexprog.dto.PriceResponseDto;
import com.leonovalexprog.mapper.PriceMapper;
import com.leonovalexprog.model.Price;
import com.leonovalexprog.model.Product;
import com.leonovalexprog.repository.PriceRepository;
import com.leonovalexprog.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService{
    private final PriceRepository priceRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public PriceResponseDto addPrice(long productId, PriceRequestDto priceRequestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with id = " + productId + " not found"));

        Price price = Price.builder()
                .chainName(priceRequestDto.getChainName())
                .price(priceRequestDto.getPrice())
                .product(product)
                .build();

        Price newPrice = priceRepository.save(price);

        product.getPrices().add(price);
        productRepository.save(product);

        return PriceMapper.toDto(newPrice);
    }

    @Override
    @Transactional
    public PriceResponseDto readPrice(long priceId) {
        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException("Price with id = " + priceId + " not found"));

        return PriceMapper.toDto(price);
    }

    @Override
    @Transactional
    public PriceResponseDto updatePrice(long priceId, PriceRequestDto newPrice) {
        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException("PriceId with id = " + priceId + " not found"));

        if (newPrice.getPrice() != null)
            price.setPrice(newPrice.getPrice());
        if (newPrice.getChainName() != null)
            price.setChainName(newPrice.getChainName());

        Price updatedPrice = priceRepository.save(price);

        return PriceMapper.toDto(updatedPrice);
    }

    @Override
    @Transactional
    public void deletePrice(long priceId) {
        Price price = priceRepository.findById(priceId)
                .orElseThrow(() -> new EntityNotFoundException("Price with id = " + priceId + " not found"));

        priceRepository.deleteById(priceId);
    }
}
