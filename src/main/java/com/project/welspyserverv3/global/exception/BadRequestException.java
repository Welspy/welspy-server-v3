package com.project.welspyserverv3.global.exception;

import com.project.welspyserverv3.global.exception.error.ErrorCode;

public class BadRequestException extends BusinessException {

    public static final BadRequestException EXCEPTION = new BadRequestException();

    private BadRequestException(){
        super(ErrorCode.BAD_REQUEST);
    }

}
