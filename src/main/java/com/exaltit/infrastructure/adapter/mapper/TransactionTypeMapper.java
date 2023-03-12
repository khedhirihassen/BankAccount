package com.exaltit.infrastructure.adapter.mapper;


import com.exaltit.domain.model.TransactionType;
import com.exaltit.infrastructure.adapter.persistance.TransactionTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionTypeMapper {

    TransactionTypeMapper INSTANCE = Mappers.getMapper(TransactionTypeMapper.class);

    TransactionType transactionTypeEntityToTransactionType(TransactionTypeEntity transactionTypeEntity);

    TransactionTypeEntity transactionTypeToTransactionTypeEntity(TransactionType transactionType);

}
