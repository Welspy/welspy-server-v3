package com.project.welspyserverv3.global.security.jwt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.jwt")
public class JwtProperties {

    private String secretKey;
    private long expiration;
    private long refreshExpiration;

}