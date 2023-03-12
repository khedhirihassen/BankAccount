package com.exaltit.domain.port.output;

import com.exaltit.domain.model.AccountTransaction;

import java.util.List;

public interface LoadTransaction {
    List<AccountTransaction> loadTransaction(Long accountNo);
}
