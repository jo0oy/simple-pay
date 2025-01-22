package com.simplepay.banking.port.in;

public record RegisteredBankAccountCommand(
    Long memberId,
    String bankName,
    String bankAccountNumber,
    Boolean linkedStatusIsValid
) {
}
