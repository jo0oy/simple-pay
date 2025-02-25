package com.simplepay.banking.port.service;

import com.simplepay.banking.adapter.out.external.firmbank.ExternalFirmbankingRequest;
import com.simplepay.banking.adapter.out.external.firmbank.FirmbankingResultStatus;
import com.simplepay.banking.domain.FirmbankingRequest;
import com.simplepay.banking.domain.FirmbankingStatus;
import com.simplepay.banking.port.in.RequestFirmbankingCommand;
import com.simplepay.banking.port.in.RequestFirmbankingUseCase;
import com.simplepay.banking.port.out.ModifyFirmbankingRequestPort;
import com.simplepay.banking.port.out.RequestExternalFirmbankingPort;
import com.simplepay.banking.port.out.RequestFirmbankingPort;
import com.simplepay.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

    private final RequestFirmbankingPort requestFirmbankingPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;
    private final ModifyFirmbankingRequestPort modifyFirmbankingRequestPort;

    @Transactional
    @Override
    public FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command) {
        // Business Logic
        // a --> b 계좌

        // 1. 요청에 대해 정보를 먼저 write. "요청" 상태로
        var firmbankingRequest = requestFirmbankingPort.createFirmbankingRequest(
            command.fromBankName(),
            command.fromBankAccountNumber(),
            command.toBankName(),
            command.toBankAccountNumber(),
            command.moneyAmount(),
            FirmbankingStatus.REQUEST
        );

        // 2. 외부 은행에 펌뱅킹 요청
        var firmbankingResult = requestExternalFirmbankingPort.requestExternalFirmbanking(
            new ExternalFirmbankingRequest(
                command.fromBankName(),
                command.fromBankAccountNumber(),
                command.toBankName(),
                command.toBankAccountNumber(),
                command.moneyAmount()
            )
        );

        // 3. 결과에 따라서 1번에 작성했던 FirmbankingRequest 정보 업데이트
        FirmbankingStatus updateStatus;
        if (firmbankingResult.firmbankingResultStatus().equals(FirmbankingResultStatus.SUCCESS)) {

            // 외부 펌뱅킹 요청 성공
            // 펌뱅킹 상태 변경 -> "완료" COMPLETE
            updateStatus = FirmbankingStatus.COMPLETE;
        } else {

            // 외부 펌뱅킹 요청 실패
            // 펌뱅킹 상태 변경 -> "실패" (FAIL)
            updateStatus = FirmbankingStatus.FAIL;
        }

        // 4. 최종 결과 리턴
        return modifyFirmbankingRequestPort.modifyFirmbankingRequest(
            firmbankingRequest.getId(),
            firmbankingRequest.getFromBankName(),
            firmbankingRequest.getFromBankAccountNumber(),
            firmbankingRequest.getToBankName(),
            firmbankingRequest.getToBankAccountNumber(),
            firmbankingRequest.getMoneyAmount(),
            updateStatus
        );
    }
}
