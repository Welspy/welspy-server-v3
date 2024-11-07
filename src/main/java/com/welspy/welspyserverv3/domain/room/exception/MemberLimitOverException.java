package com.welspy.welspyserverv3.domain.room.exception;

import com.welspy.welspyserverv3.domain.room.exception.error.RoomError;
import com.welspy.welspyserverv3.global.exception.BusinessException;

public class MemberLimitOverException extends BusinessException {

    public static final MemberLimitOverException EXCEPTION = new MemberLimitOverException();

    private MemberLimitOverException() {
        super(RoomError.MEMBER_LIMIT_OVER);
    }

}
