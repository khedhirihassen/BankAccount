package com.exaltit.infrastructure.adapter.mapper;
import com.exaltit.domain.model.Account;
import com.exaltit.infrastructure.adapter.persistance.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountEntityToAccount(AccountEntity accountEntity);

    AccountEntity accountToAccountEntity(Account account);

    List<Account> accountListToAccountEntityList(List<AccountEntity> accountEntityList);

    List<AccountEntity> accountEntityListToAccountList(List<Account> accountList);

}
