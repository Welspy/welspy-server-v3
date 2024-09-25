package com.project.welspyserverv3.domain.product.client.api;

import com.project.welspyserverv3.domain.product.client.dto.Product;
import com.project.welspyserverv3.domain.product.client.dto.request.CreateProductRequest;
import com.project.welspyserverv3.domain.product.client.dto.request.ProductSearchRequest;
import com.project.welspyserverv3.domain.product.service.ProductQueryService;
import com.project.welspyserverv3.domain.product.service.ProductService;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "제품 API")
public class ProductController {

    private final ProductService productService;
    private final ProductQueryService productQueryService;

    @PostMapping
    @Operation(summary = "제품 등록")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse createProduct(@RequestBody CreateProductRequest request) {
        productService.createProduct(request);
        return BaseResponse.created("등록 성공");
    }

    @GetMapping
    @Operation(summary = "제품 조회")
    public BaseResponseData<Product> getProduct(@RequestParam Long idx){
        return BaseResponseData.ok(
                "조회 성공",
                productService.getProduct(idx));
    }

    @GetMapping("/list")
    @Operation(summary = "제품 목록")
    public BaseResponseData<List<Product>> productList(@ModelAttribute PageRequest request) {
        return BaseResponseData.ok(
                "목록 출력 성공",
                productQueryService.productList(request));
    }

    @GetMapping("/search")
    @Operation(summary = "제품 검색")
    public BaseResponseData<List<Product>> productListSearch(@ModelAttribute ProductSearchRequest request) {
        return BaseResponseData.ok(
                "목록 출력 성공",
                productQueryService.productSearch(request));
    }

}
