package com.exaltit.infrastructure.adapter;


import com.exaltit.infrastructure.adapter.persistance.AccountTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<AccountTransactionEntity, Long> {

    List<AccountTransactionEntity> getTransactionByAccountAccountNo(Long accountNo);

}
