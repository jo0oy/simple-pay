package com.simplepay.banking.port.service;

import com.simplepay.banking.adapter.out.external.bank.GetBankAccountInfoRequest;
import com.simplepay.banking.domain.RegisteredBankAccount;
import com.simplepay.banking.port.in.RegisterBankAccountUseCase;
import com.simplepay.banking.port.in.RegisteredBankAccountCommand;
import com.simplepay.banking.port.out.RegisterBankAccountPort;
import com.simplepay.banking.port.out.RequestBankAccountInfoPort;
import com.simplepay.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Transactional
    @Override
    public RegisteredBankAccount registerBankAccount(RegisteredBankAccountCommand command) {

        // 은행 계좌를 등록하는 서비스 (비즈니스 로직)

        // 멤버 확인

        // 1. 외부 실제 은행에 등록이 가능한 계좌인지 (정상인지) 확인한다.
        // Biz Logic --> External System
        // Port -> Adapter -> External System

        // 실제 외부의 은행 계좌 정보를 Get
        var bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(
            GetBankAccountInfoRequest.builder()
                .bankName(command.bankName())
                .bankAccountNumber(command.bankAccountNumber())
                .build()
        );

        var accountIsValid = bankAccountInfo.isValid();

        // 2. 등록이 가능한 계좌라면, 등록한다. 성공하며 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록 가능하지 않은 계좌라면, 에러 리턴

        if (accountIsValid) {
            return registerBankAccountPort.registerBankAccount(
                command.memberId(),
                bankAccountInfo.bankName(),
                bankAccountInfo.bankAccountNumber(),
                accountIsValid
            );
        } else {
            throw new RuntimeException("Bank account is not valid");
        }

    }
}
