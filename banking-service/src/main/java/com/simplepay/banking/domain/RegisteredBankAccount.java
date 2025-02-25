package com.simplepay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RegisteredBankAccount {
    private final Long id;
    private final Long memberId;
    private final String bankName;
    private final String bankAccountNumber;
    private final boolean linkedStatusIsValid;

    public static RegisteredBankAccount generateRegisteredBankAccount(
        Long id,
        Long memberId,
        String bankName,
        String bankAccountNumber,
        boolean linkedStatusIsValid
    ) {
        return new RegisteredBankAccount(id, memberId, bankName, bankAccountNumber, linkedStatusIsValid);
    }
}
