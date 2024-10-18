package com.project.welspyserverv3.domain.email.client.api;

import com.project.welspyserverv3.domain.email.client.request.EmailCheckRequest;
import com.project.welspyserverv3.domain.email.client.request.EmailSendRequest;
import com.project.welspyserverv3.domain.email.service.EmailService;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@Tag(name = "이메일", description = "이메일 API")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    @Operation(summary = "이메일 전송")
    public BaseResponse sendEmail(@RequestBody EmailSendRequest request) {
        emailService.joinEmail(request.email());
        return BaseResponse.ok("이메일 전송 성공");
    }

    @PostMapping("/check")
    @Operation(summary = "이메일 인증")
    public BaseResponse checkEmail(@RequestBody EmailCheckRequest request) {
        return emailService.checkAuthNum(request.email(),request.authNum());
    }

}
