package com.simplepay.member.application.port.out;

public interface RegisterMemberPort {
    void createMember(
        String name,
        String email,
        String address,
        boolean isValid
    );
}
