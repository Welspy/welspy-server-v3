package com.project.welspyserverv3.domain.bank.client.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeMoneyRequest {

    @Positive
    private Long money;

}
