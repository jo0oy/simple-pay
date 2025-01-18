package com.simplepay.member.adapter.in.web;

import com.simplepay.common.api.ApiResponse;
import com.simplepay.member.application.service.FindMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/members")
@RequiredArgsConstructor
@RestController
public class FindMemberApiController {

    private final FindMember findMember;

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponse>> findMemberById(
        @PathVariable("memberId") Long memberId
    ) {
        var member = findMember.findMemberById(memberId);
        var data = MemberResponse.builder()
            .memberId(member.getId())
            .name(member.getName())
            .email(member.getEmail())
            .address(member.getAddress())
            .isValid(member.isValid())
            .build();

        return ResponseEntity
            .ok()
            .body(ApiResponse.OK(data));
    }

    @GetMapping("/email")
    public ResponseEntity<ApiResponse<MemberResponse>> findByEmail(
        @RequestBody FindMemberByEmailRequest request
    ) {
        var member = findMember.findMemberByEmail(request.email());
        var responseData = MemberResponse.builder()
            .memberId(member.getId())
            .name(member.getName())
            .email(member.getEmail())
            .address(member.getAddress())
            .isValid(member.isValid())
            .build();

        return ResponseEntity
            .ok()
            .body(ApiResponse.OK(responseData));
    }
}
