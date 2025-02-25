package com.simplepay.banking.port.out;

import com.simplepay.banking.adapter.out.external.firmbank.ExternalFirmbankingRequest;
import com.simplepay.banking.adapter.out.external.firmbank.FrimbankingResult;

public interface RequestExternalFirmbankingPort {
    FrimbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
