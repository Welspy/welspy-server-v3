package com.welspy.welspyserverv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WelspyServerV3Application {

    public static void main(String[] args) {
        SpringApplication.run(WelspyServerV3Application.class, args);
    }

}
