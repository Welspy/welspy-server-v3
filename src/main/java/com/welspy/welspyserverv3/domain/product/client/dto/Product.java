package com.welspy.welspyserverv3.domain.product.client.dto;

import com.welspy.welspyserverv3.domain.product.domain.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long idx;
    private String name;
    private String description;
    private Long price;
    private Long discount;
    private Long discountedPrice;
    private String imageUrl;
    private String productUrl;

    public Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .idx(productEntity.getIdx())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .discount(productEntity.getDiscount())
                .discountedPrice(productEntity.getDiscountedPrice())
                .imageUrl(productEntity.getImageUrl())
                .productUrl(productEntity.getProductUrl())
                .build();
    }

}