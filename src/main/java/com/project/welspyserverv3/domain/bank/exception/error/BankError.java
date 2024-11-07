package com.project.welspyserverv3.domain.bank.exception.error;

import com.project.welspyserverv3.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BankError implements ErrorProperty {

    BANK_ERROR(HttpStatus.BAD_REQUEST, "뱅킹 에러"),
    BANK_NOT_FOUND(HttpStatus.NOT_FOUND, "계좌를 찾을 수 없습니다");

    private final HttpStatus status;
    private final String message;

}
