package com.project.welspyserverv3.domain.bank.service;

import com.project.welspyserverv3.domain.bank.domain.entity.BankEntity;
import com.project.welspyserverv3.domain.bank.domain.repository.BankJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankJpaRepository bankJpaRepository;

    public String createAccount(String email){
        String accountNumber = UUID.randomUUID().toString();
        bankJpaRepository.save(BankEntity.builder()
                .accountNumber(accountNumber)
                .balance(0L)
                .email(email)
                .build()
        );
        return accountNumber;
    }

    public

}
