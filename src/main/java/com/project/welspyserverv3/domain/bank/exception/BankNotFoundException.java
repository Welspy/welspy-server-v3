package com.project.welspyserverv3.domain.bank.exception;

import com.project.welspyserverv3.domain.bank.exception.error.BankError;
import com.project.welspyserverv3.global.exception.BusinessException;

public class BankNotFoundException extends BusinessException {

    public static final BankNotFoundException EXCEPTION = new BankNotFoundException();

    private BankNotFoundException(){
        super(BankError.BANK_NOT_FOUND);
    }

}
