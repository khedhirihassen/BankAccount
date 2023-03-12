package com.exaltit.infrastructure.adapter.mapper;

import com.exaltit.domain.model.Account;
import com.exaltit.domain.model.AccountTransaction;
import com.exaltit.infrastructure.adapter.persistance.AccountEntity;
import com.exaltit.infrastructure.adapter.persistance.AccountTransactionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T15:45:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public AccountTransaction accountTransactionEntityToAccountTransaction(AccountTransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }

        AccountTransaction accountTransaction = new AccountTransaction();

        accountTransaction.setTransactionNo( transactionEntity.getTransactionNo() );
        accountTransaction.setDateTransaction( transactionEntity.getDateTransaction() );
        accountTransaction.setAmount( transactionEntity.getAmount() );
        accountTransaction.setAccount( accountEntityToAccount( transactionEntity.getAccount() ) );
        accountTransaction.setTransactionType( transactionEntity.getTransactionType() );

        return accountTransaction;
    }

    @Override
    public AccountTransactionEntity accountTransactionToAccountTransactionEntity(AccountTransaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        AccountTransactionEntity accountTransactionEntity = new AccountTransactionEntity();

        accountTransactionEntity.setTransactionNo( transaction.getTransactionNo() );
        accountTransactionEntity.setDateTransaction( transaction.getDateTransaction() );
        accountTransactionEntity.setAmount( transaction.getAmount() );
        accountTransactionEntity.setAccount( accountToAccountEntity( transaction.getAccount() ) );
        accountTransactionEntity.setTransactionType( transaction.getTransactionType() );

        return accountTransactionEntity;
    }

    @Override
    public List<AccountTransaction> accountTransactionEntityListToAccountTransactionList(List<AccountTransactionEntity> transactionEntityList) {
        if ( transactionEntityList == null ) {
            return null;
        }

        List<AccountTransaction> list = new ArrayList<AccountTransaction>( transactionEntityList.size() );
        for ( AccountTransactionEntity accountTransactionEntity : transactionEntityList ) {
            list.add( accountTransactionEntityToAccountTransaction( accountTransactionEntity ) );
        }

        return list;
    }

    @Override
    public List<AccountTransactionEntity> accountTransactionListToAccountTransactionEntityList(List<AccountTransaction> transactionList) {
        if ( transactionList == null ) {
            return null;
        }

        List<AccountTransactionEntity> list = new ArrayList<AccountTransactionEntity>( transactionList.size() );
        for ( AccountTransaction accountTransaction : transactionList ) {
            list.add( accountTransactionToAccountTransactionEntity( accountTransaction ) );
        }

        return list;
    }

    protected Account accountEntityToAccount(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        Account account = new Account();

        account.setAccountNo( accountEntity.getAccountNo() );
        account.setBalance( accountEntity.getBalance() );

        return account;
    }

    protected AccountEntity accountToAccountEntity(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setAccountNo( account.getAccountNo() );
        accountEntity.setBalance( account.getBalance() );

        return accountEntity;
    }
}
