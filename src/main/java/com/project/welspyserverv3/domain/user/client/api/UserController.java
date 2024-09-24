package com.project.welspyserverv3.domain.user.client.api;

import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.service.UserService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "유저 API")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "유저 프로필 조회", description = "유저 프로필을 토큰으로 조회합니다.")
    public BaseResponseData<User> getUser(){
        return BaseResponseData.ok(
                "유저 프로필 조회 성공",
                userService.getUser()
        );
    }

    @DeleteMapping
    @Operation(summary = "유저 회원탈퇴")
    public BaseResponse userDelete(){
        userService.userDelete();
        return BaseResponse.ok("회원탈퇴 성공");
    }

}
