package com.project.welspyserverv3.domain.auth.client.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RefreshTokenRequest {

    @NotBlank
    private String refreshToken;

}
