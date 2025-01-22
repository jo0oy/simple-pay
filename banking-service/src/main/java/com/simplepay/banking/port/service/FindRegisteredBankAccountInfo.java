package com.simplepay.banking.port.service;

import com.simplepay.banking.domain.RegisteredBankAccount;
import com.simplepay.banking.port.in.FindRegisteredBankAccountInfoUseCase;
import com.simplepay.banking.port.out.FindRegisteredBankAccountInfoPort;
import com.simplepay.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
public class FindRegisteredBankAccountInfo implements FindRegisteredBankAccountInfoUseCase {

    private final FindRegisteredBankAccountInfoPort findRegisteredBankAccountInfoPort;

    @Transactional(readOnly = true)
    @Override
    public RegisteredBankAccount findRegisteredBankAccountById(Long registeredBankAccountId) {
        return findRegisteredBankAccountInfoPort.findById(registeredBankAccountId);
    }
}
