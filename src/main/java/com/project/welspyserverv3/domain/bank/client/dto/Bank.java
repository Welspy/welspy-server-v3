package com.project.welspyserverv3.domain.bank.client.dto;

import com.project.welspyserverv3.domain.bank.domain.entity.BankEntity;
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
public class Bank {

    private String accountNumber;
    private Long balance;
    private String email;

    public Bank toBank(BankEntity bankEntity){
        return Bank.builder()
                .accountNumber(bankEntity.getAccountNumber())
                .balance(bankEntity.getBalance())
                .email(bankEntity.getEmail())
                .build();
    }

}
