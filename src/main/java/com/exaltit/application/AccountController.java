package com.exaltit.application;

import com.exaltit.domain.exception.AccountNotFoundException;
import com.exaltit.domain.model.Account;
import com.exaltit.domain.port.input.Deposit;
import com.exaltit.domain.port.input.Withdraw;
import com.exaltit.domain.port.output.LoadAccount;
import com.exaltit.domain.port.output.SaveAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private SaveAccount saveAccount;

    @Autowired
    private LoadAccount loadAccount;

    @Autowired
    private Deposit deposit;

    @Autowired
    private Withdraw withdraw;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){

        saveAccount.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Account getById(@PathVariable("id") Long id){
        return loadAccount.load(id)
                .orElseThrow(()-> new AccountNotFoundException("Cannot get Account with accountNo " + id));
    }

    @PostMapping(value = "/{accountNo}/deposit/{depositAmount}")
    void deposit(@PathVariable final Long accountNo, @PathVariable final BigDecimal depositAmount) {
        deposit.deposit(accountNo, depositAmount);
    }

    @PostMapping(value = "/{accountNo}/withdraw/{withdrawalAmount}")
    void withdraw(@PathVariable final Long accountNo, @PathVariable final BigDecimal withdrawalAmount) {
        withdraw.withdraw(accountNo, withdrawalAmount);
    }

}
