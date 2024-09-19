package com.project.welspyserverv3.domain.email.client.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailCheckRequest {

    private String email;
    private String authNum;

}
