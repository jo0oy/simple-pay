package com.simplepay.member.application.port.out;

import com.simplepay.member.domain.Member;

public interface UpdateMemberPort {
    Member updateMember(
        Long memberId,
        String name,
        String email,
        String address,
        boolean isValid
    );
}
