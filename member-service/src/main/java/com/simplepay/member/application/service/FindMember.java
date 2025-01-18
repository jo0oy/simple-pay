package com.simplepay.member.application.service;

import com.simplepay.common.annotation.UseCase;
import com.simplepay.member.application.port.in.FindMemberUseCase;
import com.simplepay.member.application.port.out.FindMemberPort;
import com.simplepay.member.domain.Member;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class FindMember implements FindMemberUseCase {

    private final FindMemberPort findMemberPort;

    @Override
    public Member findMemberById(Long memberId) {
        return findMemberPort.findById(memberId);
    }

    @Override
    public Member findMemberByEmail(String email) {
        return findMemberPort.findByEmail(email);
    }
}
