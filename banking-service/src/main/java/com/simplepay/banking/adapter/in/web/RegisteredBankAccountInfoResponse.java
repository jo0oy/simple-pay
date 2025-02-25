package com.simplepay.banking.adapter.in.web;

import lombok.Builder;

@Builder
public record RegisteredBankAccountInfoResponse(
    Long registeredBankAccountId,
    Long memberId,
    String bankName,
    String bankAccountNumber,
    Boolean linkedStatusIsValid
) {
}
