package com.simplepay.banking.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterBankAccountRequest(
    @NotNull Long memberId,
    @NotBlank String bankName,
    @NotBlank String bankAccountNumber,
    @NotNull Boolean linkedStatusIsValid
) {
}
