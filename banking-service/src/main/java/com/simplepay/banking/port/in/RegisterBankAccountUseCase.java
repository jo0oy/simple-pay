package com.simplepay.banking.port.in;

import com.simplepay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {
    RegisteredBankAccount registerBankAccount(RegisteredBankAccountCommand command);
}
