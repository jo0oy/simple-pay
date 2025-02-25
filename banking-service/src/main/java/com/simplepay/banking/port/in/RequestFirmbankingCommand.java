package com.simplepay.banking.port.in;

import lombok.Builder;

@Builder
public record RequestFirmbankingCommand(
    String fromBankName,
    String fromBankAccountNumber,
    String toBankName,
    String toBankAccountNumber,
    Integer moneyAmount
) {
}
