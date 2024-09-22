package com.project.welspyserverv3.domain.room.exception;

import com.project.welspyserverv3.domain.room.exception.error.RoomError;
import com.project.welspyserverv3.global.exception.BusinessException;

public class MemberLimitOverException extends BusinessException {

    public static final MemberLimitOverException EXCEPTION = new MemberLimitOverException();

    private MemberLimitOverException() {
        super(RoomError.MEMBER_LIMIT_OVER);
    }

}
