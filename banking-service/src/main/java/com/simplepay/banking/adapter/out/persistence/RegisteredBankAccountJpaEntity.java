package com.simplepay.banking.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "registered_bank_account")
public class RegisteredBankAccountJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private String bankName;
    private String bankAccountNumber;
    @Setter private boolean linkedStatusIsValid;

    public RegisteredBankAccountJpaEntity(
        Long memberId,
        String bankName,
        String bankAccountNumber,
        boolean linkedStatusIsValid
    ) {
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }
}
