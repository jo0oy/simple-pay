package com.simplepay.banking.adapter.out.persistence;

import com.simplepay.banking.domain.FirmbankingRequest;
import org.springframework.stereotype.Component;

@Component
public class FirmbankingRequestMapper {

    public FirmbankingRequest mapToDomainEntity(FirmbankingRequestJpaEntity entity) {
        return FirmbankingRequest.generateFirmbankingRequest(
            entity.getId(),
            entity.getFromBankName(),
            entity.getFromBankAccountNumber(),
            entity.getToBankName(),
            entity.getToBankAccountNumber(),
            entity.getMoneyAmount(),
            entity.getFirmbankingStatus()
        );
    }
}
