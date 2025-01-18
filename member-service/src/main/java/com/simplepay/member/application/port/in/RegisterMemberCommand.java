package com.simplepay.member.application.port.in;

import lombok.Builder;

@Builder
public record RegisterMemberCommand(
    String name,
    String email,
    String address,
    boolean isValid
) {
}
