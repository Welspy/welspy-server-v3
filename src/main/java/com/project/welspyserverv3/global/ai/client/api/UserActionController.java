package com.project.welspyserverv3.global.ai.client.api;

import com.project.welspyserverv3.global.ai.client.dto.DataResponse;
import com.project.welspyserverv3.global.ai.service.UserActionService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
