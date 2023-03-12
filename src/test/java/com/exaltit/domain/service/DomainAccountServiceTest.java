package com.exaltit.domain.service;

import com.exaltit.domain.exception.AccountNotFoundException;
import com.exaltit.domain.model.Account;
import com.exaltit.domain.port.output.LoadAccount;
import com.exaltit.domain.port.output.SaveAccount;
import com.exaltit.domain.port.output.SaveTransaction;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class DomainAccountServiceTest {

    private SaveAccount saveAccount;
    private LoadAccount loadAccount;

    private SaveTransaction saveTransaction;
    private AccountService accountService;

    @Before
    public void setUp() {
        saveAccount = mock(SaveAccount.class);
        loadAccount = mock(LoadAccount.class);
        saveTransaction = mock(SaveTransaction.class);
        accountService = new AccountService(saveAccount,loadAccount, saveTransaction);
    }
    @Test(expected = AccountNotFoundException.class)
    public void shouldDepositAmount_thenSaveAccount() {

        Account account = new Account(1L, BigDecimal.valueOf(1000));
        accountService.deposit(account.getAccountNo(),BigDecimal.valueOf(200));

        verify(saveAccount).save(any(Account.class));

        assertEquals(account.getBalance().longValue(),1200);
    }

    @Test(expected = AccountNotFoundException.class)
    public void shouldWithdrawAmount_thenSaveAccount() {

        Account account = new Account(1L, BigDecimal.valueOf(1200));
        accountService.withdraw(account.getAccountNo(),BigDecimal.valueOf(200));

        verify(saveAccount).save(any(Account.class));

        assertEquals(account.getBalance().longValue(),1000);
    }

}
