package com.project.welspyserverv3.domain.user.client.api;

import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.service.UserService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "유저 API")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "유저 프로필 조회", description = "유저 프로필을 토큰으로 조회합니다.")
    public BaseResponseData<User> getUser(HttpServletRequest http) {
        System.out.println(http.getRequestURI()+" - "+http.getRemoteAddr());
        return BaseResponseData.ok(
                "유저 프로필 조회 성공",
                userService.getUser()
        );
    }

    @GetMapping("/email")
    @Operation(summary = "유저 프로필 조회", description = "유저 프로필을 이메일을 기준으로 조회합니다.")
    public BaseResponseData<User> getUserByEmail(@RequestParam String email,
                                                 HttpServletRequest http){
        System.out.println(http.getRequestURI()+" - "+http.getRemoteAddr());
        return BaseResponseData.ok(
                "유저 프로필 조회 성공",
                userService.getUserByEmail(email)
        );
    }

    @PatchMapping
    public BaseResponse editUser(@RequestBody User user,
                                 HttpServletRequest http){
        userService.editUser(user);
        System.out.println(http.getRequestURI()+" - "+http.getRemoteAddr());
        return BaseResponse.ok("수정 성공");
    }

    @DeleteMapping
    @Operation(summary = "유저 회원탈퇴")
    public BaseResponse userDelete(HttpServletRequest http){
        userService.userDelete();
        System.out.println(http.getRequestURI()+" - "+http.getRemoteAddr());
        return BaseResponse.ok("회원탈퇴 성공");
    }

}
