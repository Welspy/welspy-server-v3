package com.project.welspyserverv3.domain.auth.client.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SignUpRequest(
        @NotBlank
        @Email
        String email,
        String name,
        @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "정해진 핸드폰 양식을 따라주세요 (010-0000-0000)")
        String phoneNumber,
        String password,
        String imageUrl
){}
