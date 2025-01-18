package com.simplepay.member.application.port.in;

public record UpdateMemberInfoCommand(
    String name,
    String email,
    String address,
    boolean isValid
) {
}
