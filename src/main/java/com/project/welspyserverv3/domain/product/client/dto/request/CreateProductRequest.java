package com.project.welspyserverv3.domain.product.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {

    private String name;
    private String description;
    private Long price;
    private Long discount;
    private String imageUrl;

}
