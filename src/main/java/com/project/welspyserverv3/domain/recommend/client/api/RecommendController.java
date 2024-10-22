package com.project.welspyserverv3.domain.recommend.client.api;

import com.project.welspyserverv3.domain.recommend.service.RecommendService;
import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
@Tag(name = "추천 API")
public class RecommendController {

    private final RecommendService recommendService;

    @GetMapping
    @Operation(summary = "추천 리스트", description = "이메일을 기준으로 사용자에게 추천 데이터를 반환합니다.")
    public BaseResponseData<List<Room>> roomList(@ModelAttribute PageRequest request, HttpServletRequest http) {
        System.out.println(http.getRequestURI()+" - "+http.getRemoteAddr());
        return BaseResponseData.ok(
                "조회 성공",
                recommendService.recommendList(request));
    }

}
