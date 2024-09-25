package com.project.welspyserverv3.domain.product.exception.error;

import com.project.welspyserverv3.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ProductError implements ErrorProperty {

    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "제품을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

}
