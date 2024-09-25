package com.project.welspyserverv3.domain.bank.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveMoneyRequest {

    private Long roomId;
    private Long money;

}
