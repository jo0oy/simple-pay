package com.simplepay.banking.port.in;

import com.simplepay.banking.domain.RegisteredBankAccount;

public interface FindRegisteredBankAccountInfoUseCase {
    RegisteredBankAccount findRegisteredBankAccountById(Long registeredBankAccountId);
}
