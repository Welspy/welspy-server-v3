package com.project.welspyserverv3.domain.bank.exception;

import com.project.welspyserverv3.domain.bank.exception.error.BankError;
import com.project.welspyserverv3.global.exception.BusinessException;

public class BankErrorException extends BusinessException {

    public static final BankErrorException EXCEPTION = new BankErrorException();

    private BankErrorException(){
        super(BankError.BANK_ERROR);
    }

}
