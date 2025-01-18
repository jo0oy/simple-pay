package com.simplepay.member.adapter.in.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterMemberRequest(
    @NotBlank String name,
    @NotBlank @Email String email,
    @NotBlank String address,
    @NotNull Boolean isValid
) {
}
