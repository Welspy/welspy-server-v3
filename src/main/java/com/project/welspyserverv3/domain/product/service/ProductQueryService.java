package com.project.welspyserverv3.domain.product.service;

import com.project.welspyserverv3.domain.product.client.dto.Product;
import com.project.welspyserverv3.domain.product.client.dto.request.ProductSearchRequest;
import com.project.welspyserverv3.domain.product.domain.repository.query.ProductQueryRepository;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductQueryRepository productQueryRepository;

    public List<Product> productList(PageRequest request){
        return productQueryRepository.productList(request);
    }

    public List<Product> productSearch(ProductSearchRequest request){
        return productQueryRepository.productSearch(request);
    }

}
