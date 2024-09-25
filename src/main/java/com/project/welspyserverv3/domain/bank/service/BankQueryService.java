package com.project.welspyserverv3.domain.bank.service;

import com.project.welspyserverv3.domain.bank.client.dto.Bank;
import com.project.welspyserverv3.domain.bank.client.dto.BankLog;
import com.project.welspyserverv3.domain.bank.domain.repository.query.BankLogQueryRepository;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankQueryService {

    private final BankService bankService;
    private final BankLogQueryRepository bankLogQueryRepository;

    public List<BankLog> getAllLog(PageRequest request) {
        return bankLogQueryRepository.getAllLog(request);
    }

    public List<BankLog> getMyLog(PageRequest request) {
        Bank bank = bankService.getBankByEmail();
        return bankLogQueryRepository.getMyLog(request, bank.getAccountNumber());
    }

}
