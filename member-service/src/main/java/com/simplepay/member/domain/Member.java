package com.simplepay.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    private final Long id;
    private final String name;
    private final String email;
    private final String address;
    private final boolean isValid;

    public static Member generateMember(
        Long id,
        String name,
        String email,
        String address,
        boolean isValid
    ) {
        return new Member(id, name, email, address, isValid);
    }
}
