package com.simplepay.banking.adapter.out.persistence;

import com.simplepay.banking.domain.RegisteredBankAccount;
import com.simplepay.banking.port.out.FindRegisteredBankAccountInfoPort;
import com.simplepay.banking.port.out.RegisterBankAccountPort;
import com.simplepay.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class RegisteredBankAccountPersistenceAdapter
    implements RegisterBankAccountPort, FindRegisteredBankAccountInfoPort {

    private final RegisteredBankAccountSpringDataRepository registeredBankAccountRepository;
    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    @Override
    public RegisteredBankAccount registerBankAccount(
        Long memberId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid
    ) {
        var registeredBankAccountJpaEntity = new RegisteredBankAccountJpaEntity(memberId, bankName, bankAccountNumber, linkedStatusIsValid);
        var registeredBankAccount = registeredBankAccountRepository.save(registeredBankAccountJpaEntity);

        return registeredBankAccountMapper.mapToDomainEntity(registeredBankAccount);
    }

    @Override
    public RegisteredBankAccount findById(Long bankAccountId) {
        var registeredBankAccountJpaEntity = registeredBankAccountRepository.findById(bankAccountId)
            .orElseThrow(RuntimeException::new);

        return registeredBankAccountMapper.mapToDomainEntity(registeredBankAccountJpaEntity);
    }
}
