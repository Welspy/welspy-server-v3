package com.project.welspyserverv3.domain.room.exception.error;

import com.project.welspyserverv3.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RoomError implements ErrorProperty {

    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "방을 찾을 수 없습니다"),
    MEMBER_LIMIT_OVER(HttpStatus.BAD_REQUEST, "멤버 수 제한을 넘었습니다"),
    MEMBER_EXIST(HttpStatus.CONFLICT, "이미 가입된 방입니다.");

    private final HttpStatus status;
    private final String message;

}
