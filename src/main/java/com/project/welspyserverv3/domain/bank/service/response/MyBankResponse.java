package com.project.welspyserverv3.domain.bank.service.response;

import com.project.welspyserverv3.domain.bank.client.dto.Bank;
import com.project.welspyserverv3.domain.bank.domain.entity.BankEntity;
import com.project.welspyserverv3.domain.user.client.dto.User;
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
public class MyBankResponse {

    private String accountNumber;
    private Long balance;
    private String email;
    private String name;

    public MyBankResponse toMyBankResponse(Bank bank, User user) {
        return MyBankResponse.builder()
                .accountNumber(bank.getAccountNumber())
                .balance(bank.getBalance())
                .email(bank.getEmail())
                .name(user.getName())
                .build();
    }

}
