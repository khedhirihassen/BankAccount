package com.exaltit.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Account {

    private Long accountNo;

    private BigDecimal balance;

    private List<AccountTransaction> accountTransactions;

    public Account(Long accountNo, BigDecimal balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void deposit(BigDecimal depositAmount){
        this.balance = this.balance.add(depositAmount);
    }

    public boolean withdraw(BigDecimal withdrawalAmount) {
        if (this.balance.compareTo(withdrawalAmount) < 0) {
            return false;
        }
        this.balance = balance.subtract(withdrawalAmount);
        return true;
    }

}
