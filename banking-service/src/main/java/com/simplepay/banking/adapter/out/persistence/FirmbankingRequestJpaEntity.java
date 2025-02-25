package com.simplepay.banking.adapter.out.persistence;

import com.simplepay.banking.domain.FirmbankingStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "firmbanking_request")
@Entity
public class FirmbankingRequestJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter private String toBankName;
    @Setter private String toBankAccountNumber;
    @Setter private String fromBankName;
    @Setter private String fromBankAccountNumber;
    @Setter private int moneyAmount;
    @Setter private FirmbankingStatus firmbankingStatus;

    public FirmbankingRequestJpaEntity(
        String toBankName,
        String toBankAccountNumber,
        String fromBankName,
        String fromBankAccountNumber,
        int moneyAmount,
        FirmbankingStatus firmbankingStatus
    ) {
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.firmbankingStatus = firmbankingStatus;
    }
}
