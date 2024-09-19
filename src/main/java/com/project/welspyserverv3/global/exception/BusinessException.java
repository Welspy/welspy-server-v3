package com.project.welspyserverv3.global.exception;

import com.project.welspyserverv3.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {

    private final ErrorProperty error;

}
