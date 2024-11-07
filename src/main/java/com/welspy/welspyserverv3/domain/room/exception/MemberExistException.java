package com.welspy.welspyserverv3.domain.room.exception;

import com.welspy.welspyserverv3.domain.room.exception.error.RoomError;
import com.welspy.welspyserverv3.global.exception.BusinessException;

public class MemberExistException extends BusinessException {

    public static final MemberExistException EXCEPTION = new MemberExistException();

    private MemberExistException() {
        super(RoomError.MEMBER_EXIST);
    }

}
