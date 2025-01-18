package com.simplepay.member.application.port.out;

import com.simplepay.member.domain.Member;

public interface FindMemberPort {
    Member findById(Long id);
    Member findByEmail(String email);
}
