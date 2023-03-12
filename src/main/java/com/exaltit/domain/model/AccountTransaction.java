package com.exaltit.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AccountTransaction {

    private Long transactionNo;

    private LocalDateTime dateTransaction;

    private BigDecimal amount;

    private Account account;

    private TransactionType transactionType;

    public AccountTransaction(BigDecimal amount, Account account, TransactionType transactionType) {
        this.amount = amount;
        this.account = account;
        this.transactionType = transactionType;
        this.dateTransaction = LocalDateTime.now();
    }

}
