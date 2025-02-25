package com.simplepay.banking.adapter.in.web;

import lombok.Builder;

@Builder
public record FirmbankingRequestResultResponse(
    String fromBankName,
    String fromBankAccountNumber,
    String toBankName,
    String toBankAccountNumber,
    Integer moneyAmount,
    String firmbankingStatus
) {
}
