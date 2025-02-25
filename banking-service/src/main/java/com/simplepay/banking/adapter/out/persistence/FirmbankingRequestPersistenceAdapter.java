package com.simplepay.banking.adapter.out.persistence;

import com.simplepay.banking.domain.FirmbankingRequest;
import com.simplepay.banking.domain.FirmbankingStatus;
import com.simplepay.banking.port.out.ModifyFirmbankingRequestPort;
import com.simplepay.banking.port.out.RequestFirmbankingPort;
import com.simplepay.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort, ModifyFirmbankingRequestPort {

    private final FirmbankingRequestSpringDataRepository firmbankingRequestRepository;
    private final FirmbankingRequestMapper firmbankingRequestMapper;

    @Override
    public FirmbankingRequest createFirmbankingRequest(
        String fromBankName,
        String fromBankAccountNumber,
        String toBankName,
        String toBankAccountNumber,
        int moneyAmount,
        FirmbankingStatus firmbankingStatus
    ) {

        var jpaEntity = new FirmbankingRequestJpaEntity(
            fromBankName, fromBankAccountNumber, toBankName, toBankAccountNumber, moneyAmount, firmbankingStatus);

        var savedJpaEntity = firmbankingRequestRepository.save(jpaEntity);

        return firmbankingRequestMapper.mapToDomainEntity(savedJpaEntity);
    }

    @Override
    public FirmbankingRequest modifyFirmbankingRequest(
        Long firmbankingRequestId,
        String fromBankName,
        String fromBankAccountNumber,
        String toBankName,
        String toBankAccountNumber,
        int moneyAmount,
        FirmbankingStatus firmbankingStatus
    ) {
        var targetEntity = firmbankingRequestRepository.findById(firmbankingRequestId)
            .orElseThrow(RuntimeException::new);

        // update info
        targetEntity.setFromBankName(fromBankName);
        targetEntity.setFromBankAccountNumber(fromBankAccountNumber);
        targetEntity.setToBankName(toBankName);
        targetEntity.setToBankAccountNumber(toBankAccountNumber);
        targetEntity.setMoneyAmount(moneyAmount);
        targetEntity.setFirmbankingStatus(firmbankingStatus);

        // save
        var updatedEntity = firmbankingRequestRepository.save(targetEntity);

        return firmbankingRequestMapper.mapToDomainEntity(updatedEntity);
    }
}
