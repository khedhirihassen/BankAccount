package com.exaltit.domain.service;

import com.exaltit.domain.exception.AccountNotFoundException;
import com.exaltit.domain.model.Account;
import com.exaltit.domain.model.AccountTransaction;
import com.exaltit.domain.model.TransactionType;
import com.exaltit.domain.port.input.Deposit;
import com.exaltit.domain.port.input.Withdraw;
import com.exaltit.domain.port.output.LoadAccount;
import com.exaltit.domain.port.output.SaveAccount;
import com.exaltit.domain.port.output.SaveTransaction;

import java.math.BigDecimal;

public class AccountService implements Deposit, Withdraw {

    private final SaveAccount saveAccount;
    private final LoadAccount loadAccount;

    private final SaveTransaction saveTransaction;

    public AccountService(SaveAccount saveAccount, LoadAccount loadAccount, SaveTransaction saveTransaction) {
        this.saveAccount = saveAccount;
        this.loadAccount = loadAccount;
        this.saveTransaction = saveTransaction;
    }

    @Override
    public void deposit(Long accountNo, BigDecimal depositAmount) {

        Account account = getAccount(accountNo);
        account.deposit(depositAmount);
        saveAccount.save(account);
        saveTransaction.saveTransaction(new AccountTransaction(depositAmount,account, TransactionType.DEPOSIT));
    }

    @Override
    public void withdraw(Long accountNo, BigDecimal withdrawalAmount) {

        Account account = getAccount(accountNo);
        boolean enableToBeWithdrawn = account.withdraw(withdrawalAmount);

        if (enableToBeWithdrawn) {
            saveAccount.save(account);
            saveTransaction.saveTransaction(new AccountTransaction(withdrawalAmount,account, TransactionType.WITHDRAW));
        }
    }

    private Account getAccount(Long accountNo){
        return loadAccount.load(accountNo).orElseThrow(()->new AccountNotFoundException("Account Not Found"));
    }

}
