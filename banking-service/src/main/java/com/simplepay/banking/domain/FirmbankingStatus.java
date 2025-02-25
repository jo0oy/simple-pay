package com.simplepay.banking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FirmbankingStatus {
    REQUEST("요청"),
    COMPLETE("완료"),
    FAIL("실패");

    private final String description;
}
