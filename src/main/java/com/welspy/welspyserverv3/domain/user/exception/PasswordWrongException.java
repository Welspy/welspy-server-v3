package com.welspy.welspyserverv3.domain.user.exception;

import com.welspy.welspyserverv3.domain.user.exception.error.UserError;
import com.welspy.welspyserverv3.global.exception.BusinessException;

public class PasswordWrongException extends BusinessException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException(){
        super(UserError.PASSWORD_WRONG);
    }

}
