package com.project.welspyserverv3.domain.email.exception.error;

import com.project.welspyserverv3.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EmailError implements ErrorProperty {

    EMAIL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "이메일 전송 에러");

    private final HttpStatus status;
    private final String message;

}
