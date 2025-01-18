package com.simplepay.member.application.port.in;

import com.simplepay.member.domain.Member;

public interface FindMemberUseCase {
    Member findMemberById(Long memberId);
    Member findMemberByEmail(String email);
}
