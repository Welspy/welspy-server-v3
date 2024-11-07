package com.welspy.welspyserverv3.domain.email.exception;

import com.welspy.welspyserverv3.domain.email.exception.error.EmailError;
import com.welspy.welspyserverv3.global.exception.BusinessException;

public class EmailErrorException extends BusinessException {

    public static final EmailErrorException EXCEPTION = new EmailErrorException();

    private EmailErrorException(){
        super(EmailError.EMAIL_ERROR);
    }

}