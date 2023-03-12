package com.exaltit.infrastructure.adapter;

import com.exaltit.domain.model.AccountTransaction;
import com.exaltit.domain.port.output.LoadTransaction;
import com.exaltit.domain.port.output.SaveTransaction;
import com.exaltit.infrastructure.adapter.mapper.TransactionMapper;
import com.exaltit.infrastructure.adapter.persistance.AccountTransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionAdapter implements SaveTransaction, LoadTransaction {


    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public List<AccountTransaction> loadTransaction(Long accountNo) {
        //return serviceRepository.getTransactionByAccountAccountNo(accountNo);
        List<AccountTransactionEntity> transactionEntityList = transactionRepository
                .getAccountTransactionEntitiesByAccount_AccountNo(accountNo);

        return TransactionMapper.INSTANCE.accountTransactionEntityListToAccountTransactionList(transactionEntityList);
    }

    @Override
    public void saveTransaction(AccountTransaction transaction) {

        AccountTransactionEntity transactionEntity = TransactionMapper.INSTANCE
                .accountTransactionToAccountTransactionEntity(transaction);

        transactionRepository.save(transactionEntity);

    }
}
