package com.project.welspyserverv3.domain.data.client.api;

import com.project.welspyserverv3.domain.data.client.dto.DataResponse;
import com.project.welspyserverv3.domain.data.client.dto.RoomIdResponse;
import com.project.welspyserverv3.domain.data.service.UserActionService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@Tag(name = "데이터 API")
public class UserActionController {

    private final UserActionService userActionService;

    @GetMapping
    @Operation(summary = "데이터 목록 조회")
    public BaseResponseData<List<DataResponse>> getAllUserActions() {
        return BaseResponseData.ok(
                "조회 성공",
                userActionService.getAllUserActions());
    }

    @GetMapping("/id")
    @Operation(summary = "챌린지 ID 전체 조회")
    public BaseResponseData<List<RoomIdResponse>> getAllRoomId() {
        return BaseResponseData.ok(
                "조회 성공",
                userActionService.getAllRoomId());
    }

}
