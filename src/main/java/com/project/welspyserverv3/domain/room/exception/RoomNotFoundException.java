package com.project.welspyserverv3.domain.room.exception;

import com.project.welspyserverv3.domain.room.exception.error.RoomError;
import com.project.welspyserverv3.global.exception.BusinessException;

public class RoomNotFoundException extends BusinessException {

    public static final RoomNotFoundException EXCEPTION = new RoomNotFoundException();

    private RoomNotFoundException(){
        super(RoomError.ROOM_NOT_FOUND);
    }

}
