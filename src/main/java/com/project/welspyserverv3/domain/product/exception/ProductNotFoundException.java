package com.project.welspyserverv3.domain.product.exception;

import com.project.welspyserverv3.domain.product.exception.error.ProductError;
import com.project.welspyserverv3.global.exception.BusinessException;

public class ProductNotFoundException extends BusinessException {

    public static final ProductNotFoundException EXCEPTION = new ProductNotFoundException();

    private ProductNotFoundException(){
        super(ProductError.PRODUCT_NOT_FOUND);
    }

}
