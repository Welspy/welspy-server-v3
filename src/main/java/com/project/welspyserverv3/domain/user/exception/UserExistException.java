package com.project.welspyserverv3.domain.user.exception;

import com.project.welspyserverv3.domain.user.exception.error.UserError;
import com.project.welspyserverv3.global.exception.BusinessException;

public class UserExistException extends BusinessException {

    public static final UserExistException EXCEPTION = new UserExistException();

    public UserExistException() {
        super(UserError.USER_EXIST);
    }
}
