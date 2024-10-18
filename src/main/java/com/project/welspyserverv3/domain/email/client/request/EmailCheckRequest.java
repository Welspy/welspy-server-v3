package com.project.welspyserverv3.domain.email.client.request;

public record EmailCheckRequest(
        String email,
        String authNum
){}