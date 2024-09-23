package com.project.welspyserverv3.domain.room.client.api;

import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomCreateRequest;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomJoinRequest;
import com.project.welspyserverv3.domain.room.service.RoomQueryService;
import com.project.welspyserverv3.domain.room.service.RoomService;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@Tag(name = "챌린지 API")
public class RoomController {

    private final RoomService roomService;
    private final RoomQueryService roomQueryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "챌린지 방 생성")
    public BaseResponse createRoom(@RequestBody RoomCreateRequest request) {
        roomService.createRoom(request);
        return BaseResponse.created("방 생성 성공");
    }

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "챌린지 가입")
    public BaseResponse joinRoom(@RequestBody RoomJoinRequest request) {
        roomService.joinRoom(request);
        return BaseResponse.created("방 가입 성공");
    }

    @GetMapping
    @Operation(summary = "챌린지 목록 출력")
    public BaseResponseData<List<Room>> roomList(PageRequest request) {
        return BaseResponseData.ok(
                "목록 출럭 성공",
                roomQueryService.roomList(request));
    }

}
