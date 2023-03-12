package com.exaltit.infrastructure.adapter.mapper;

import com.exaltit.domain.model.Account;
import com.exaltit.infrastructure.adapter.persistance.AccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T03:33:05+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account accountEntityToAccount(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        Account account = new Account();

        account.setAccountNo( accountEntity.getAccountNo() );
        account.setBalance( accountEntity.getBalance() );

        return account;
    }

    @Override
    public AccountEntity accountToAccountEntity(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setAccountNo( account.getAccountNo() );
        accountEntity.setBalance( account.getBalance() );

        return accountEntity;
    }

    @Override
    public List<Account> accountListToAccountEntityList(List<AccountEntity> accountEntityList) {
        if ( accountEntityList == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( accountEntityList.size() );
        for ( AccountEntity accountEntity : accountEntityList ) {
            list.add( accountEntityToAccount( accountEntity ) );
        }

        return list;
    }

    @Override
    public List<AccountEntity> accountEntityListToAccountList(List<Account> accountList) {
        if ( accountList == null ) {
            return null;
        }

        List<AccountEntity> list = new ArrayList<AccountEntity>( accountList.size() );
        for ( Account account : accountList ) {
            list.add( accountToAccountEntity( account ) );
        }

        return list;
    }
}
