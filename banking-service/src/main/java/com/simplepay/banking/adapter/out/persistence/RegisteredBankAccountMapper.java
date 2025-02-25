package com.simplepay.banking.adapter.out.persistence;

import com.simplepay.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {
    RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity entity) {
        return RegisteredBankAccount.generateRegisteredBankAccount(
            entity.getId(),
            entity.getMemberId(),
            entity.getBankName(),
            entity.getBankAccountNumber(),
            entity.isLinkedStatusIsValid()
        );
    }
}
