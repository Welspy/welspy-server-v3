package com.project.welspyserverv3.domain.room.client.api;

import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomCreateRequest;
import com.project.welspyserverv3.domain.room.service.RoomService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@Tag(name = "챌린지 API")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "챌린지 방 생성")
    public BaseResponse createRoom(RoomCreateRequest request) {
        roomService.createRoom(request);
        return BaseResponse.created("방 생성 성공");
    }

}
