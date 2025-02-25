package com.simplepay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FirmbankingRequest {

    private final Long id;
    private final String fromBankName;
    private final String fromBankAccountNumber;
    private final String toBankName;
    private final String toBankAccountNumber;
    private final int moneyAmount;
    private final FirmbankingStatus firmbankingStatus;

    public static FirmbankingRequest generateFirmbankingRequest(
        Long id,
        String fromBankName,
        String fromBankAccountNumber,
        String toBankName,
        String toBankAccountNumber,
        int moneyAmount,
        FirmbankingStatus firmbankingStatus
    ) {
        return new FirmbankingRequest(
            id,
            fromBankName,
            fromBankAccountNumber,
            toBankName,
            toBankAccountNumber,
            moneyAmount,
            firmbankingStatus
        );
    }
}
