package com.simplepay.member.application.service;

import com.simplepay.common.annotation.UseCase;
import com.simplepay.member.application.port.in.UpdateMemberInfoCommand;
import com.simplepay.member.application.port.in.UpdateMemberInfoUseCase;
import com.simplepay.member.application.port.out.UpdateMemberPort;
import com.simplepay.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
public class UpdateMemberInfo implements UpdateMemberInfoUseCase {

    private final UpdateMemberPort updateMemberPort;


    @Transactional
    @Override
    public Member updateMemberInfo(Long memberId, UpdateMemberInfoCommand command) {
        var updatedMember = updateMemberPort.updateMember(
            memberId, command.name(), command.email(), command.address(), command.isValid()
        );

        return updatedMember;
    }
}
