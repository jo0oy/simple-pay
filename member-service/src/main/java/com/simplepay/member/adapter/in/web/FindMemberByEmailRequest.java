package com.simplepay.member.adapter.in.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FindMemberByEmailRequest(
    @NotBlank @Email String email
) {
}
