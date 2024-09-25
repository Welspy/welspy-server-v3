package com.project.welspyserverv3.domain.bank.service;

import com.project.welspyserverv3.domain.bank.client.dto.Bank;
import com.project.welspyserverv3.domain.bank.client.dto.request.SaveMoneyRequest;
import com.project.welspyserverv3.domain.bank.domain.entity.BankEntity;
import com.project.welspyserverv3.domain.bank.domain.repository.BankJpaRepository;
import com.project.welspyserverv3.domain.bank.exception.BankErrorException;
import com.project.welspyserverv3.domain.bank.exception.BankNotFoundException;
import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
import com.project.welspyserverv3.domain.room.domain.repository.jpa.MemberListJpaRepository;
import com.project.welspyserverv3.domain.user.exception.UserNotFoundException;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankJpaRepository bankJpaRepository;
    private final MemberListJpaRepository memberListJpaRepository;
    private final UserSecurity userSecurity;
    private final MemberList memberListDto;
    private final Bank bankDto;

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

    public Long savingMoney(SaveMoneyRequest request){
        String email = userSecurity.getUser().getEmail();

        Bank bank = bankJpaRepository
                .findByEmail(email)
                .map(bankDto::toBank)
                .orElseThrow(()-> BankNotFoundException.EXCEPTION);
        if (bank.getBalance() - request.getMoney() < 0){
            throw BankErrorException.EXCEPTION;
        }
        bank.setBalance(bank.getBalance() - request.getMoney());
        bankJpaRepository.save(BankEntity.builder()
                .accountNumber(bank.getAccountNumber())
                .email(bank.getEmail())
                .balance(bank.getBalance())
                .build());

        MemberList memberList = memberListJpaRepository
                .findByEmailAndRoomId(email, request.getMoney())
                .map(memberListDto::toMemberList)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);
        Long nowBalance = memberList.getBalance();
        memberList.setBalance(nowBalance + request.getMoney());
        memberListJpaRepository.save(MemberListEntity.builder()
                .idx(memberList.getIdx())
                .roomId(memberList.getRoomId())
                .email(memberList.getEmail())
                .balance(memberList.getBalance())
                .build());
        return bank.getBalance();
    }

}
