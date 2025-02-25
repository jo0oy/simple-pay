package com.simplepay.banking.adapter.out.external.bank;

import com.simplepay.banking.port.out.RequestBankAccountInfoPort;
import com.simplepay.common.annotation.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountExternalAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountInfoRequest request) {

        // 실제로 외부 은행에 http 통해서
        // 실제 은행 계좌 정보를 가져오고

        // 실제 은행 계좌 정보 --> BankAccount

        return BankAccount.builder()
            .bankName(request.bankName())
            .bankAccountNumber(request.bankAccountNumber())
            .isValid(true)
            .build();
    }
}
