package com.simplepay.banking.adapter.out.external.firmbank;

import com.simplepay.banking.port.out.RequestExternalFirmbankingPort;
import com.simplepay.common.annotation.ExternalSystemAdapter;

@ExternalSystemAdapter
public class FrimbankingExternalAdapter implements RequestExternalFirmbankingPort {

    @Override
    public FrimbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request) {

        // 실제로 외부 은행에 http 통신을 통해서 펌뱅킹 요청

        // 펌뱅킹 요청 결과
        // 외부 은행의 실제 결과를 -> 심플 페이의 FirmbankingResult 파싱

        return new FrimbankingResult(FirmbankingResultStatus.SUCCESS);
    }
}
