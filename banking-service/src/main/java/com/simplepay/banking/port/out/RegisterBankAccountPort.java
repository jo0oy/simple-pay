package com.simplepay.banking.port.out;

import com.simplepay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {
    RegisteredBankAccount registerBankAccount(
        Long memberId,
        String bankName,
        String bankAccountNumber,
        boolean linkedStatusIsValid
    );
}
