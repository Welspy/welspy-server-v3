package com.welspy.welspyserverv3.domain.bank.client.dto;

import com.welspy.welspyserverv3.domain.bank.domain.enums.BankType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankLog {

    private Long idx;
    private String accountNumber;
    private Long money;
    private BankType bankType;
    private LocalDateTime logDateTime;

}