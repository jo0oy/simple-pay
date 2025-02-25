package com.simplepay.banking.adapter.out.external.bank;

import lombok.Builder;

@Builder
public record BankAccount(
    String bankName,
    String bankAccountNumber,
    boolean isValid
) {
}
