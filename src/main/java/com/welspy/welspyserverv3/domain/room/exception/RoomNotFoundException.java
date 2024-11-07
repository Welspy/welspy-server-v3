package com.welspy.welspyserverv3.domain.room.exception;

import com.welspy.welspyserverv3.domain.room.exception.error.RoomError;
import com.welspy.welspyserverv3.global.exception.BusinessException;

public class RoomNotFoundException extends BusinessException {

    public static final RoomNotFoundException EXCEPTION = new RoomNotFoundException();

    private RoomNotFoundException(){
        super(RoomError.ROOM_NOT_FOUND);
    }

}
