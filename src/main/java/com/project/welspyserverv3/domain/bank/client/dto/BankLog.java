package com.project.welspyserverv3.domain.bank.client.dto;

import com.project.welspyserverv3.domain.bank.domain.entity.BankLogEntity;
import com.project.welspyserverv3.domain.bank.domain.enums.BankType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class BankLog {

    private Long idx;
    private String accountNumber;
    private Long money;
    private BankType bankType;

    public BankLog toBankLog(BankLogEntity bankLogEntity) {
        return BankLog.builder()
                .idx(bankLogEntity.getIdx())
                .accountNumber(bankLogEntity.getAccountNumber())
                .money(bankLogEntity.getMoney())
                .bankType(bankLogEntity.getBankType())
                .build();
    }

}
