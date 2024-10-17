package com.project.welspyserverv3.global.security.jwt.exception;

import com.project.welspyserverv3.global.exception.BusinessException;
import com.project.welspyserverv3.global.security.jwt.exception.error.JwtTokenError;

public class TokenTypeException extends BusinessException {

    public static final TokenTypeException EXCEPTION = new TokenTypeException();

    private TokenTypeException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }

}