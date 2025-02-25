package com.simplepay.banking.adapter.out.external.bank;

import lombok.Builder;

@Builder
public record GetBankAccountInfoRequest(
    String bankName,
    String bankAccountNumber
) {
}
