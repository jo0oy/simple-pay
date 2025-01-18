package com.simplepay.member.adapter.in.web;

import lombok.Builder;

@Builder
public record MemberResponse(
    Long memberId,
    String name,
    String email,
    String address,
    Boolean isValid
) {
}
