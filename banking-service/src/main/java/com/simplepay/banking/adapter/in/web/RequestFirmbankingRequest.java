package com.simplepay.banking.adapter.in.web;

public record RequestFirmbankingRequest(
    String fromBankName,
    String fromBankAccountNumber,
    String toBankName,
    String toBankAccountNumber,
    Integer moneyAmount
) {
}
