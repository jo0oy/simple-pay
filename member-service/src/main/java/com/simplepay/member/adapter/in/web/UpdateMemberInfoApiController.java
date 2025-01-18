package com.simplepay.member.adapter.in.web;

import com.simplepay.common.api.ApiResponse;
import com.simplepay.member.application.port.in.UpdateMemberInfoCommand;
import com.simplepay.member.application.service.UpdateMemberInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/members")
@RequiredArgsConstructor
@RestController
public class UpdateMemberInfoApiController {

    private final UpdateMemberInfo updateMemberInfo;

    @PutMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponse>> updateMemberInfo(
        @PathVariable("memberId") Long memberId,
        @Valid @RequestBody UpdateMemberInfoRequest request
    ) {
        var command = new UpdateMemberInfoCommand(
            request.name(),
            request.email(),
            request.address(),
            request.isValid()
        );

        var member = updateMemberInfo.updateMemberInfo(memberId, command);

        var responseData = MemberResponse.builder()
            .memberId(member.getId())
            .name(member.getName())
            .email(member.getEmail())
            .address(member.getAddress())
            .isValid(member.isValid())
            .build();

        return ResponseEntity
            .ok()
            .body(
                ApiResponse.OK(responseData)
            );
    }
}
