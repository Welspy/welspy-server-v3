package com.project.welspyserverv3.domain.auth.client.api;

import com.project.welspyserverv3.domain.auth.client.dto.request.RefreshTokenRequest;
import com.project.welspyserverv3.domain.auth.client.dto.request.SignInRequest;
import com.project.welspyserverv3.domain.auth.client.dto.request.SignUpRequest;
import com.project.welspyserverv3.domain.auth.service.AuthService;
import com.project.welspyserverv3.domain.auth.service.response.JsonWebTokenResponse;
import com.project.welspyserverv3.domain.auth.service.response.RefreshTokenResponse;
import com.project.welspyserverv3.domain.auth.service.response.SignUpResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "인증", description = "인증 API")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @Operation(summary = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseData<SignUpResponse> signUp(@Validated @RequestBody SignUpRequest request) {
        return BaseResponseData.created(
                "회원가입 성공",
                authService.signUp(request));
    }

    @PostMapping("/sign-in")
    @Operation(summary = "로그인")
    public BaseResponseData<JsonWebTokenResponse> signIn(@Validated @RequestBody SignInRequest request) {
        return BaseResponseData.ok(
                "로그인 성공",
                authService.signIn(request));
    }

    @PostMapping("/refresh")
    @Operation(summary = "토큰 재발급")
    public BaseResponseData<RefreshTokenResponse> refresh(RefreshTokenRequest request) {
        return BaseResponseData.ok(
                "재발급 성공",
                authService.refresh(request.refreshToken()));
    }

}
