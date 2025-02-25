package com.simplepay.banking.port.in;

import com.simplepay.banking.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
