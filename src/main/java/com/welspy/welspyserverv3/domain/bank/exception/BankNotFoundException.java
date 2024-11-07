package com.welspy.welspyserverv3.domain.bank.exception;

import com.welspy.welspyserverv3.domain.bank.exception.error.BankError;
import com.welspy.welspyserverv3.global.exception.BusinessException;

public class BankNotFoundException extends BusinessException {

    public static final BankNotFoundException EXCEPTION = new BankNotFoundException();

    private BankNotFoundException(){
        super(BankError.BANK_NOT_FOUND);
    }

}
