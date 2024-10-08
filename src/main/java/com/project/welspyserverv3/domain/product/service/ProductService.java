package com.project.welspyserverv3.domain.product.service;

import com.project.welspyserverv3.domain.product.client.dto.Product;
import com.project.welspyserverv3.domain.product.client.dto.request.CreateProductRequest;
import com.project.welspyserverv3.domain.product.domain.entity.ProductEntity;
import com.project.welspyserverv3.domain.product.domain.repository.jpa.ProductJpaRepository;
import com.project.welspyserverv3.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductJpaRepository productJpaRepository;
    private final Product productDto;

    public void createProduct(CreateProductRequest request) {
        Long price = request.getPrice();
        productJpaRepository.save(ProductEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .discountedPrice(price - (price * request.getDiscount() / 100))
                .imageUrl(request.getImageUrl())
                .build()
        );
    }

    public Product getProduct(Long idx) {
        return productJpaRepository
                .findById(idx)
                .map(productDto::toProduct)
                .orElseThrow(()-> ProductNotFoundException.EXCEPTION);
    }

}
