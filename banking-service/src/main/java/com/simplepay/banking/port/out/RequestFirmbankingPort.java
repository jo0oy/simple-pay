package com.simplepay.banking.port.out;

import com.simplepay.banking.domain.FirmbankingRequest;
import com.simplepay.banking.domain.FirmbankingStatus;

public interface RequestFirmbankingPort {
    FirmbankingRequest createFirmbankingRequest(
        String fromBankName,
        String fromBankAccountNumber,
        String toBankName,
        String toBankAccountNumber,
        int moneyAmount,
        FirmbankingStatus firmbankingStatus
    );
}
