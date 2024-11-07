package com.project.welspyserverv3.domain.product.client.dto.request;

import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchRequest extends PageRequest {

    private String name;

}