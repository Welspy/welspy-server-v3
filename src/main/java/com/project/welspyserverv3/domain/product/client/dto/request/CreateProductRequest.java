package com.project.welspyserverv3.domain.product.client.dto.request;

public record CreateProductRequest (
        String name,
        String description,
        Long price,
        Long discount,
        String imageUrl,
        String productUrl

){}