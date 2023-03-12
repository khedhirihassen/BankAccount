package com.exaltit.infrastructure.adapter.mapper;

import com.exaltit.domain.model.TransactionType;
import com.exaltit.infrastructure.adapter.persistance.TransactionTypeEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T15:45:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class TransactionTypeMapperImpl implements TransactionTypeMapper {

    @Override
    public TransactionType transactionTypeEntityToTransactionType(TransactionTypeEntity transactionTypeEntity) {
        if ( transactionTypeEntity == null ) {
            return null;
        }

        TransactionType transactionType;

        switch ( transactionTypeEntity ) {
            case DEPOSIT: transactionType = TransactionType.DEPOSIT;
            break;
            case WITHDRAW: transactionType = TransactionType.WITHDRAW;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + transactionTypeEntity );
        }

        return transactionType;
    }

    @Override
    public TransactionTypeEntity transactionTypeToTransactionTypeEntity(TransactionType transactionType) {
        if ( transactionType == null ) {
            return null;
        }

        TransactionTypeEntity transactionTypeEntity;

        switch ( transactionType ) {
            case DEPOSIT: transactionTypeEntity = TransactionTypeEntity.DEPOSIT;
            break;
            case WITHDRAW: transactionTypeEntity = TransactionTypeEntity.WITHDRAW;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + transactionType );
        }

        return transactionTypeEntity;
    }
}
