package com.simplepay.banking.adapter.in.web;

import com.simplepay.banking.port.service.RegisterBankAccountService;
import com.simplepay.common.api.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/banking/accounts")
@RequiredArgsConstructor
@RestController
public class RegisterBankAccountApiController {

    private final RegisterBankAccountService registerBankAccountService;
    private final RegisterBankAccountDtoMapper registerBankAccountDtoMapper;

    @PostMapping("")
    public ResponseEntity<ApiResponse<RegisteredBankAccountInfoResponse>> registerBankAccount(
        @Valid @RequestBody RegisterBankAccountRequest request
    ) {
        var command = registerBankAccountDtoMapper.mapToCommand(request);
        var registeredBankAccount = registerBankAccountService.registerBankAccount(command);
        var data = registerBankAccountDtoMapper.mapToResponse(registeredBankAccount);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                ApiResponse.OK(data)
            );
    }
}
