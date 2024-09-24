package com.project.welspyserverv3.domain.product.service;

import com.project.welspyserverv3.domain.product.client.dto.request.CreateProductRequest;
import com.project.welspyserverv3.domain.product.domain.entity.ProductEntity;
import com.project.welspyserverv3.domain.product.domain.repository.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductJpaRepository productJpaRepository;

    public void createProduct(CreateProductRequest request) {
        productJpaRepository.save(ProductEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .build()
        );
    }

}
