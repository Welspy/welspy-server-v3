package com.project.welspyserverv3.domain.auth.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    private String email;
    private String name;
    private String phoneNumber;
    private String password;

}
