package com.simplepay.banking.adapter.in.web;

import com.simplepay.banking.domain.FirmbankingRequest;
import com.simplepay.banking.port.in.RequestFirmbankingCommand;
import org.springframework.stereotype.Component;

@Component
public class RequestFirmbankingDtoMapper {

    public RequestFirmbankingCommand mapToCommand(RequestFirmbankingRequest request) {
        return RequestFirmbankingCommand.builder()
            .fromBankName(request.fromBankName())
            .fromBankAccountNumber(request.fromBankAccountNumber())
            .toBankName(request.toBankName())
            .toBankAccountNumber(request.toBankAccountNumber())
            .moneyAmount(request.moneyAmount())
            .build();
    }

    public FirmbankingRequestResultResponse mapToResponse(FirmbankingRequest domainEntity) {
        return FirmbankingRequestResultResponse.builder()
            .fromBankName(domainEntity.getFromBankName())
            .fromBankAccountNumber(domainEntity.getFromBankAccountNumber())
            .toBankName(domainEntity.getToBankName())
            .toBankAccountNumber(domainEntity.getToBankAccountNumber())
            .moneyAmount(domainEntity.getMoneyAmount())
            .firmbankingStatus(domainEntity.getFirmbankingStatus().getDescription())
            .build();
    }
}
