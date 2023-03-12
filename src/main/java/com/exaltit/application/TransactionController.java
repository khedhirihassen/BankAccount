package com.exaltit.application;

import com.exaltit.domain.model.AccountTransaction;
import com.exaltit.domain.port.output.LoadTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private LoadTransaction loadTransaction;

    @GetMapping("{accountNo}")
    public List<AccountTransaction> getAllAccountTransaction(@PathVariable("accountNo") Long accountNo){
        return loadTransaction.loadTransaction(accountNo);
    }

}
