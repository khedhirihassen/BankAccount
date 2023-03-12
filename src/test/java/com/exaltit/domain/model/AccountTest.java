package com.exaltit.domain.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {


    @Test
    public void shouldDepositAmount(){

        Account account = new Account(1L, BigDecimal.valueOf(1000));

        account.deposit(BigDecimal.valueOf(2000));

        assertEquals(account.getBalance().longValue(),3000);

    }

    @Test
    public void canWithdrawAmountFromAccount(){

        Account account = new Account(1L, BigDecimal.valueOf(1000));

        assertTrue(account.withdraw(BigDecimal.valueOf(500)));

    }

    @Test
    public void canNotWithdrawAmountFromAccount(){

        Account account = new Account(1L, BigDecimal.valueOf(1000));

        assertFalse(account.withdraw(BigDecimal.valueOf(2000)));

    }

}
