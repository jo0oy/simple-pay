package com.simplepay.banking.port.out;

import com.simplepay.banking.domain.RegisteredBankAccount;

public interface FindRegisteredBankAccountInfoPort {
    RegisteredBankAccount findById(Long bankAccountId);
}
