package com.leonovalexprog.service.price;

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
import lombok.Setter;
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

        product.setPrice(newPrice);
        productRepository.save(product);

        return PriceMapper.toDto(newPrice);
    }

    @Override
    @Transactional
    public PriceResponseDto readPrice(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with id = " + productId + " not found"));
        Price price = product.getPrice();

        return PriceMapper.toDto(price);
    }

    @Override
    @Transactional
    public PriceResponseDto updatePrice(long productId, PriceRequestDto newPrice) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with id = " + productId + " not found"));
        Price price = product.getPrice();

        if (newPrice.getChainName() != null)
            price.setChainName(newPrice.getChainName());
        if (newPrice.getPrice() != null)
            price.setPrice(price.getPrice());

        Price savedPrice = priceRepository.save(price);

        return PriceMapper.toDto(savedPrice);
    }

    @Override
    @Transactional
    public void deletePrice(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with id = " + productId + " not found"));
        Price price = product.getPrice();

        priceRepository.delete(price);
    }
}
