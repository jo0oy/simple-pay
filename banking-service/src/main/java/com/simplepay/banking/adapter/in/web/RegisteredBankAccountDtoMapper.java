package com.simplepay.banking.adapter.in.web;

import com.simplepay.banking.domain.RegisteredBankAccount;
import com.simplepay.banking.port.in.RegisteredBankAccountCommand;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountDtoMapper {

    public RegisteredBankAccountCommand mapToCommand(RegisteredBankAccountRequest request) {
        return new RegisteredBankAccountCommand(
            request.memberId(),
            request.bankName(),
            request.bankAccountNumber(),
            request.linkedStatusIsValid()
        );
    }

    public RegisteredBankAccountInfoResponse mapToResponse(RegisteredBankAccount domainEntity) {
        return new RegisteredBankAccountInfoResponse(
            domainEntity.getId(),
            domainEntity.getMemberId(),
            domainEntity.getBankName(),
            domainEntity.getBankAccountNumber(),
            domainEntity.isLinkedStatusIsValid()
        );
    }

}
