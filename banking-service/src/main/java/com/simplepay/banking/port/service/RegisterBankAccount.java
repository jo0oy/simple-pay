package com.simplepay.banking.port.service;

import com.simplepay.banking.domain.RegisteredBankAccount;
import com.simplepay.banking.port.in.RegisterBankAccountUseCase;
import com.simplepay.banking.port.in.RegisteredBankAccountCommand;
import com.simplepay.banking.port.out.RegisterBankAccountPort;
import com.simplepay.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class RegisterBankAccount implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisteredBankAccountCommand command) {

        return registerBankAccountPort.registerBankAccount(
            command.memberId(),
            command.bankName(),
            command.bankAccountNumber(),
            command.linkedStatusIsValid()
        );
    }
}
