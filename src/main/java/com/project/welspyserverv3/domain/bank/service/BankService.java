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
import com.project.welspyserverv3.domain.bank.service.response.MyBankResponse;
import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.domain.mapper.MemberListMapper;
import com.project.welspyserverv3.domain.room.domain.repository.jpa.MemberListJpaRepository;
import com.project.welspyserverv3.domain.room.service.RoomService;
import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.exception.UserNotFoundException;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService {

    private final RoomService roomService;
    private final MemberListJpaRepository memberListJpaRepository;
    private final BankJpaRepository bankJpaRepository;
    private final BankLogJpaRepository bankLogJpaRepository;
    private final UserSecurity userSecurity;
    private final MemberListMapper memberListMapper;
    private final Bank bankDto;
    private final MyBankResponse myBankResponse;

    public String createAccount(String email) {
        String accountNumber = UUID.randomUUID().toString();
        bankJpaRepository.save(BankEntity.builder()
                .accountNumber(accountNumber)
                .balance(0L)
                .email(email)
                .build()
        );
        return accountNumber;
    }

    public Long savingMoney(SaveMoneyRequest request) {
        Bank bank = getBankByEmail();
        MemberList memberList = memberListJpaRepository
                .findByEmailAndRoomId(userSecurity.getUser().getEmail(), request.getRoomId())
                .map(memberListMapper::toMemberList)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (bank.getBalance() - request.getMoney() < 0) {
            throw BankErrorException.EXCEPTION;
        }
        if (memberList.getGoalMoney() < request.getMoney()) {
            throw BankErrorException.EXCEPTION;
        }
        bank.setBalance(bank.getBalance() - request.getMoney());
        saveBank(bank);
        bankLogJpaRepository.save(BankLogEntity.builder()
                .accountNumber(bank.getAccountNumber())
                .money(request.getMoney())
                .bankType(BankType.SEND)
                .build());
        Long nowBalance = memberList.getBalance();
        memberList.setBalance(nowBalance + request.getMoney());
        roomService.saveMemberList(memberList);
        return bank.getBalance();
    }

    public Long chargeMoney(ChargeMoneyRequest request) {
        Bank bank = getBankByEmail();
        bank.setBalance(bank.getBalance() + request.getMoney());
        saveBank(bank);
        return bank.getBalance();
    }

    public MyBankResponse myBank() {
        Bank bank = getBankByEmail();
        User user = userSecurity.getUser();
        return myBankResponse.toMyBankResponse(bank, user);
    }

    public Bank getBankByEmail() {
        return bankJpaRepository
                .findByEmail(userSecurity.getUser().getEmail())
                .map(bankDto::toBank)
                .orElseThrow(() -> BankNotFoundException.EXCEPTION);
    }

    public void saveBank(Bank bank) {
        bankJpaRepository.save(BankEntity.builder()
                .accountNumber(bank.getAccountNumber())
                .balance(bank.getBalance())
                .email(bank.getEmail())
                .build());
    }

}
