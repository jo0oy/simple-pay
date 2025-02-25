package com.simplepay.banking.adapter.out.external.firmbank;

public record ExternalFirmbankingRequest(
    String fromBankName,
    String fromBankAccountNumber,
    String toBankName,
    String toBankAccountNumber,
    int moneyAmount
) {
}
