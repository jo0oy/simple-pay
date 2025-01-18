package com.simplepay.member.adapter.in.web;

import com.simplepay.common.api.ApiResponse;
import com.simplepay.member.application.port.in.RegisterMemberCommand;
import com.simplepay.member.application.service.RegisterMember;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/members")
@RequiredArgsConstructor
@RestController
public class RegisterMemberApiController {

    private final RegisterMember registerMember;

    @PostMapping("")
    public ResponseEntity<ApiResponse<Void>> registerMember(
        @Valid @RequestBody RegisterMemberRequest request
    ) {

        var command = RegisterMemberCommand.builder()
            .name(request.name())
            .email(request.email())
            .address(request.address())
            .isValid(request.isValid())
            .build();

        registerMember.registerMember(command);

        return ResponseEntity
            .ok()
            .body(ApiResponse.OK());
    }
}
