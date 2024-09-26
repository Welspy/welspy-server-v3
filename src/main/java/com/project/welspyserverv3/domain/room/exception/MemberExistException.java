package com.project.welspyserverv3.domain.room.exception;

import com.project.welspyserverv3.domain.room.exception.error.RoomError;
import com.project.welspyserverv3.global.exception.BusinessException;

public class MemberExistException extends BusinessException {

    public static final MemberExistException EXCEPTION = new MemberExistException();

    private MemberExistException() {
        super(RoomError.MEMBER_EXIST);
    }

}
