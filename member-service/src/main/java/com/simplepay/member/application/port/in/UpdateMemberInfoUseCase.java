package com.simplepay.member.application.port.in;

import com.simplepay.member.domain.Member;

public interface UpdateMemberInfoUseCase {
    Member updateMemberInfo(Long memberId, UpdateMemberInfoCommand command);
}
