package com.project.welspyserverv3.domain.bank.client.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveMoneyRequest {

    private Long roomId;
    @Positive
    private Long money;

}
