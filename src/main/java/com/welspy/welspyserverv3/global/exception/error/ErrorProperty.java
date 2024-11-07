package com.welspy.welspyserverv3.global.exception.error;

import org.springframework.http.HttpStatus;

public interface ErrorProperty {

    HttpStatus getStatus();
    String getMessage();

}
