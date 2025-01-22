package com.simplepay.banking.adapter.in.web;

import com.simplepay.banking.port.service.FindRegisteredBankAccountInfo;
import com.simplepay.common.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/banking/accounts")
@RequiredArgsConstructor
@RestController
public class FindRegisteredBankAccountInfoApiController {

    private final FindRegisteredBankAccountInfo findRegisteredBankAccountInfo;
    private final RegisteredBankAccountDtoMapper registeredBankAccountDtoMapper;

    @GetMapping("/{bankAccountId}")
    public ResponseEntity<ApiResponse<RegisteredBankAccountInfoResponse>> findRegisteredBankAccountInfoById(
        @PathVariable("bankAccountId") Long bankAccountId
    ) {
        var registeredBankAccount = findRegisteredBankAccountInfo.findRegisteredBankAccountById(bankAccountId);
        var data = registeredBankAccountDtoMapper.mapToResponse(registeredBankAccount);

        return ResponseEntity
            .ok()
            .body(
                ApiResponse.OK(data)
            );
    }
}
