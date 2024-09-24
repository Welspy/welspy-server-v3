package com.project.welspyserverv3.domain.product.client.api;

import com.project.welspyserverv3.domain.product.client.dto.Product;
import com.project.welspyserverv3.domain.product.client.dto.request.CreateProductRequest;
import com.project.welspyserverv3.domain.product.service.ProductService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "제품 API")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @Operation(summary = "제품 등록")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse createProduct(@RequestBody CreateProductRequest request) {
        productService.createProduct(request);
        return BaseResponse.created("등록 성공");
    }

}
