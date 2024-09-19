package com.project.welspyserverv3.domain.auth.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

    private String email;
    private String password;

}
