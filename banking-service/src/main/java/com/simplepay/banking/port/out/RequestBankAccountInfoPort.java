package com.simplepay.banking.port.out;

import com.simplepay.banking.adapter.out.external.bank.BankAccount;
import com.simplepay.banking.adapter.out.external.bank.GetBankAccountInfoRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountInfoRequest request);
}
