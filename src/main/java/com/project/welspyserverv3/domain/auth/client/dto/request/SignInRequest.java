package com.project.welspyserverv3.domain.auth.client.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
