package com.project.welspyserverv3.domain.bank.service;

import com.project.welspyserverv3.domain.bank.client.dto.Bank;
import com.project.welspyserverv3.domain.bank.client.dto.request.ChargeMoneyRequest;
import com.project.welspyserverv3.domain.bank.client.dto.request.SaveMoneyRequest;
import com.project.welspyserverv3.domain.bank.domain.entity.BankEntity;
import com.project.welspyserverv3.domain.bank.domain.entity.BankLogEntity;
import com.project.welspyserverv3.domain.bank.domain.enums.BankType;
import com.project.welspyserverv3.domain.bank.domain.repository.jpa.BankJpaRepository;
import com.project.welspyserverv3.domain.bank.domain.repository.jpa.BankLogJpaRepository;
import com.project.welspyserverv3.domain.bank.exception.BankErrorException;
import com.project.welspyserverv3.domain.bank.exception.BankNotFoundException;
import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
import com.project.welspyserverv3.domain.room.domain.mapper.MemberListMapper;
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
    private final BankLogJpaRepository bankLogJpaRepository;
    private final UserSecurity userSecurity;
    private final MemberListMapper memberListMapper;
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
        Bank bank = getBankByEmail();
        if (bank.getBalance() - request.getMoney() < 0){
            throw BankErrorException.EXCEPTION;
        }
        bank.setBalance(bank.getBalance() - request.getMoney());
        saveBank(bank);
        bankLogJpaRepository.save(BankLogEntity.builder()
                .accountNumber(bank.getAccountNumber())
                .money(request.getMoney())
                .bankType(BankType.SEND)
                .build());
        MemberList memberList = memberListJpaRepository
                .findByEmailAndRoomId(userSecurity.getUser().getEmail(), request.getRoomId())
                .map(memberListMapper::toMemberList)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);
        Long nowBalance = memberList.getBalance();
        memberList.setBalance(nowBalance + request.getMoney());
        memberListJpaRepository.save(MemberListEntity.builder()
                .idx(memberList.getIdx())
                .roomId(memberList.getRoomId())
                .email(memberList.getEmail())
                .balance(memberList.getBalance())
                .name(memberList.getName())
                .title(memberList.getTitle())
                .description(memberList.getDescription())
                .goalMoney(memberList.getGoalMoney())
                .productImageUrl(memberList.getProductImageUrl())
                .build());
        return bank.getBalance();
    }

    public Long chargeMoney(ChargeMoneyRequest request){
        Bank bank = getBankByEmail();
        bank.setBalance(bank.getBalance() + request.getMoney());
        saveBank(bank);
        return bank.getBalance();
    }

    public Bank getBankByEmail(){
       return bankJpaRepository
                .findByEmail(userSecurity.getUser().getEmail())
                .map(bankDto::toBank)
                .orElseThrow(()-> BankNotFoundException.EXCEPTION);
    }

    public void saveBank(Bank bank){
        bankJpaRepository.save(BankEntity.builder()
                .accountNumber(bank.getAccountNumber())
                .balance(bank.getBalance())
                .email(bank.getEmail())
                .build());
    }

}
