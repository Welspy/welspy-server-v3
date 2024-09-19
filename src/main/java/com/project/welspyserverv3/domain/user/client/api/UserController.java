package com.project.welspyserverv3.domain.user.client.api;

import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.client.dto.request.EmailEditRequest;
import com.project.welspyserverv3.domain.user.client.dto.request.NameEditRequest;
import com.project.welspyserverv3.domain.user.usecase.UserUseCase;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "유저", description = "유저 API")
public class UserController {

    public final UserUseCase userUseCase;

    @GetMapping("")
    @Operation(summary = "유저 프로필", description = "현재 로그인한 유저 정보를 불러옵니다.")
    public BaseResponseData<User> getUser(){
        return BaseResponseData.ok(
                "프로필 불러오기 성공",
                userUseCase.getUser());
    }

    @PatchMapping("/name")
    @Operation(summary = "유저 이름 수정", description = "유저의 이름을 수정합니다.")
    public BaseResponse editName(@RequestBody NameEditRequest request){
        userUseCase.editName(request);
        return BaseResponse.ok("이름 수정 성공");
    }

    @PatchMapping("/email")
    @Operation(summary = "유저 이메일 수정", description = "유저의 이메일을 수정합니다.")
    public BaseResponse editEmail(@RequestBody EmailEditRequest request){
        userUseCase.editEmail(request);
        return BaseResponse.ok("이메일 수정 성공");
    }

}
