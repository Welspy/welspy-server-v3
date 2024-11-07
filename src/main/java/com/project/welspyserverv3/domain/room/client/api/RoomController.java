package com.project.welspyserverv3.domain.room.client.api;

import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomCreateRequest;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomJoinRequest;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomMemberListRequest;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomSearchRequest;
import com.project.welspyserverv3.domain.room.service.RoomQueryService;
import com.project.welspyserverv3.domain.room.service.RoomService;
import com.project.welspyserverv3.domain.room.service.response.RoomMemberListResponse;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    @Operation(summary = "챌린지 단일 조회", description = "roomId를 기준으로 챌린지를 단일 조회합니다.")
    public BaseResponseData<Room> getRoom(@RequestParam Long roomId) {
        return BaseResponseData.ok(
                "조회 성공",
                roomService.getRoomById(roomId));
    }

    @GetMapping("/list")
    @Operation(summary = "챌린지 목록 출력")
    public BaseResponseData<List<Room>> roomList(@ModelAttribute PageRequest request) {
        return BaseResponseData.ok(
                "목록 출럭 성공",
                roomQueryService.roomList(request));
    }

    @GetMapping("/search")
    @Operation(summary = "챌린지 검색", description = "제목을 기준으로 해당 제목이 포함된 챌린지를 검색합니다.")
    public BaseResponseData<List<Room>> roomSearch(@ModelAttribute RoomSearchRequest request) {
        return BaseResponseData.ok(
                "검색 성공",
                roomQueryService.roomSearch(request));
    }

    @GetMapping("/private")
    @Operation(summary = "비공개 챌리지 목록")
    public BaseResponseData<List<Room>> privateRoomList(@ModelAttribute PageRequest request) {
        return BaseResponseData.ok(
                "목록 출력 성공",
                roomQueryService.privateRoom(request));
    }

    @GetMapping("/public")
    @Operation(summary = "공개 챌린지 목록")
    public BaseResponseData<List<Room>> publicRoomList(@ModelAttribute PageRequest request) {
        return BaseResponseData.ok(
                "목록 출력 성공",
                roomQueryService.publicRoom(request));
    }

    @GetMapping("/my-room")
    @Operation(summary = "내 챌린지 목록", description = "현재 로그인한 유저가 들어간 챌린지 명단을 출력합니다.")
    public BaseResponseData<List<MemberList>> myRoomList(@ModelAttribute PageRequest request) {
        return BaseResponseData.ok(
                "목록 출력 성공",
                roomQueryService.myRoomList(request));
    }

    @GetMapping("/member")
    @Operation(summary = "방에 가입한 명단 출력")
    public BaseResponseData<List<RoomMemberListResponse>> memberList(@ModelAttribute RoomMemberListRequest request) {
        return BaseResponseData.ok(
                "명단 출력 성공",
                roomQueryService.roomMemberList(request));
    }

    @DeleteMapping("/exit")
    @Operation(summary = "방 탈퇴")
    public BaseResponse exitRoom(@RequestParam Long roomId) {
        roomService.exitRoom(roomId);
        return BaseResponse.ok("방 탈퇴 성공");
    }

    @DeleteMapping
    @Operation(summary = "방 삭제")
    public BaseResponse deleteRoom(@RequestParam Long roomId) {
        roomService.deleteRoom(roomId);
        return BaseResponse.ok("방 삭제 성공");
    }

}
