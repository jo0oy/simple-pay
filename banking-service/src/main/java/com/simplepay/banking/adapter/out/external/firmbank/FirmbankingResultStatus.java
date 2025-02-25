package com.simplepay.banking.adapter.out.external.firmbank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FirmbankingResultStatus {
    SUCCESS("성공"),
    FAIL("실패");

    private final String description;
}
