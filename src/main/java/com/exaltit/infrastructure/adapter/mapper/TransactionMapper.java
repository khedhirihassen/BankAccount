package com.exaltit.infrastructure.adapter.mapper;


import com.exaltit.domain.model.AccountTransaction;
import com.exaltit.infrastructure.adapter.persistance.AccountTransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    AccountTransaction accountTransactionEntityToAccountTransaction(AccountTransactionEntity transactionEntity);

    AccountTransactionEntity accountTransactionToAccountTransactionEntity(AccountTransaction transaction);

    List<AccountTransaction> accountTransactionEntityListToAccountTransactionList(List<AccountTransactionEntity> transactionEntityList);

    List<AccountTransactionEntity> accountTransactionListToAccountTransactionEntityList(List<AccountTransaction> transactionList);

}
