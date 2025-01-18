package com.simplepay.member.application.service;

import com.simplepay.common.annotation.UseCase;
import com.simplepay.member.application.port.in.RegisterMemberCommand;
import com.simplepay.member.application.port.in.RegisterMemberUseCase;
import com.simplepay.member.application.port.out.RegisterMemberPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class RegisterMember implements RegisterMemberUseCase {

    private final RegisterMemberPort registerMemberPort;

    @Override
    public void registerMember(RegisterMemberCommand command) {
        registerMemberPort.createMember(
            command.name(),
            command.email(),
            command.address(),
            command.isValid()
        );
    }
}
