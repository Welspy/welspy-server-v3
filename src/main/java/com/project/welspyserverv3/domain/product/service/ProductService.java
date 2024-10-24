package com.project.welspyserverv3.domain.product.service;

import com.project.welspyserverv3.domain.product.client.dto.Product;
import com.project.welspyserverv3.domain.product.client.dto.request.CreateProductRequest;
import com.project.welspyserverv3.domain.product.domain.entity.ProductEntity;
import com.project.welspyserverv3.domain.product.domain.repository.jpa.ProductJpaRepository;
import com.project.welspyserverv3.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductJpaRepository productJpaRepository;
    private final Product productDto;

    public void createProduct(CreateProductRequest request) throws BadRequestException {
        Long price = request.price();
        Long discountedPrice = price - (price * request.discount() / 100);
        if (discountedPrice < 0) {
            throw new BadRequestException("할인된 가격은 음수일 수 없습니다");
        }
        productJpaRepository.save(ProductEntity.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .discount(request.discount())
                .discountedPrice(discountedPrice)
                .imageUrl(request.imageUrl())
                .productUrl(request.productUrl())
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
